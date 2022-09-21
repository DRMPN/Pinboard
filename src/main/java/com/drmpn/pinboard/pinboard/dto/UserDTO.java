package com.drmpn.pinboard.pinboard.dto;

import com.drmpn.pinboard.pinboard.model.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private UserRole role;

    private String email;

    private String password;

}
