# ☕ Java Programs Collection

This directory contains a comprehensive collection of Java programs demonstrating various algorithms, data structures, and programming concepts. Each program is well-documented and designed to be educational.

## 📋 Table of Contents

1. [Prerequisites](#prerequisites)
2. [Getting Started](#getting-started)
3. [Programs Catalog](#programs-catalog)
4. [How to Compile and Run](#how-to-compile-and-run)
5. [Contributing](#contributing)
6. [Resources](#resources)

## Prerequisites

### Required Software

- **JDK (Java Development Kit) 8 or higher**
  - Check version: `java -version` and `javac -version`
  - Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)

### Recommended Tools

- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions
- **Build Tools**: Maven or Gradle (for larger projects)

### Verify Installation

```bash
# Check Java Runtime
java -version

# Check Java Compiler
javac -version

# Expected output format:
# java version "17.0.x" or higher
```

## Getting Started

### Quick Start

```bash
# Clone the repository
git clone https://github.com/username/Code-Contribution.git

# Navigate to Java directory
cd Code-Contribution/Java

# Compile a program
javac HelloWorld.java

# Run the program
java HelloWorld
```

## Programs Catalog

### 🌟 Basic Programs

| Program | Description | Difficulty |
|---------|-------------|------------|
| `HelloWorld.java` | Classic Hello World program | Beginner |
| `SumOfTwoNumbers.java` | Add two numbers | Beginner |
| `factorial.java` | Calculate factorial of a number | Beginner |
| `reverse.java` | Reverse a number | Beginner |

### 🔍 Searching Algorithms

| Program | Description | Time Complexity | Space Complexity | Difficulty |
|---------|-------------|-----------------|------------------|------------|
| `BinarySearch.java` | Binary search on sorted array | O(log n) | O(1) | Beginner |
| `InterpolationSearch.java` | Interpolation search algorithm | O(log log n) avg | O(1) | Intermediate |

### 📊 Sorting Algorithms

| Program | Description | Time Complexity | Space Complexity | Difficulty |
|---------|-------------|-----------------|------------------|------------|
| `BubbleSort.java` | Bubble sort implementation | O(n²) | O(1) | Beginner |
| `insertionSort.java` | Insertion sort algorithm | O(n²) | O(1) | Beginner |
| `SelectionSort.java` | Selection sort algorithm | O(n²) | O(1) | Beginner |
| `QuickSort.java` | Quick sort using divide & conquer | O(n log n) avg | O(log n) | Intermediate |

### 🎯 Advanced Algorithms

| Program | Description | Complexity | Difficulty |
|---------|-------------|------------|------------|
| `KadanesAlgorithm.java` | Maximum subarray sum | O(n) | Intermediate |
| `Krushkal'sAlgorithm.java` | Minimum spanning tree | O(E log E) | Advanced |
| `primsAlgorithm.java` | Minimum spanning tree | O(V²) | Advanced |

### 🧩 String Manipulation

| Program | Description | Difficulty |
|---------|-------------|------------|
| `CheckPalindrome.java` | Check if string is palindrome | Beginner |
| `Palindrome.java` | Palindrome checker | Beginner |
| `Pangram.java` | Check if string is pangram | Intermediate |
| `String_atoi.java` | Convert string to integer | Intermediate |

### 🔢 Array Operations

| Program | Description | Difficulty |
|---------|-------------|------------|
| `SortColors.java` | Dutch National Flag problem | Intermediate |
| `shufflearray.java` | Shuffle array elements | Intermediate |
| `WiggleSort.java` | Wiggle sort implementation | Advanced |
| `TrappedWater.java` | Trapping rainwater problem | Advanced |
| `Trapping_rainwater.java` | Alternative rainwater solution | Advanced |

### 🎲 Matrix Operations

| Program | Description | Difficulty |
|---------|-------------|------------|
| `Matrix Multiplication` | Multiply two matrices | Intermediate |
| `Matrix_Transpose` | Transpose a matrix | Beginner |
| `PrintMatrixDiagonal.java` | Print diagonal elements | Beginner |
| `rotate180` | Rotate matrix 180 degrees | Intermediate |
| `Rotate90.java` | Rotate matrix 90 degrees | Intermediate |
| `SpiralOrderMatrix.java` | Print matrix in spiral order | Advanced |

### 🎮 Problem Solving

| Program | Description | Difficulty |
|---------|-------------|------------|
| `GuessNumber.java` | Number guessing game | Beginner |
| `SudokuSolver.java` | Sudoku puzzle solver | Advanced |
| `Star.java` | Star pattern printing | Beginner |

### 📐 Mathematical Programs

| Program | Description | Difficulty |
|---------|-------------|------------|
| `Pow(x,n).java` | Calculate power efficiently | Intermediate |
| `PrimeFactors.java` | Find prime factors | Intermediate |
| `Java Program to Find the Determinant of a Matrix` | Matrix determinant | Advanced |

### 📚 Data Structures

| Program | Description | Difficulty |
|---------|-------------|------------|
| `FibonacciSeries.java` | Generate Fibonacci sequence | Beginner |
| `fibonacci` | Alternative Fibonacci implementation | Beginner |

## How to Compile and Run

### Method 1: Command Line

#### Step 1: Compile the Java File

```bash
# Basic compilation
javac HelloWorld.java

# Compile with specific Java version
javac -source 11 -target 11 HelloWorld.java

# Compile multiple files
javac *.java
```

#### Step 2: Run the Program

```bash
# Run the compiled program
java HelloWorld

# Run with arguments (if program accepts them)
java ProgramName arg1 arg2
```

### Method 2: Using an IDE

#### IntelliJ IDEA
1. Open the Java file
2. Right-click in the editor
3. Select "Run 'ClassName.main()'"

#### Eclipse
1. Open the Java file
2. Press `Ctrl+F11` (Windows/Linux) or `Cmd+F11` (Mac)
3. Or right-click → Run As → Java Application

#### VS Code
1. Install "Extension Pack for Java"
2. Open the Java file
3. Click "Run" above the main method

### Example: Running BinarySearch.java

```bash
# Compile
javac BinarySearch.java

# Run (follow prompts for input)
java BinarySearch

# Sample Input:
# 5          (size of array)
# 2          (number of queries)
# 1 2 3 4 5  (array elements)
# 3          (search for 3)
# 6          (search for 6)

# Sample Output:
# found 2
# not found
```

### Troubleshooting

#### Error: "javac is not recognized"

**Problem**: Java is not in your PATH

**Solution**:
```bash
# Windows: Add to PATH environment variable
# C:\Program Files\Java\jdk-xx\bin

# macOS/Linux: Add to ~/.bash_profile or ~/.zshrc
export JAVA_HOME=/path/to/jdk
export PATH=$JAVA_HOME/bin:$PATH
```

#### Error: "Could not find or load main class"

**Problem**: Class name doesn't match filename or wrong directory

**Solution**:
- Ensure filename matches class name exactly (case-sensitive)
- Run from the correct directory
- Check for package declarations

#### Error: "java.util.Scanner NoSuchElementException"

**Problem**: Program expects input but none provided

**Solution**:
- Provide required input when prompted
- Check input format matches program expectations

## 📝 Coding Standards

### Java Naming Conventions

- **Classes**: PascalCase (e.g., `BubbleSort`, `HelloWorld`)
- **Methods**: camelCase (e.g., `bubbleSort()`, `findMax()`)
- **Variables**: camelCase (e.g., `arraySize`, `targetValue`)
- **Constants**: UPPER_SNAKE_CASE (e.g., `MAX_SIZE`, `DEFAULT_VALUE`)

### Documentation Requirements

All Java programs should include:

1. **File-level Javadoc**:
```java
/**
 * Brief description of the program
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-19
 */
```

2. **Method-level Javadoc**:
```java
/**
 * Brief method description
 * 
 * @param paramName Description
 * @return Description of return value
 * @throws ExceptionType When this occurs
 */
```

3. **Inline comments** for complex logic

### Code Quality Checklist

Before submitting:
- ✅ Code compiles without errors
- ✅ Follows Java naming conventions
- ✅ Includes proper Javadoc comments
- ✅ Handles edge cases and errors
- ✅ Tested with sample inputs
- ✅ No hardcoded values (use constants)
- ✅ Proper indentation and formatting

## Contributing

### How to Add Your Program

1. **Create your Java file** with proper documentation
2. **Test thoroughly** with various inputs
3. **Update this README** with your program details
4. **Submit a pull request**

### Adding to the Catalog

When adding a new program, update the appropriate table above:

```markdown
| `YourProgram.java` | Brief description | Complexity/Difficulty |
```

### Example Contribution

```java
/**
 * Example Program Description
 * 
 * Detailed explanation of what the program does.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2025-10-19
 */
public class YourProgram {
    // Your implementation
}
```

## 📚 Learning Resources

### Official Documentation
- [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Java SE API Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/)

### Tutorials
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [GeeksforGeeks Java Programming](https://www.geeksforgeeks.org/java/)

### Algorithms
- [Introduction to Algorithms (CLRS)](https://mitpress.mit.edu/9780262046305/introduction-to-algorithms/)
- [Algorithm Visualizer](https://algorithm-visualizer.org/)
- [VisuAlgo](https://visualgo.net/)

### Coding Practice
- [LeetCode](https://leetcode.com/)
- [HackerRank](https://www.hackerrank.com/domains/java)
- [CodeChef](https://www.codechef.com/)

## 🤝 Support

Need help? Here's how to get support:

1. **Check existing programs** for similar examples
2. **Read the documentation** in [CONTRIBUTING.md](../CONTRIBUTING.md)
3. **Open an issue** on GitHub with:
   - Clear description of the problem
   - Code snippet (if applicable)
   - Error messages
   - What you've tried

## 📜 License

All code in this directory is part of the Code-Contribution project.
See [LICENSE](../LICENSE) for details.

---

**Happy Coding! ☕**

Thank you for contributing to this collection of Java programs!
