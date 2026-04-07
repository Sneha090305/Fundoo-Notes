package com.fundoonotes.service.impl;

import com.fundoonotes.entity.Note;
import com.fundoonotes.repository.NoteRepository;
import com.fundoonotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    @Cacheable(value = "notes", key = "#id")
    public Note getNoteById(Long id) {
        System.out.println("Fetching from DB...");
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note.java not found"));
    }

    @Override
    @CachePut(value = "notes", key = "#id")
    public Note updateNote(Long id, Note note) {
        note.setId(id);
        return noteRepository.save(note);
    }

    @Override
    @CacheEvict(value = "notes", key = "#id")
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}