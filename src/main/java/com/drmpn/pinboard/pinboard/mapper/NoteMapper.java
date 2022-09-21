package com.drmpn.pinboard.pinboard.mapper;

import org.mapstruct.Mapper;

import com.drmpn.pinboard.pinboard.dto.NoteDTO;
import com.drmpn.pinboard.pinboard.model.Note;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    
    NoteDTO toDto(Note note);

    Note toNote(NoteDTO dto);
    
}
