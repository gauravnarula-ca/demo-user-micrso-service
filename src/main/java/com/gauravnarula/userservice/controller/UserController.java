package com.gauravnarula.userservice.controller;

import com.gauravnarula.userservice.dto.AddUserDTO;
import com.gauravnarula.userservice.dto.UserDTO;
import com.gauravnarula.userservice.mapper.UserMapper;
import com.gauravnarula.userservice.model.User;
import com.gauravnarula.userservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getUser(){
        return userService.findAll().stream().map(userMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody AddUserDTO addUserDTO){
        return userService.save(addUserDTO);
    }

}
