package com.rea.app.user.controller;

import com.rea.app.common.model.Response;
import com.rea.app.user.dtos.UserRequestDto;
import com.rea.app.user.dtos.UserResponseDto;
import com.rea.app.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response> createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        Response<UserResponseDto> response = this.userService.createUser(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
