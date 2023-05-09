package com.springmvc.SpringMvcBasicProject.modelMapper;

import com.springmvc.SpringMvcBasicProject.Entities.User;
import com.springmvc.SpringMvcBasicProject.dto.UserDto;

public class ModelMapper {

    public static User convertToUser(UserDto userDto)
    {
        User user=new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return user;
    }



    public static UserDto convertToUserDto(User user)
    {
        UserDto userDto =new UserDto();
        userDto.setId(user.getId());

        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
