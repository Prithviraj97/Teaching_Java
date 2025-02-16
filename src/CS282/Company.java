
public class Company {

	public static void main(String[] args) {
		Director director = new Director("Jimmy", "Director", "Human Resources");
		director.work();
		director.conductMeeting();
		director.makeDecision();

	}

}

class Employee{
	String name, position;
	public Employee(String name, String position) {
		this.name = name;
		this.position = position;
	}
	
	public void work() {
		System.out.println(name + " is working as "+ position);
	}
}

//subclass extending the employer class
class Manager extends Employee{
	String department;
	
	public Manager(String name, String position, String department) {
		super(name, position);
		this.department = department;
	}
	
	public void conductMeeting() {
		System.out.println(name + " is conducting a meeting in " + department +" department");
	}
}

//subclass that extends Manager class
class Director extends Manager{
	public Director(String name, String position, String department) {
		super(name, position, department);
	}
	
	public void makeDecision() {
		System.out.println(name + " is making decision for " + department +" department");
	}
}
