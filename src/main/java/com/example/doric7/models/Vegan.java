package com.example.doric7.models;

/**
 * Sealed interface which restricts only VeganMeal class to implement it.
 */
public sealed interface Vegan permits VeganMeal {
    String getPreparationMethod();

    Long getMinutesToPrepare();
}
