package com.bus.DTO;

import lombok.Data;

//DTO = Data Transfer Object
//This is what the frontend sends to us when registering
@Data
public class UserRegisterDTO {
private String name;
private String email;
private String password;
private String phone;
}