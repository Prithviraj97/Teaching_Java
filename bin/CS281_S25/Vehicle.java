public class Vehicle {
	protected String brand;
	protected int year;
	
	public Vehicle(String brand, int year) {
		this.brand = brand;
		this.year = year;
	}
	
	public void startEngine() {
		System.out.println(brand + " (" +year + ") engine starts with a sound...");
	}
	
	public void stopEngine() {
		System.out.println("Vehicle is stopped");
	}
	
	public String getDetails() {
		return brand + " - Year: " + year;
	}
}

class Car extends Vehicle{
	private int numDoors;
	
	public Car(String brand, int year, int doors) {
		super(brand, year);
		this.numDoors = doors;
	}
	
	@override
	public void startEngine() {
		System.out.println(brand + " car goes: vroom vroom 🚗");
	}
	
	public String getDetails() {
		return super.getDetails() + " |Car | Doors: " + numDoors;
	}
}

class MotorCycle extends Vehicle{
	private boolean sideCar;
	
	public MotorCycle(String brand, int year, boolean sideCar) {
		super(brand, year);
		this.sideCar = sideCar;
	}
	
	@override
	public void startEngine() {
		System.out.println(brand + " bike goes:  broom broom 🏍️");
	}
	
	public String getDetails() {
		return super.getDetails() + " | Motorcycle | side car: " + (sideCar ? "yes": "no");
	}
}
