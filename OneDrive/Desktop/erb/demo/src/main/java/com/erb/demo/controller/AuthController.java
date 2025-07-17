package com.erb.demo.controller;

import com.erb.demo.jwt.JwtTokenProvider;
import com.erb.demo.companyProject.AuthRequest;
import com.erb.demo.companyProject.AuthResponse;
import com.erb.demo.model.Customer;
import com.erb.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = tokenProvider.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}
