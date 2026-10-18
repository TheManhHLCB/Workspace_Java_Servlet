package com.codegym.strategy;
import com.codegym.model.Note;
import java.util.ArrayList;
import java.util.List;

public class NoteFileStrategy implements NoteStrategy {
    // Implement File txt/csv Logic Here
    @Override
    public void save(Note note) { System.out.println("Saved to File"); }
    @Override
    public void delete(int id) { System.out.println("Deleted from File"); }
    @Override
    public List<Note> findAll() { return new ArrayList<>(); }
    @Override
    public List<Note> search(String keyword) { return new ArrayList<>(); }
}
