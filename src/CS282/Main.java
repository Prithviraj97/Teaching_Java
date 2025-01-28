package CS282;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("John", 20);
        Person person2 = new Person("Jane", 25);
        person.printInfo();
        person2.printInfo();

        person.growOlder();
        person2.growOlder();

        person.printInfo();
        person2.printInfo();
    }
    
}

class Person{
    String name;
    int age;
    public Person(String name, int age){
        this.name = name;
        this.age = 0;
    }
    public void printInfo(){
        System.out.println("Name: " + name + " Age: " + age);
    }

    public void growOlder(){
        age++;
    }
}
