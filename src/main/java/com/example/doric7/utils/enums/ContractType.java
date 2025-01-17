package com.example.doric7.utils.enums;

public enum ContractType {
    FULL_TIME("Full time"),
    PART_TIME("Part time");

    private final String label;

    ContractType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
