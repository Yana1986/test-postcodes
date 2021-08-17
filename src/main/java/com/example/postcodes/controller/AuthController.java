package com.example.postcodes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }
}
