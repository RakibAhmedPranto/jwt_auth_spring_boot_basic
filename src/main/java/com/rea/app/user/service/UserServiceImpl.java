package com.rea.app.user.service;

import com.rea.app.common.model.Response;
import com.rea.app.user.dtos.UserRequestDto;
import com.rea.app.user.dtos.UserResponseDto;
import com.rea.app.user.entity.User;
import com.rea.app.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.rea.app.common.ResponseObject.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Response<UserResponseDto> createUser(UserRequestDto userRequestDto) {
//        User user = this.modelMapper.map(userRequestDto, User.class);
        Response<UserResponseDto> response = new Response<>();

        try {
            User user = new User();
            user.setName(userRequestDto.getName());
            user.setEmail(userRequestDto.getEmail());
            user.setPhone(userRequestDto.getPhone());
            user.setPassword(this.passwordEncoder.encode(userRequestDto.getPassword()));

            User savedUser = this.userRepository.save(user);
            UserResponseDto userResponseDto = this.modelMapper.map(savedUser,UserResponseDto.class);
            return dataSavedOrUpdateSuccess(response,userResponseDto,201);
        }catch (RuntimeException ex){
            return dataNotSavedOrUpdate(response);
        }
    }
}
