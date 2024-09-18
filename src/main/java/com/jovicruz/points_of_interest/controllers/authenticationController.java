package com.jovicruz.points_of_interest.controllers;


import com.jovicruz.points_of_interest.domain.user.User;
import com.jovicruz.points_of_interest.dtos.authenticationDTO;
import com.jovicruz.points_of_interest.dtos.loginResponseDTO;
import com.jovicruz.points_of_interest.dtos.registerDTO;
import com.jovicruz.points_of_interest.infra.security.tokenService;
import com.jovicruz.points_of_interest.services.authService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class authenticationController {

    @Autowired
    private authService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private tokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid authenticationDTO data){
        System.out.println(data.getPassword());
        var login = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
        var auth = this.authenticationManager.authenticate(login);

        var token = tokenService.generateToken((User) auth.getPrincipal());


        return ResponseEntity.ok().body(new loginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid registerDTO data){
        if (authService.checkIfExists(data.getLogin())) return ResponseEntity.badRequest().build();
        String encrytedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        User newUser = new User(data.getLogin(), encrytedPassword, data.getRole());
        authService.createNewUser(newUser);

        return ResponseEntity.ok().build();
    }
}
