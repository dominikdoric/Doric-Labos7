package com.example.doric7.models;

/**
 * Sealed interface which restricts only MeatMeal class to implement it.
 */
public sealed interface Meat permits MeatMeal {
    String getPreparationMethod();

    Long getMinutesToPrepare();
}
