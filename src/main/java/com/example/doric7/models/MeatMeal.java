package com.example.doric7.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Represents meal with meat which will be available in the restaurant.
 */
public final class MeatMeal extends Meal implements Meat, Serializable {
    private String freezingMethod;

    public MeatMeal(Long id,
                    String name,
                    Category category,
                    List<Ingredient> ingredients,
                    BigDecimal price,
                    String freezingMethod) {
        super(id, name, category, ingredients, price);
        this.freezingMethod = freezingMethod;
    }

    public String getFreezingMethod() {
        return freezingMethod;
    }

    public void setFreezingMethod(String freezingMethod) {
        this.freezingMethod = freezingMethod;
    }

    @Override
    public String getPreparationMethod() {
        return "";
    }

    @Override
    public Long getMinutesToPrepare() {
        return 0L;
    }
}
