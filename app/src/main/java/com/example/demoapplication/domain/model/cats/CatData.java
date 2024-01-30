package com.example.demoapplication.domain.model.cats;

public class CatData {

    public CatData(String id, String url, int width, int height) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public CatData toCatImage() {
        return new CatData(id, url,width, height);
    }

    @Override
    public String toString() {
        return "CatData{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private String id;
    private String url;
    private int width;
    private int height;
}
