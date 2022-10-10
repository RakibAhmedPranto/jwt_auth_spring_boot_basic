package com.rea.app.user.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {

    private String name;
    @Email(message = "Email is not valid")
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 10, max = 10, message = "Phone number needs to be exactly 10 digit")
    private String phone;
    @NotEmpty
    @Size(min = 8,message = "Password Must be at least 8 character long ")
    private String password;
}
