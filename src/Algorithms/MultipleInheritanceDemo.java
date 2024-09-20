package Algorithms;

// Interface for flying capabilities
interface Flyable {
    void takeOff();
    void land();
    default void fly() {
        System.out.println("Flying...");
    }
}

// Interface for swimming capabilities
interface Swimmable {
    void dive();
    void surface();
    default void swim() { 
        System.out.println("Swimming...");
    }
}

// Interface for data logging
interface Loggable {
    void logAction(String action);
}

// Abstract class for general vehicle properties
abstract class Vehicle {
    private String name;
    private int maxSpeed;

    public Vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public abstract void startEngine();
    public abstract void stopEngine();

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

// Concrete class implementing multiple interfaces and extending an abstract class
class Seaplane extends Vehicle implements Flyable, Swimmable, Loggable {
    private boolean isFlying;
    private boolean isSwimming;

    public Seaplane(String name, int maxSpeed) {
        super(name, maxSpeed);
        this.isFlying = false;
        this.isSwimming = false;
    }

    @Override
    public void startEngine() {
        System.out.println("Starting seaplane engine...");
        logAction("Engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Stopping seaplane engine...");
        logAction("Engine stopped");
    }

    @Override
    public void takeOff() {
        if (!isFlying) {
            System.out.println("Seaplane taking off...");
            isFlying = true;
            isSwimming = false;
            logAction("Took off");
        } else {
            System.out.println("Already in the air!");
        }
    }

    @Override
    public void land() {
        if (isFlying) {
            System.out.println("Seaplane landing on water...");
            isFlying = false;
            isSwimming = true;
            logAction("Landed on water");
        } else {
            System.out.println("Already on water!");
        }
    }

    @Override
    public void dive() {
        if (isSwimming && !isFlying) {
            System.out.println("Seaplane diving...");
            logAction("Dived");
        } else {
            System.out.println("Can't dive when not on water surface!");
        }
    }

    @Override
    public void surface() {
        if (isSwimming && !isFlying) {
            System.out.println("Seaplane surfacing...");
            logAction("Surfaced");
        } else {
            System.out.println("Already on surface or in air!");
        }
    }

    @Override
    public void logAction(String action) {
        System.out.println("Log: " + getName() + " - " + action + " at " + java.time.LocalDateTime.now());
    }

    // Override default method from Flyable interface
    @Override
    public void fly() {
        if (isFlying) {
            System.out.println("Seaplane flying at max speed of " + getMaxSpeed() + " km/h");
            logAction("Flying at max speed");
        } else {
            System.out.println("Need to take off first!");
        }
    }
}

// Main class to demonstrate the usage
public class MultipleInheritanceDemo {
    public static void main(String[] args) {
        Seaplane seaplane = new Seaplane("Albatross", 300);
        
        seaplane.startEngine();
        seaplane.takeOff();
        seaplane.fly();
        seaplane.land();
        seaplane.swim();
        seaplane.dive();
        seaplane.surface();
        seaplane.stopEngine();
    }
}
