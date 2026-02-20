package com.gauravnarula.userservice.service;

import com.gauravnarula.userservice.dto.AddUserDTO;
import com.gauravnarula.userservice.dto.UserDTO;
import com.gauravnarula.userservice.mapper.UserMapper;
import com.gauravnarula.userservice.model.User;
import com.gauravnarula.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public UserDTO save(AddUserDTO dto){

        // Convert DTO to Entity

        User user = userMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);

    }


}
