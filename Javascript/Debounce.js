// Debounce
// A debounce function in JavaScript limits how often a given function can be called in quick succession.
// This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
function debounce(func, delay) {
    if (typeof func !== 'function') {
        throw new TypeError('The first argument must be a function.');
    }
    if (typeof delay !== 'number' || delay < 0) {
        throw new TypeError('The second argument must be a positive number.');
    }

    let timeoutId;

    return function(...args) {
        // Clear the previous timeout
        clearTimeout(timeoutId);
        
        // Set a new timeout
        timeoutId = setTimeout(() => {
            func.apply(this, args);
        }, delay);
    };
}
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



