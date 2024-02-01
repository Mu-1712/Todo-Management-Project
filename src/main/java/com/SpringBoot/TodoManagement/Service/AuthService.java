package com.SpringBoot.TodoManagement.Service;

import com.SpringBoot.TodoManagement.Dto.JwtAuthResponse;
import com.SpringBoot.TodoManagement.Dto.LoginDto;
import com.SpringBoot.TodoManagement.Dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    JwtAuthResponse login(LoginDto loginDto);


}
