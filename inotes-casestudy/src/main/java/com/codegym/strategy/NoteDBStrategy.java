package com.codegym.strategy;
import com.codegym.model.Note;
import java.util.ArrayList;
import java.util.List;

public class NoteDBStrategy implements NoteStrategy {
    // Implement JDBC MySQL Database Logic Here
    @Override
    public void save(Note note) { System.out.println("Saved to DB"); }
    @Override
    public void delete(int id) { System.out.println("Deleted from DB"); }
    @Override
    public List<Note> findAll() { return new ArrayList<>(); }
    @Override
    public List<Note> search(String keyword) { return new ArrayList<>(); }
}
