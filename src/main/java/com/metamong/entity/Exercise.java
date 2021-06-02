package com.metamong.entity;


import java.io.Serializable;

public class Exercise implements Serializable {
    int exerciseId;
    String title;
    String difficulty;
    String creator;
    int videoLength;
    String description;

    public Exercise(int id, String title, String difficulty, String creator, int videoLength, String describe) {
        this.exerciseId = id;
        this.title = title;
        this.difficulty = difficulty;
        this.creator = creator;
        this.videoLength = videoLength;
        this.description = describe;
    }

    public Exercise() {

    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(int videoLength) {
        this.videoLength = videoLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
