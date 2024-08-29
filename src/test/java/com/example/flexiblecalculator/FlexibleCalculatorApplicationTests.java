
package com.example.flexiblecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlexibleCalculatorApplicationTests {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2.0, calculator.calculate(Operation.SUBTRACT, 5, 3));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, calculator.calculate(Operation.MULTIPLY, 5, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 6, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testChainOperations() {
        Number result = calculator.chainOperations(5.0, Operation.ADD, 3, Operation.MULTIPLY, 2);
        assertEquals(16.0, result);
    }

    @Test
    public void testUnsupportedOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(Operation.fromString("MOD"), 6, 3);
        });
        assertEquals("Unsupported operation: MOD", exception.getMessage());
    }

    @Test
    public void testAddCustomOperation() {
        calculator.addOperation(Operation.fromString("MOD"), (num1, num2) -> num1.doubleValue() % num2.doubleValue());
        assertEquals(1.0, calculator.calculate(Operation.fromString("MOD"), 10, 3));
    }
}
