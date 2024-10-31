import turtle
t = turtle.Turtle()
t.speed(10)
def draw_star(size):
    for i in range(5):
        t.forward(190)
        t.right(144)
draw_star(100)
turtle.done()
