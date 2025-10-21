#!/usr/bin/env ruby

def palindrome?(s)
    normalized = s.to_s.downcase.gsub(/[^a-z0-9]/i, '')
    normalized == normalized.reverse
end

input = if ARGV.empty?
    STDIN.read
else
    ARGV.join(' ')
end.to_s.strip

if input.empty?
    warn "Usage: check-palindrome.rb \"string to check\""
    exit 1
end

puts palindrome?(input) ? "Palindrome" : "Not a palindrome"