package com.topias.api_connector.model;

public class NewsData {
    private String title;
    private String author;
    private String url;

    public NewsData(String title) {
    }

    public NewsData(String title, String author, String url) {
        this.title = title;
        this.author = author;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

}
