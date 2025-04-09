package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private User user;
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
}
