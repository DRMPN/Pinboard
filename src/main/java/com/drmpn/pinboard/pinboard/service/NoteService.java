package com.drmpn.pinboard.pinboard.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drmpn.pinboard.pinboard.dto.NoteDTO;
import com.drmpn.pinboard.pinboard.dto.UserDTO;
import com.drmpn.pinboard.pinboard.mapper.NoteMapper;
import com.drmpn.pinboard.pinboard.mapper.UserMapper;
import com.drmpn.pinboard.pinboard.model.Note;
import com.drmpn.pinboard.pinboard.model.NoteStatus;
import com.drmpn.pinboard.pinboard.model.User;
import com.drmpn.pinboard.pinboard.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteService {
    
    private final NoteMapper noteMapper;
    private final UserMapper userMapper;
    private final NoteRepository noteRepository;

    @Transactional
    public NoteDTO create(NoteDTO noteDTO) {
        Note note = noteMapper.toNote(noteDTO);
        note = noteRepository.save(note);
        return noteMapper.toDto(note);
    }

    @Transactional
    public NoteDTO findById(Long noteId) throws Exception {
        Note note = noteRepository.findById(noteId).orElseThrow();
        return noteMapper.toDto(note);
    }

    @Transactional
    public List<NoteDTO> findByUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        List<Note> notes = noteRepository.findByUser(user);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByStatus(NoteStatus status) {
        List<Note> notes = noteRepository.findByStatus(status);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByNameContains(String name) {
        List<Note> notes = noteRepository.findByNameContains(name);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByDescriptionContains(String description) {
        List<Note> notes = noteRepository.findByDescriptionContains(description);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByNameAndStatus(String name, NoteStatus status){
        List<Note> notes = noteRepository.findByNameAndStatus(name, status);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByStatusAndDescriptionContains(NoteStatus status, String description) {
        List<Note> notes = noteRepository.findByStatusAndDescriptionContains(status, description);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByUserAndStatus(UserDTO userDTO, NoteStatus noteStatus) {
        User user = userMapper.toUser(userDTO);
        List<Note> notes = noteRepository.findByUserAndStatus(user, noteStatus);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByUserAndNameContains(UserDTO userDTO, String name) {
        User user = userMapper.toUser(userDTO);
        List<Note> notes = noteRepository.findByUserAndNameContains(user, name);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public List<NoteDTO> findByUserAndDescriptionContains(UserDTO userDTO, String description) {
        User user = userMapper.toUser(userDTO);
        List<Note> notes = noteRepository.findByUserAndDescriptionContains(user, description);
        return notes.stream().map(noteMapper::toDto).collect(Collectors.toList());
    }
}
