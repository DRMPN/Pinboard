package com.drmpn.pinboard.pinboard.dto;

import com.drmpn.pinboard.pinboard.model.NoteStatus;
import com.drmpn.pinboard.pinboard.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    
    private Long id;

    private User user;

    private NoteStatus status;

    private String name;
    
    private String description;

    private String pathToImages;
}
