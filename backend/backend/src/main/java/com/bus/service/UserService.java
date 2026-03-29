package com.bus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bus.DTO.UserLoginDTO;
import com.bus.DTO.UserRegisterDTO;
import com.bus.entity.User;
import com.bus.repository.UserRepository;

@Service
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private EmailService emailService;
// REGISTER — save new user to database
public User registerUser(UserRegisterDTO dto) {
// check if email already exists
if (userRepository.existsByEmail(dto.getEmail())) {
throw new RuntimeException("Email already registered!");
}
// create new user object
User user = new User();
user.setName(dto.getName());
user.setEmail(dto.getEmail());
user.setPassword(passwordEncoder.encode(dto.getPassword())); // encrypt password
user.setPhone(dto.getPhone());
// save to database
User savedUser = userRepository.save(user);
// send welcome email
emailService.sendEmail(savedUser.getEmail(),
"Welcome to Bus Booking!",
"Hi " + savedUser.getName() + ", your account is created!");
return savedUser;
}
// LOGIN — check email and password
public User loginUser(UserLoginDTO dto) {
// find user by email
User user = userRepository.findByEmail(dto.getEmail())
.orElseThrow(() -> new RuntimeException("User not found!"));
// check password
if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
throw new RuntimeException("Wrong password!");
}
return user;
}
}
