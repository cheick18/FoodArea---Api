package com.example.demo.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String instructions;
    private int cokingTime;
    private String imageUrl;
@ManyToMany
@JoinTable(
        name = "recipe_ingredients",
        joinColumns = @JoinColumn(name = "recipe_id"),
        inverseJoinColumns = @JoinColumn(name = "ingredienz_id"))
private Set<Ingredient> ingredients;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private AppUser appUser;
    @OneToMany(mappedBy = "recipe")
    Set<Comment> comments;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(name="recipe_tags",
    joinColumns = @JoinColumn(name="recipe_id"),
    inverseJoinColumns =@JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCokingTime() {
        return cokingTime;
    }

    public void setCokingTime(int cokingTime) {
        this.cokingTime = cokingTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Recipe(Long id, String title, String instructions, int cokingTime, String imageUrl, Set<Ingredient> ingredients, AppUser appUser, Set<Comment> comments, Category category, Set<Tag> tags) {
        this.id = id;
        this.title = title;
        this.instructions = instructions;
        this.cokingTime = cokingTime;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.appUser = appUser;
        this.comments = comments;
        this.category = category;
        this.tags = tags;
    }

    public Recipe() {
    }
}
