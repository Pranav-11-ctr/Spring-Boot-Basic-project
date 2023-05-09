package com.springmvc.SpringMvcBasicProject.services.impl;

import com.springmvc.SpringMvcBasicProject.Entities.User;
import com.springmvc.SpringMvcBasicProject.dto.UserDto;
import com.springmvc.SpringMvcBasicProject.exceptions.EmailAlreadyExistsException;
import com.springmvc.SpringMvcBasicProject.exceptions.ResourceNotFoundException;
import com.springmvc.SpringMvcBasicProject.modelMapper.ModelMapper;
import com.springmvc.SpringMvcBasicProject.repository.UserRepository;
import com.springmvc.SpringMvcBasicProject.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> optionalUser=userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent())
        {
            throw new EmailAlreadyExistsException("Email Already Exists");
        }

        User user=ModelMapper.convertToUser(userDto);

        User user1=userRepository.save(user);
        return ModelMapper.convertToUserDto(user1);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id",userId));
        return ModelMapper.convertToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> list=userRepository.findAll();
        List<UserDto> list1=new ArrayList<>();
        for(User user:list)
        {
            list1.add(ModelMapper.convertToUserDto(user));
        }
        return list1;
    }



    @Override
    public UserDto updateUser(UserDto userDto) {
        User existingUser=userRepository.findById(userDto.getId()).orElseThrow(()->new ResourceNotFoundException("user","id", userDto.getId()));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());

        User updatedUser=userRepository.save(existingUser);
        return ModelMapper.convertToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","id", userId));
        userRepository.deleteById(userId);

    }
}
