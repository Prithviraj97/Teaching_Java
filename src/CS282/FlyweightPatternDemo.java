package CS282;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Shape {
    void draw(int x, int y);
}

// Concrete Flyweight class
class Circle implements Shape {
    private final String color; // Intrinsic state

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a " + color + " circle at (" + x + ", " + y + ")");
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating a new circle of color: " + color);
        }
        return circle;
    }
}

// Client code
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        Shape redCircle1 = ShapeFactory.getCircle("Red");
        redCircle1.draw(10, 20);

        Shape redCircle2 = ShapeFactory.getCircle("Red");
        redCircle2.draw(30, 40);

        Shape blueCircle = ShapeFactory.getCircle("Blue");
        blueCircle.draw(50, 60);

        // Output will show that the red circle is reused
    }
}
