package com.springjwt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public ResponseEntity<String> getHello(){
        return new ResponseEntity<>("Merhaba kullanıcı", HttpStatus.OK);
    }
}
