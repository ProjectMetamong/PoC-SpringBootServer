package com.metamong.entity;


public class Exercise {
    int id;
    int thumbnail;
    String title;
    String difficulty;
    String creator;
    int videoLength;
    String describe;

    public Exercise(int id, int thumbnail, String title, String difficulty, String creator, int videoLength, String describe) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.difficulty = difficulty;
        this.creator = creator;
        this.videoLength = videoLength;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
