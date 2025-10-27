# shapes.rb
module Area
  def area
    raise NotImplementedError
  end
end

class Rectangle
  include Area
  attr_reader :w, :h
  def initialize(w, h); @w = w; @h = h; end
  def area; w * h; end
end

r = Rectangle.new(3, 4)
puts "Rectangle area = #{r.area}"