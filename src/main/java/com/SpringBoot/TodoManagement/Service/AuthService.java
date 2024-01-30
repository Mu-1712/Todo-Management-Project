package com.SpringBoot.TodoManagement.Service;

import com.SpringBoot.TodoManagement.Dto.LoginDto;
import com.SpringBoot.TodoManagement.Dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);


}
