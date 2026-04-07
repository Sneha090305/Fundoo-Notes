package com.fundoonotes.service;

import com.fundoonotes.entity.Note;

public interface NoteService {

    Note createNote(Note note);

    Note getNoteById(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);
}