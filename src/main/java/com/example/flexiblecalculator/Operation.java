
package com.example.flexiblecalculator;

public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;

    public static Operation fromString(String operation) {
        switch (operation.toUpperCase()) {
            case "ADD":
                return ADD;
            case "SUBTRACT":
                return SUBTRACT;
            case "MULTIPLY":
                return MULTIPLY;
            case "DIVIDE":
                return DIVIDE;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
    }
}
