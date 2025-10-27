# fibonacci.rb
def fib(n)
  a, b = 0, 1
  n.times { a, b = b, a + b }
  a
end

print "How many Fibonacci numbers? "
m = gets.to_i
(0...m).each { |i| puts "#{i}: #{fib(i)}" }