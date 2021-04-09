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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping( value = "/subs")
    public ResponseEntity<AutenticationResponse> subcribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = bCryptPasswordEncoder.encode(authenticationRequest.getPassword());
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        
        if(userRepository.findByUserName(userName)==null){
            userRepository.save(user);
        } else{
            return ResponseEntity.badRequest().body(new AutenticationResponse("Error exists client subscription"));
        }
        
        return ResponseEntity.ok(new AutenticationResponse("Succesful subscription for client "+ userName));
    }

    @PostMapping( value = "/auth")
    public ResponseEntity<AutenticationResponse> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));    
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AutenticationResponse("Error during Authentication "+ userName));
        }

        UserDetails loadedUser = userService.loadUserByUsername(userName);
        jwtlUtils.generateToken(loadedUser);
        return ResponseEntity.ok(new AutenticationResponse("Succesful Authentication for client "+ userName));   
    }
}
