/**
 * @fileoverview Debounce Function Implementation
 * 
 * This module provides a debounce function that limits how often a given
 * function can be called in quick succession. This is particularly useful
 * for performance optimization when handling frequent events like scroll,
 * resize, or input changes.
 * 
 * @author Code-Contribution Community
 * @version 1.0
 * @license MIT
 */

/**
 * Creates a debounced version of a function that delays its execution
 * until after a specified delay has elapsed since the last time it was invoked.
 * 
 * The debounce technique is used to ensure that time-consuming tasks
 * do not fire so often, improving performance and user experience.
 * 
 * @param {Function} func - The function to debounce
 * @param {number} delay - The delay in milliseconds to wait before executing func
 * 
 * @returns {Function} A new debounced version of the provided function
 * 
 * @throws {TypeError} If func is not a function
 * @throws {TypeError} If delay is not a positive number
 * 
 * @example
 * // Basic usage
 * const debouncedSearch = debounce((query) => {
 *   console.log('Searching for:', query);
 * }, 300);
 * 
 * // Simulate rapid typing
 * debouncedSearch('a');    // Won't execute
 * debouncedSearch('ab');   // Won't execute
 * debouncedSearch('abc');  // Executes after 300ms
 * 
 * @example
 * // Real-world usage with event listeners
 * const handleResize = debounce(() => {
 *   console.log('Window resized to:', window.innerWidth);
 * }, 500);
 * 
 * window.addEventListener('resize', handleResize);
 * 
 * @example
 * // Error handling
 * try {
 *   const invalid = debounce('not a function', 100);
 * } catch (error) {
 *   console.error(error.message); // "The first argument must be a function."
 * }
 */
function debounce(func, delay) {
    // Validate input parameters
    if (typeof func !== 'function') {
        throw new TypeError('The first argument must be a function.');
    }
    if (typeof delay !== 'number' || delay < 0) {
        throw new TypeError('The second argument must be a positive number.');
    }

    /** @type {number|undefined} Stores the timeout ID */
    let timeoutId;

    /**
     * The debounced function that will be returned.
     * Preserves the context (this) and arguments of the original function.
     * 
     * @param {...*} args - Arguments to pass to the original function
     */
    return function(...args) {
        // Clear any existing timeout to reset the delay
        clearTimeout(timeoutId);
        
        // Set a new timeout to execute the function after the delay
        timeoutId = setTimeout(() => {
            func.apply(this, args);
        }, delay);
    };
}

// ============================================================================
// USAGE EXAMPLES AND TESTS
// ============================================================================

/**
 * Example function to be debounced.
 * @param {string} message - The message to log
 */
const logMessage = (message) => {
    console.log(message);
};
// Create a debounced version of logMessage with a 300ms delay
const debouncedLog = debounce(logMessage, 300);
// Simulate rapid calls to the debounced function
debouncedLog('Hello'); // This will not log immediately
debouncedLog('World'); // This will not log immediately
debouncedLog('!');     // This will not log immediately
// After 300ms, "!" will be logged to the console


// Test case 1: Valid function and delay
try {
    const testFunc = () => console.log('Test 1');
    const debouncedTestFunc = debounce(testFunc, 100);
    debouncedTestFunc(); // Should not throw an error
} catch (error) {
    console.error(error);
}

// Test case 2: Invalid function argument
try {
    debounce('notAFunction', 100);
} catch (error) {
    console.error(error.message); // Expected: "The first argument must be a function."
}

// Test case 3: Invalid delay argument (negative number)
try {
    debounce(() => {}, -100);
} catch (error) {
    console.error(error.message); // Expected: "The second argument must be a positive number."
}

// Test case 4: Invalid delay argument (non-number)
try {
    debounce(() => {}, 'notANumber');
} catch (error) {
    console.error(error.message); // Expected: "The second argument must be a positive number."
}



