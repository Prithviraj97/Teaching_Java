package CS281_S25;

public class This {
    private String name; // Instance variable
    
    public This(String name) { // Parameter has same name
        this.name = name; // "this.name" means "my name" (the instance variable)
    }
    
    public void introduce() {
        System.out.println("My name is " + this.name);
    }
}
