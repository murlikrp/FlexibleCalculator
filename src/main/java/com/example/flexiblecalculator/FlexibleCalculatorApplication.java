
package com.example.flexiblecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlexibleCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlexibleCalculatorApplication.class, args);

        // Example usage
        Calculator calculator = new Calculator();
        Number result = calculator.chainOperations(5.0, Operation.ADD, 3, Operation.MULTIPLY, 2);
        System.out.println("Result: " + result);
    }
}
