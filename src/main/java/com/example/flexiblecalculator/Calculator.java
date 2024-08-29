package com.example.flexiblecalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private final Map<Operation, BiFunction<Number, Number, Number>> operationMap;

    public Calculator() {
        operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, (num1, num2) -> num1.doubleValue() + num2.doubleValue());
        operationMap.put(Operation.SUBTRACT, (num1, num2) -> num1.doubleValue() - num2.doubleValue());
        operationMap.put(Operation.MULTIPLY, (num1, num2) -> num1.doubleValue() * num2.doubleValue());
        operationMap.put(Operation.DIVIDE, (num1, num2) -> {
            if (num2.doubleValue() == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return num1.doubleValue() / num2.doubleValue();
        });
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        if (!operationMap.containsKey(op)) {
            throw new IllegalArgumentException("Unsupported operation: " + op);
        }
        return operationMap.get(op).apply(num1, num2);
    }

    public Calculator addOperation(Operation operation, BiFunction<Number, Number, Number> function) {
        operationMap.put(operation, function);
        return this;
    }

    public Number chainOperations(Number initialValue, Operation... operationsAndValues) {
        Number result = initialValue;
        for (int i = 0; i < operationsAndValues.length; i += 2) {
            Operation operation = operationsAndValues[i];
            Number nextValue = operationsAndValues[i + 1];
            result = calculate(operation, result, nextValue);
        }
        return result;
    }
}
