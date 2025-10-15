# JavaScript Directory

This directory contains JavaScript code examples and utilities. Below is a brief description of each file in this directory.

## 📜 JavaScript Coding Standards

### Documentation Requirements

All JavaScript code must follow JSDoc standards for comprehensive documentation:

#### 1. **File-Level Documentation**
Every JavaScript file should start with a `@fileoverview`:
```javascript
/**
 * @fileoverview Brief description of the file's purpose
 * 
 * Detailed description of what this module provides,
 * its main features, and usage patterns.
 * 
 * @author Your Name
 * @version 1.0
 * @license MIT
 */
```

#### 2. **Function Documentation**
All functions must include complete JSDoc:
```javascript
/**
 * Brief description of what the function does.
 * 
 * Detailed explanation including algorithm details,
 * performance characteristics, or important notes.
 * 
 * @param {string} param1 - Description of param1
 * @param {number} [param2=0] - Optional param with default value
 * @param {Object} options - Configuration options
 * @param {boolean} options.enabled - Whether feature is enabled
 * 
 * @returns {Promise<boolean>} Description of return value
 * 
 * @throws {TypeError} When param1 is not a string
 * @throws {RangeError} When param2 is negative
 * 
 * @example
 * const result = await myFunction('test', 5, { enabled: true });
 * console.log(result); // true
 * 
 * @example
 * // Error handling
 * try {
 *   myFunction(123, -1);
 * } catch (error) {
 *   console.error(error.message);
 * }
 * 
 * @see {@link relatedFunction}
 * @since 1.0.0
 */
async function myFunction(param1, param2 = 0, options = {}) {
    // implementation
}
```

#### 3. **Type Annotations**
Use JSDoc type annotations for better IDE support:
```javascript
/** @type {string} */
const userName = 'John';

/** @type {Array<number>} */
const scores = [95, 87, 92];

/** @type {Object<string, number>} */
const ages = { alice: 30, bob: 25 };

/** @type {Function} */
const callback = () => {};

/**
 * @typedef {Object} User
 * @property {string} name - User's name
 * @property {number} age - User's age
 * @property {boolean} isActive - Whether user is active
 */

/** @type {User} */
const user = { name: 'Alice', age: 30, isActive: true };
```

#### 4. **Code Style (Airbnb Style Guide)**
```javascript
// Use const/let, never var
const MAX_SIZE = 100;        // Constants in UPPER_SNAKE_CASE
let currentIndex = 0;        // Variables in camelCase

// Use arrow functions for callbacks
const numbers = [1, 2, 3];
const doubled = numbers.map(n => n * 2);

// Use template literals
const greeting = `Hello, ${userName}!`;

// Use destructuring
const { name, age } = user;
const [first, ...rest] = numbers;

// Use default parameters
function greet(name = 'Guest') {
    return `Hello, ${name}`;
}

// Use async/await over promises
async function fetchData() {
    try {
        const response = await fetch(url);
        return await response.json();
    } catch (error) {
        console.error('Error:', error);
    }
}
```

#### 5. **Best Practices**
- **Naming:** Use `camelCase` for variables/functions, `PascalCase` for classes
- **Semicolons:** Use semicolons consistently
- **Equality:** Use `===` and `!==` (strict equality)
- **Error Handling:** Always handle errors in async code
- **Comments:** Explain "why" not "what"
- **Single Responsibility:** Each function should do one thing well

#### 6. **Module Pattern**
```javascript
/**
 * @module MyModule
 * @description Provides utility functions for data processing
 */

/**
 * Processes data items
 * @param {Array<*>} items - Items to process
 * @returns {Array<*>} Processed items
 */
export function processItems(items) {
    return items.filter(item => item !== null);
}

/**
 * Validates input data
 * @param {*} data - Data to validate
 * @returns {boolean} True if valid
 */
export function validateData(data) {
    return data !== null && data !== undefined;
}
```

## Files

### `Debounce.js`
- **Description**: A debounce function in JavaScript limits how often a given function can be called in quick succession. This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
- **Usage**: The `debounce` function takes two arguments: the function to debounce and the delay in milliseconds. It returns a debounced version of the function.
- **Example**:
  ```javascript
  const logMessage = (message) => {
      console.log(message);
  };
  const debouncedLog = debounce(logMessage, 300);
  debouncedLog('Hello');
  debouncedLog('World');
  debouncedLog('!');
  ```

### `Throttle.js`
- **Description**: A throttle function in JavaScript limits how often a given function can be called in a given time period. This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
- **Usage**: The `throttle` function takes two arguments: the function to throttle and the limit in milliseconds. It returns a throttled version of the function.
- **Example**:
  ```javascript
  const logMessage = (message) => {
      console.log(message);
  };
  const throttledLog = throttle(logMessage, 1000);
  throttledLog('Hello');
  throttledLog('World');
  throttledLog('!');
  ```

### `hello-world.js`
- **Description**: A simple "Hello, World!" program in JavaScript.
- **Usage**: Run the file using a JavaScript runtime like Node.js.
- **Example**:
  ```javascript
  console.log("Hello, World!");
  ```

## Contributing

If you have any JavaScript code examples or utilities that you would like to add to this directory, please follow the contribution guidelines in the main `README.md` file of the repository.
