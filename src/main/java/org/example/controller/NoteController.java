package org.example.controller;

import org.example.model.Note;
import org.example.service.NoteService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping()
    public Note addNote(@RequestParam Long userId, @RequestBody Note note) {
      return noteService.save(userId, note);
    }

    @GetMapping()
    public List<Note> getNotes(Model model) {
//        model.addAttribute("user", noteService.findAll());
        return noteService.findAll();
    }

}
