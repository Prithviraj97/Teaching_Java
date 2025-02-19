package CS282;

// First interface: Defines behavior related to a computer
interface Computer {
    void compute();  // abstract method to perform computations
    String getOperatingSystem();  // returns the operating system of the computer
}

// Second interface: Defines behavior related to a mobile device
interface MobileDevice {
    void makeCall(String contact);  // abstract method to make a call
    int getBatteryLevel();  // returns battery level of the mobile device
}

// The SmartDevice class implements both Computer and MobileDevice interfaces
class SmartDevice implements Computer, MobileDevice {
    
    private String operatingSystem;
    private int batteryLevel;

    // Constructor to initialize the smart device
    public SmartDevice(String operatingSystem, int batteryLevel) {
        this.operatingSystem = operatingSystem;
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void compute() {
        System.out.println("Performing computations on " + operatingSystem);
    }

    @Override
    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public void makeCall(String contact) {
        if (batteryLevel > 10) {
            System.out.println("Calling " + contact + " from the mobile device.");
        } else {
            System.out.println("Battery too low to make a call.");
        }
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }

    // A custom method specific to SmartDevice
    public void chargeDevice(int chargeAmount) {
        batteryLevel += chargeAmount;
        System.out.println("Device charged. Current battery level: " + batteryLevel + "%");
    }
}

public class multipleInherit {
    public static void main(String[] args) {
        // Create a new SmartDevice object
        SmartDevice smartDevice = new SmartDevice("Android", 20);

        smartDevice.compute();
        System.out.println("Operating System: " + smartDevice.getOperatingSystem());

        smartDevice.makeCall("John Doe");
        System.out.println("Battery level: " + smartDevice.getBatteryLevel() + "%");

        smartDevice.chargeDevice(30);
       
        smartDevice.makeCall("Alice");
    }
}
