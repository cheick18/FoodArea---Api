package com.example.demo.dto;

public class CommentResponseDto {
    private Long id;
    private String content;
    private int rating;
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CommentResponseDto(Long id, String content, int rating, String username) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.username = username;
    }
}
