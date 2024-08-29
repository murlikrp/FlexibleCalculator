
# Flexible Calculator

## Overview
This is a simple, extensible calculator implemented in Java that supports multiple operations. The calculator adheres to key object-oriented principles, especially the Open-Closed Principle, and is designed with maintainability and extensibility in mind.

## Assumptions & Design Decisions
- The calculator currently supports the basic operations: ADD, SUBTRACT, MULTIPLY, and DIVIDE.
- The `Operation` enum can be extended to include more operations as needed.
- The `Calculator` class uses a `Map` to store operations, allowing new operations to be added without modifying the existing code.
- The design is compatible with Inversion of Control (IoC) environments like Spring, allowing for external management of dependencies.
- Error handling is implemented to handle unsupported operations and division by zero.

## How to Run
1. Compile the project using Maven.
2. Run the `FlexibleCalculatorApplication` class to see an example of the calculator in action.
3. Run the `FlexibleCalculatorApplicationTests` class to execute unit tests.

## Project Structure
- `src/main/java/com/example/flexiblecalculator/`: Contains the main application and calculator logic.
- `src/test/java/com/example/flexiblecalculator/`: Contains unit tests for the calculator.
