package com.example.doric7.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Represents data about vegan meal available in the restaurant.
 */
public final class VeganMeal extends Meal implements Vegan, Serializable {
    private int numberOfSalads;

    public VeganMeal(Long id,
                     String name,
                     Category category,
                     List<Ingredient> ingredients,
                     BigDecimal price,
                     String origin,
                     int numberOfSalads
    ) {
        super(id, name, category, ingredients, price, origin);
        this.numberOfSalads = numberOfSalads;
    }

    @Override
    public String getPreparationMethod() {
        return "";
    }

    @Override
    public Long getMinutesToPrepare() {
        return 0L;
    }

    public int getNumberOfSalads() {
        return numberOfSalads;
    }

    public void setNumberOfSalads(int numberOfSalads) {
        this.numberOfSalads = numberOfSalads;
    }
}
