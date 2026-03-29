package com.bus.DTO;

import lombok.Data;

//This is what frontend sends when logging in
@Data
public class UserLoginDTO {
private String email;
private String password;
}
