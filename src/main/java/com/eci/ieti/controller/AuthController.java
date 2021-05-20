package com.eci.ieti.controller;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.eci.ieti.configuration.JwtUtils;
import com.eci.ieti.model.AutenticationResponse;
import com.eci.ieti.model.AuthenticationRequest;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtlUtils;

    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping( value = "/user")
    public ResponseEntity<UserModel> dataUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userRepository.findByUserName(name);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping( value = "/dashboard")
    public ResponseEntity<AutenticationResponse> testingToken () {
        return ResponseEntity.ok(new AutenticationResponse(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping( value = "/subs")
    public ResponseEntity<AutenticationResponse> subcribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = bCryptPasswordEncoder.encode(authenticationRequest.getPassword());
        String country = authenticationRequest.getCountry();
        Integer phone = authenticationRequest.getPhone();
        Date birth = authenticationRequest.getBirth();
        UserModel user = new UserModel();
        Pattern p = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");
        Matcher m = p.matcher(userName);
        Boolean b = m.matches();
        user.setUserName(userName);
        user.setPassword(password);
        user.setCountry(country);
        user.setPhone(phone);
        user.setBirth(birth);
        if( userName != null && password != null && Boolean.TRUE.equals(b)){
            userRepository.save(user);
        } else{
            return ResponseEntity.badRequest().body(new AutenticationResponse("Error exists client subscription"));
        }
        return ResponseEntity.ok(new AutenticationResponse("Succesful subscription for client "+ userName));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping( value = "/auth")
    public Token authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));    
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        UserDetails loadedUser = userService.loadUserByUsername(userName);
        return new Token(jwtlUtils.generateToken(loadedUser));
    }


    public class Token
    {
        String accessToken;

        public Token( String accessToken ){
            this.accessToken = accessToken;
        }

        public String getAccessToken(){
            return accessToken;
        }

        public void setAccessToken( String accessToken ){
            this.accessToken = accessToken;
        }
    }
}
