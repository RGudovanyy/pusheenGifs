package com.anviprojects.springIntro.model;

import java.time.LocalDate;

public class Gif {
    private String name;
    private int categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;

    public Gif(String name, int categoryId, String username, LocalDate dateUploaded, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.username = username;
        this.dateUploaded = dateUploaded;
        this.favorite = favorite;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
