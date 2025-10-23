// CheckPalindrome.js
'use strict';

/**
 * Check whether a value is a palindrome.
 * - Accepts string or number (will be converted to string).
 * - By default ignores punctuation/whitespace and is case-insensitive.
 * - Uses Unicode-aware filtering where available.
 *
 * Usage (CLI):
 *   node CheckPalindrome.js "A man, a plan, a canal: Panama"
 *
 * Exported as module for reuse.
 */

function normalize(input, { unicode = true } = {}) {
    const s = String(input).normalize('NFC');
    if (unicode) {
        // keep letters and numbers using Unicode property escapes
        return s.toLowerCase().replace(/[^\p{L}\p{N}]/gu, '');
    }
    // fallback ASCII-only filter
    return s.toLowerCase().replace(/[^a-z0-9]/g, '');
}

function isPalindrome(input, options) {
    const s = normalize(input, options);
    let i = 0, j = s.length - 1;
    while (i < j) {
        if (s[i] !== s[j]) return false;
        i++; j--;
    }
    return true;
}

// CLI entry
if (require.main === module) {
    const text = process.argv.slice(2).join(' ');
    if (!text) {
        console.log('Usage: node CheckPalindrome.js <text>');
        process.exit(1);
    }
    console.log(isPalindrome(text) ? 'true' : 'false');
}

module.exports = isPalindrome;