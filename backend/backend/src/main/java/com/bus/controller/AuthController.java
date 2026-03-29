package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bus.DTO.UserLoginDTO;
import com.bus.DTO.UserRegisterDTO;
import com.bus.entity.User;
import com.bus.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // allow React to call this
public class AuthController {
@Autowired
private UserService userService;
// POST http://localhost:8080/api/auth/register
@PostMapping("/register")
public ResponseEntity<User> register(@RequestBody UserRegisterDTO dto) {
User user = userService.registerUser(dto);
return ResponseEntity.ok(user);
}
// POST http://localhost:8080/api/auth/login
@PostMapping("/login")
public ResponseEntity<User> login(@RequestBody UserLoginDTO dto) {
User user = userService.loginUser(dto);
return ResponseEntity.ok(user);
}
}
