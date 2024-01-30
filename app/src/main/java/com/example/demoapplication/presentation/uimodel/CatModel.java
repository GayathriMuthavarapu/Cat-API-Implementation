package com.example.demoapplication.presentation.uimodel;

public class CatModel {

    private final String id;
    private final String imageUrl;

    public CatModel(String id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
