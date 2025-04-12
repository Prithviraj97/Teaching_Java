package CS281_S25;
import java.util.ArrayList;

public class VehicleDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Vehicle> garage = new ArrayList<>();
		garage.add(new Car("Toyota", 2009, 4));
		garage.add(new MotorCycle("Harley Davidson", 2020, false));
		
		for(Vehicle v: garage) {
			System.out.println("-------------- 🚗🏍️");
			System.out.println(v.getDetails());
			v.startEngine();
		}
	}

}
