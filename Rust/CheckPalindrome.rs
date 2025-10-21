use std::env;
use std::io::{self, Read};
use super::is_palindrome;

/// Returns true if `s` is a palindrome.
/// Non-alphanumeric characters are ignored and comparison is case-insensitive.
fn is_palindrome(s: &str) -> bool {
    let normalized: String = s
        .chars()
        .flat_map(|c| c.to_lowercase()) // handle Unicode case folding that can produce multiple chars
        .filter(|c| c.is_alphanumeric())
        .collect();

    normalized == normalized.chars().rev().collect::<String>()
}

fn main() {
    // If arguments are provided, use them as the input string.
    // Otherwise read from stdin.
    let args: Vec<String> = env::args().skip(1).collect();
    let input = if !args.is_empty() {
        args.join(" ")
    } else {
        let mut buf = String::new();
        io::stdin()
            .read_to_string(&mut buf)
            .expect("Failed to read from stdin");
        buf
    };

    let input_trimmed = input.trim();
    if input_trimmed.is_empty() {
        eprintln!("Provide a string as an argument or via stdin.");
        std::process::exit(1);
    }

    if is_palindrome(input_trimmed) {
        println!("\"{}\" is a palindrome", input_trimmed);
    } else {
        println!("\"{}\" is not a palindrome", input_trimmed);
    }
}

#[cfg(test)]
mod tests {

    #[test]
    fn simple_palindromes() {
        assert!(is_palindrome("madam"));
        assert!(is_palindrome("A man, a plan, a canal: Panama"));
        assert!(is_palindrome("No 'x' in Nixon"));
        assert!(is_palindrome("Able was I, ere I saw Elba"));
    }

    #[test]
    fn non_palindromes() {
        assert!(!is_palindrome("hello"));
        assert!(!is_palindrome("rust"));
    }

    #[test]
    fn unicode_handling() {
        // German sharp s ß lowercases to "ss" in some contexts; this test ensures handling doesn't panic
        assert!(is_palindrome("ßs")); // "ßs" -> "sss" normalized -> palindrome
    }
}