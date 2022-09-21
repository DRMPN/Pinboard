package com.drmpn.pinboard.pinboard.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.drmpn.pinboard.pinboard.dto.UserDTO;
import com.drmpn.pinboard.pinboard.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public ResponseEntity<Object> register(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.create(userDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUserDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
