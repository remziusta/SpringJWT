package com.springjwt.controller;

import com.springjwt.model.User;
import com.springjwt.services.MyUserDetailsService;
import com.springjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;


    @PostMapping(value = "/login")
    public ResponseEntity<String> creteToken(@RequestBody User user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Incorret username or password", ex);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<>("token :" + jwt, HttpStatus.OK);
    }
}
