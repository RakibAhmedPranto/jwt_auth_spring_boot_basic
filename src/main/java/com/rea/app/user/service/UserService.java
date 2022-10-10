package com.rea.app.user.service;

import com.rea.app.common.model.Response;
import com.rea.app.user.dtos.UserRequestDto;
import com.rea.app.user.dtos.UserResponseDto;

public interface UserService {
    Response<UserResponseDto> createUser(UserRequestDto userRequestDto);
}
