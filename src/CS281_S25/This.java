package CS281_S25;
/*
 * This class demonstrates the use of the "this" keyword in Java.
 * It is used to refer to the current instance of the class.
 * It can be used to resolve naming conflicts, pass the current instance to methods, and more.
 * It refers to the current object instance you're working with
* It helps distinguish between instance variables and parameters with the same name
* It lets you call other constructors or methods within the same class
 */
public class This {
    private String name; // Instance variable
    
    public This(String name) { // Parameter has same name
        this.name = name; // "this.name" means "my name" (the instance variable)
    }
    
    public void introduce() {
        System.out.println("My name is " + this.name);
    }
}
