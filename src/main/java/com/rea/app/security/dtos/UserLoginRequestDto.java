package com.rea.app.security.dtos;

import lombok.Data;
import org.jboss.jandex.PrimitiveType;

@Data
public class UserLoginRequestDto {
    private String username;
    private String password;
}
