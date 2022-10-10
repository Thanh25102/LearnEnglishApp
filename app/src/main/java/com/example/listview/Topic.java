package com.example.listview;

public class Topic {
    private Integer id;
    private String represent;
    private String description;
    private String descriptiveMeaning;
    private String lessonId;

    public Topic(String represent, String description, String descriptiveMeaning, String lessonId) {
        this.represent = represent;
        this.description = description;
        this.descriptiveMeaning = descriptiveMeaning;
        this.lessonId = lessonId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptiveMeaning() {
        return descriptiveMeaning;
    }

    public void setDescriptiveMeaning(String descriptiveMeaning) {
        this.descriptiveMeaning = descriptiveMeaning;
    }

    public String getLessonId() {
        return lessonId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }
}
