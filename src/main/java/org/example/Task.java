package org.example;

public class Task {
    private int id;
    private String title;
    private String description;
    
    public Task() {
    }
    
    public Task(String title) {
        this.title = title;
        
    }
    
    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + "]";
    }
    
    public String toRecord() {
        return id + " , " + title + " , " + description;
    }
}
