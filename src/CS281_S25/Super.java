package CS281_S25;

public class Super {
    protected String type;
    
    public Super(String type) {
        this.type = type;
    }
    
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Super {
    private String breed;
    
    public Dog(String breed) {
        super("Dog"); // Call parent constructor with "Dog"
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        super.makeSound(); // Call parent's method first
        System.out.println("Woof!"); // Then add Dog-specific sound
    }
    
    public void printInfo() {
        System.out.println("I am a " + super.type + " of breed " + this.breed);
    }
}
