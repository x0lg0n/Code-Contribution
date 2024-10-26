// Throttle
// A throttle function in JavaScript limits how often a given function can be called in a given time period.
// This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
function throttle(func, limit) {
    // Input validation
    if (typeof func !== 'function') {
        throw new TypeError('The first argument must be a function.');
    }
    if (typeof limit !== 'number' || limit <= 0) {
        throw new TypeError('The second argument must be a positive number.');
    }

    let lastFunc;
    let lastRan;

    return function(...args) {
        const context = this;
        if (!lastRan) {
            func.apply(context, args);
            lastRan = Date.now();
        } else {
            clearTimeout(lastFunc);
            lastFunc = setTimeout(function() {
                if ((Date.now() - lastRan) >= limit) {
                    func.apply(context, args);
                    lastRan = Date.now();
                }
            }, limit - (Date.now() - lastRan));
        }
    };
}

// Example usage:
const logMessage = (message) => {
    console.log(message);
};

// Create a throttled version of logMessage with a 1000ms limit
const throttledLog = throttle(logMessage, 1000);

// Simulate rapid calls to the throttled function
throttledLog('Hello'); // Logs immediately
throttledLog('World'); // Ignored (within 1000ms)
throttledLog('!');     // Ignored (within 1000ms)

// After 1000ms, the next call will log
setTimeout(() => throttledLog('Throttled!'), 1000); // Logs "Throttled!" after 1000ms




// Test case 1: Valid function and limit
try {
    const testFunc = () => console.log('Test 1');
    const throttledTestFunc = throttle(testFunc, 100);
    throttledTestFunc(); // Should not throw an error
} catch (error) {
    console.error(error);
}

// Test case 2: Invalid function argument
try {
    throttle('notAFunction', 100);
} catch (error) {
    console.error(error.message); // Expected: "The first argument must be a function."
}

// Test case 3: Invalid limit argument (negative number)
try {
    throttle(() => {}, -100);
} catch (error) {
    console.error(error.message); // Expected: "The second argument must be a positive number."
}

// Test case 4: Invalid limit argument (zero)
try {
    throttle(() => {}, 0);
} catch (error) {
    console.error(error.message); // Expected: "The second argument must be a positive number."
}

// Test case 5: Invalid limit argument (non-number)
try {
    throttle(() => {}, 'notANumber');
} catch (error) {
    console.error(error.message); // Expected: "The second argument must be a positive number."
}