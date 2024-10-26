// Debounce
// A debounce function in JavaScript limits how often a given function can be called in quick succession.
// This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
function debounce(func, delay) {
    let timer;
    return function (...args) {
      clearTimeout(timer);
      timer = setTimeout(() => func.apply(this, args), delay);
    };
}
// Throttle
// A throttle function in JavaScript limits how often a given function can be called in a given time period.
// This is particularly useful when handling events like scroll or resize, where frequent firing can impact performance.
function throttle(func, delay) {
    let lastCall = 0;
    return function (...args) {
      const now = Date.now();
      if (now - lastCall >= delay) {
        lastCall = now;
        func.apply(this, args);
      }
    };
}
  