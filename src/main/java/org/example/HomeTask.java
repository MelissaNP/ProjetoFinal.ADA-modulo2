package org.example;

public class HomeTask extends Task {
    private int id;
    private String title;
    private String description;

    public HomeTask() {
    }

    public HomeTask(String title) {
        super(title);
    }

    public HomeTask(int id, String title) {
        super(id, title);
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

    @Override
    public String toString() {
        return "HomeTask [id=" + getId() + ", title=" + getTitle() + ", description=" + getDescription() + "]";
    }

    @Override
    public String toRecord() {
        return getId() + " , " + getTitle() + " , " + getDescription();
    }
}
