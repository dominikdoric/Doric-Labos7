package com.example.doric7.restaurant.exception;

/**
 * Exception which is thrown when user inserts entity which he already inserted.
 */
public class EntityAlreadyInsertedException extends Exception {
    public EntityAlreadyInsertedException(String message) {
        super(message);
    }
}
