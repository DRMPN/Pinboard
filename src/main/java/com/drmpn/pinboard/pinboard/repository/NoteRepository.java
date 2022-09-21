package com.drmpn.pinboard.pinboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drmpn.pinboard.pinboard.model.Note;
import com.drmpn.pinboard.pinboard.model.NoteStatus;
import com.drmpn.pinboard.pinboard.model.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Optional<Note> findById(Long id);

    List<Note> findByUser(User user);

    List<Note> findByStatus(NoteStatus status);

    List<Note> findByName(String name);

    List<Note> findByDescription(String description);

    List<Note> findByNameAndDescription(String name, String description);

    List<Note> findByNameAndStatus(String name, NoteStatus status);

    List<Note> findByNameAndStatusAndDescription(
            String name,
            NoteStatus status,
            String description);

    List<Note> findByUserAndDescription(User user, String description);

    List<Note> findByUserAndStatus(User user, NoteStatus status);

    List<Note> findByUserAndName(User user, String name);

}
