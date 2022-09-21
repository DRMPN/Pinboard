package com.drmpn.pinboard.pinboard.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drmpn.pinboard.pinboard.dto.UserDTO;
import com.drmpn.pinboard.pinboard.mapper.UserMapper;
import com.drmpn.pinboard.pinboard.model.User;
import com.drmpn.pinboard.pinboard.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }
    
    @Transactional
    public UserDTO getUserById(Long userId) {
        // TODO: error handlae
        User user = userRepository.findById(userId).orElseThrow();
        return userMapper.toDto(user);
    }

    @Transactional
    public UserDTO getUserByEmail(String email) {
        // TODO: error handle
        User user = userRepository.findByEmail(email).orElseThrow();
        return userMapper.toDto(user);
    }

}
