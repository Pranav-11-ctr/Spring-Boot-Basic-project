package com.springmvc.SpringMvcBasicProject.controller;

import com.springmvc.SpringMvcBasicProject.Entities.User;
import com.springmvc.SpringMvcBasicProject.dto.UserDto;
import com.springmvc.SpringMvcBasicProject.exceptions.ErrorDetails;
import com.springmvc.SpringMvcBasicProject.exceptions.ResourceNotFoundException;
import com.springmvc.SpringMvcBasicProject.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name="Crud REST APIs for User Ressource",
        description = "CRUD REST APIs - Create User, Update User, Get User,Get All Users, Delete User"
)
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;


    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is Used to Save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status Code 201 Created"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        UserDto user1=userService.createUser(userDto);
        return  new ResponseEntity<>(user1, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By Id REST API is Used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 Success"
    )
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Long userId)
    {
        UserDto user=userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    @Operation(
            summary = "Get All user REST API",
            description = "Get All User REST API is Used to Save user in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 Success"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getSingleUser()
    {
        List<UserDto> list=userService.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is Used to delete a particular user in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 Success"
    )
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteById(@PathVariable Long userId)
    {
        userService.deleteUser(userId);
        return  ResponseEntity.ok("Deleted Successfully");
    }
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is Used to Update a particular user in a database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status Code 200 Success"
    )
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId,@RequestBody UserDto userDto)
    {
        userDto.setId(userId);
        UserDto user1=userService.updateUser(userDto);
        return  ResponseEntity.ok(user1);
    }


    //We can write this exception in controller also or in GlobalException handler
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest)
//    {
//        ErrorDetails errorDetails=new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "User Not Found",
//                "Pranav Kumar"
//        );
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//    }




}
