package com.eci.ieti.controller;

import com.eci.ieti.configuration.JwtUtils;
import com.eci.ieti.model.AutenticationResponse;
import com.eci.ieti.model.AuthenticationRequest;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.repo.UserRepository;
import com.eci.ieti.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping( value = "/dashboard")
    public ResponseEntity<AutenticationResponse> testingToken () {
        return ResponseEntity.ok(new AutenticationResponse(SecurityContextHolder.getContext().getAuthentication().getName()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping( value = "/subs")
    public ResponseEntity<AutenticationResponse> subcribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = bCryptPasswordEncoder.encode(authenticationRequest.getPassword());
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        System.out.println("username"+ userName);
        System.out.println("username"+ authenticationRequest.getPassword());
        System.out.println(userRepository.findByUserName(userName));
        if(userRepository.findByUserName(userName)==null || userName == null){
            userRepository.save(user);
        } else{
            return ResponseEntity.badRequest().body(new AutenticationResponse("Error exists client subscription"));
        }
        return ResponseEntity.ok(new AutenticationResponse("Succesful subscription for client "+ userName));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping( value = "/auth")
    public Token authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println("dddddddddd");
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();
        System.out.println("dddddddddd");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));    
        } catch (Exception e) {
            throw e;
        }

        UserDetails loadedUser = userService.loadUserByUsername(userName);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return new Token(jwtlUtils.generateToken(loadedUser));
    }


    public class Token
    {

        String accessToken;


        public Token( String accessToken )
        {
            this.accessToken = accessToken;
        }


        public String getAccessToken()
        {
            return accessToken;
        }

        public void setAccessToken( String access_token )
        {
            this.accessToken = access_token;
        }
    }
}
