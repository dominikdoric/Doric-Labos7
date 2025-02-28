package com.example.doric7.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Represents a meal which will be available in the restaurant.
 */
public class Meal extends Entity implements Serializable {
    private String name;
    private Category category;
    private List<Ingredient> ingredients;
    private BigDecimal price;
    private String origin;

    public Meal(Long id, String name, Category category, List<Ingredient> ingredients, BigDecimal price, String origin) {
        super(id);
        this.name = name;
        this.category = category;
        this.ingredients = ingredients;
        this.price = price;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
