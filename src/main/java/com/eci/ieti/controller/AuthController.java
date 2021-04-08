package com.eci.ieti.controller;

import com.eci.ieti.model.AutenticationResponse;
import com.eci.ieti.model.AuthenticationRequest;
import com.eci.ieti.model.UserModel;
import com.eci.ieti.persistence.repository.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping( value = "/auth")
    public ResponseEntity<AutenticationResponse> subcribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();
        UserModel user = new UserModel();
        user.setUserName(userName);
        user.setPassword(password);
        userRepository.save(user);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return ResponseEntity.ok(new AutenticationResponse("Error during client subscription "+ userName));    
        }
        return ResponseEntity.ok(new AutenticationResponse("Succesful subscription for client "+ userName));
    }

    @PostMapping( value = "/subs")
    public ResponseEntity<AutenticationResponse> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
        String userName = authenticationRequest.getUserName();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));    
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok(new AutenticationResponse("Error during Authentication"+ userName));
        }
        return ResponseEntity.ok(new AutenticationResponse("Succesful Authentication for client "+ userName));   
    }
}
