package com.codegym.model;
public class Note {
    private int id;
    private String title;
    private String content;
    private int typeId;
    public Note() {}
    public Note(int id, String title, String content, int typeId) {
        this.id = id; this.title = title; this.content = content; this.typeId = typeId;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public int getTypeId() { return typeId; }
    public void setTypeId(int typeId) { this.typeId = typeId; }
}
