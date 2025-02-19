package CS282;
public class Hierarchical {

	public static void main(String[] args) {
		Car car = new Car("LX700h", "Lexus", "Premium Unleaded");
		car.start();
		car.stop();
		car.carType();
		
		Bicycle bk = new Bicycle("TrailHunter", "Hero");
		bk.Cycling();
		bk.start();

	}
}

class Vehicle{
	String model, make, fuelType;
	public Vehicle(String model, String make, String fuelType) {
		this.model = model;
		this.make = make;
		this.fuelType = fuelType;
	}
	
	public void start() {
		System.out.println(make + model +" is running on " + fuelType);
	}
	
	public void stop() {
		System.out.println(make + model +" is stopped");
	}
}

class Car extends Vehicle{
	public Car(String model, String make, String fuelType) {
		super(model, make, fuelType);
	}
	
	public void carType() {
		System.out.println("This car is: "+ make + " " + model);
	}
}

class Bike extends Vehicle{
	public Bike(String model, String make, String fuelType) {
		super(model, make, fuelType);
	}
	
	public void popWheel() {
		System.out.println(make + " " + model + " is doing wheeliee.");
	}
}

class Bicycle extends Vehicle{
	public Bicycle(String model, String make) {
		super(model, make, " ");
//		this.model = model;
//		this.make = make;
	}
	
	public void Cycling() {
		System.out.println("that person is cycling " + model + make);
	}
}
