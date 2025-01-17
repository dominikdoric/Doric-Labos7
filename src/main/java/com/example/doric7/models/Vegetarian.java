package com.example.doric7.models;

/**
 * Sealed interface which restricts only VegetarianMeal class to implement it.
 */
public sealed interface Vegetarian permits VegetarianMeal {
    String getPreparationMethod();

    Long getMinutesToPrepare();
}
