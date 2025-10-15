# Java Directory

This directory contains Java programs demonstrating various algorithms and data structures. Each file is a self-contained example of a specific algorithm or data structure.

## ☕ Java Coding Standards

### Documentation Requirements

All Java code in this directory must follow these JavaDoc standards:

#### 1. **Class-Level JavaDoc**
Every class should have comprehensive JavaDoc:
```java
/**
 * ClassName - Brief one-line description
 * 
 * <p>Detailed description of the class purpose, functionality,
 * and any important implementation details.</p>
 * 
 * <h2>Key Features:</h2>
 * <ul>
 *   <li>Feature 1</li>
 *   <li>Feature 2</li>
 * </ul>
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-15
 * 
 * @see RelatedClass
 */
public class ClassName {
    // class implementation
}
```

#### 2. **Method JavaDoc**
All public methods must include complete JavaDoc:
```java
/**
 * Brief description of what the method does.
 * 
 * <p>More detailed explanation if needed, including
 * algorithm description and complexity analysis.</p>
 * 
 * @param param1 Description of first parameter
 * @param param2 Description of second parameter
 * @return Description of return value
 * 
 * @throws IllegalArgumentException When param is invalid
 * @throws NullPointerException When param is null
 * 
 * @example
 * <pre>{@code
 * MyClass obj = new MyClass();
 * int result = obj.methodName("test", 5);
 * System.out.println(result); // Output: 10
 * }</pre>
 * 
 * @see #relatedMethod()
 */
public int methodName(String param1, int param2) {
    // implementation
}
```

#### 3. **Field Documentation**
Document all class fields:
```java
/** The maximum buffer size in bytes */
private static final int MAX_BUFFER_SIZE = 1024;

/** Current state of the processor */
private ProcessorState state;
```

#### 4. **Code Style (Google Java Style Guide)**
```java
// Naming Conventions
public class MyClassName { }          // PascalCase for classes
public void myMethodName() { }        // camelCase for methods
private int myVariableName;           // camelCase for variables
public static final int MAX_SIZE = 100; // UPPER_SNAKE_CASE for constants

// Formatting
public class Example {
    // 4 spaces for indentation (no tabs)
    private int field;
    
    public void method() {
        if (condition) {
            // Opening brace on same line
            doSomething();
        } else {
            doSomethingElse();
        }
    }
}
```

#### 5. **Best Practices**
- **Immutability:** Prefer `final` for variables that don't change
- **Exception Handling:** Use specific exceptions, document with `@throws`
- **Null Safety:** Check for null, document when nulls are allowed
- **Generics:** Use type parameters for type safety
- **Resource Management:** Use try-with-resources for AutoCloseable

#### 6. **Example Pattern**
```java
/**
 * DataProcessor - Processes data with various transformations
 * 
 * <p>This class provides methods to process, transform, and validate
 * data according to specified rules.</p>
 * 
 * @author Code-Contribution Community
 * @version 1.0
 */
public class DataProcessor {
    
    /** Maximum number of items to process */
    private static final int MAX_ITEMS = 1000;
    
    /**
     * Processes a list of items.
     * 
     * @param items List of items to process (must not be null)
     * @return Number of successfully processed items
     * @throws IllegalArgumentException if items list is empty
     * @throws NullPointerException if items is null
     */
    public int processItems(List<String> items) {
        if (items == null) {
            throw new NullPointerException("Items cannot be null");
        }
        // implementation
        return 0;
    }
}
```

## List of Programs

1. `BinarySearch.java`: Implementation of the binary search algorithm.
2. `BubbleSort.java`: Implementation of the bubble sort algorithm.
3. `HelloWorld.java`: A simple program that prints "Hello World!".
4. `insertionSort.java`: Implementation of the insertion sort algorithm.
5. `InterpolationSearch.java`: Implementation of the interpolation search algorithm.

## How to Run

To run any of the Java programs in this directory, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the directory containing the Java file you want to run.
3. Compile the Java file using the `javac` command. For example, to compile `HelloWorld.java`, run:
   ```bash
   javac HelloWorld.java
   ```
4. Run the compiled Java program using the `java` command. For example, to run `HelloWorld`, run:
   ```bash
   java HelloWorld
   ```

## Contribution Guidelines

If you would like to contribute to this directory, please follow these guidelines:

1. Ensure your code is well-documented and follows the coding standards.
2. Add a brief description of your program in this `README.md` file.
3. Ensure your program is placed in the correct directory.
4. Test your program thoroughly before submitting a pull request.

Thank you for your contributions!
