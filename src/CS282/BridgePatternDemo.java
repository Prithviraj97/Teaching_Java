package CS282;

/*
 * The Bridge Design Pattern is a structural pattern that decouples an abstraction from its implementation so that 
 * the two can vary independently. It's especially useful when you want to avoid a permanent binding between an 
 * abstraction and its implementation.
 */
// Implementor
interface Color {
    String fill();
}

// Concrete Implementors
class Red implements Color {
    @Override
    public String fill() {
        return "Red";
    }
}

class Blue implements Color {
    @Override
    public String fill() {
        return "Blue";
    }
}

// Abstraction
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstractions
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing Circle in " + color.fill() + " color.");
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.println("Drawing Square in " + color.fill() + " color.");
    }
}

// Demo
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red());
        Shape blueSquare = new Square(new Blue());

        redCircle.draw();   // Output: Drawing Circle in Red color.
        blueSquare.draw();  // Output: Drawing Square in Blue color.
    }
}
