# cli.rb
require 'optparse'

options = { times: 1 }
OptionParser.new do |opts|
  opts.banner = "Usage: cli.rb [options]"

  opts.on("-nN", "--number=N", Integer, "Number of times") do |n|
    options[:times] = n
  end

  opts.on("-mMSG", "--message=MSG", "Message to print") do |m|
    options[:message] = m
  end
end.parse!

msg = options[:message] || "Hello"
options[:times].times { puts msg }