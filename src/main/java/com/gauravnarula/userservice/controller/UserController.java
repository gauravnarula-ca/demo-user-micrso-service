package com.gauravnarula.userservice.controller;

import com.gauravnarula.userservice.dto.AddUserDTO;
import com.gauravnarula.userservice.dto.UserDTO;
import com.gauravnarula.userservice.mapper.UserMapper;
import com.gauravnarula.userservice.model.User;
import com.gauravnarula.userservice.service.UserService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Data
@RequestMapping("api/v1")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/user/all")
    public List<UserDTO> getUser(){
        return userService.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("user/{id}")
    public List<UserDTO> getUserById(@PathVariable Long id){
        List<UserDTO> list = userService.findById(id).stream().map(userMapper::toDTO).toList();
        if (list.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }
        return list;
    }

    @PostMapping("user/add")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerUser(@RequestBody AddUserDTO addUserDTO){
        return userService.save(addUserDTO);
    }

}
