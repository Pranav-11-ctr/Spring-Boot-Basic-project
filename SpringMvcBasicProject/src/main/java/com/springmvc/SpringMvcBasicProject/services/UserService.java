package com.springmvc.SpringMvcBasicProject.services;

import com.springmvc.SpringMvcBasicProject.Entities.User;
import com.springmvc.SpringMvcBasicProject.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);
}
