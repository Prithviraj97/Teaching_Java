// package CS282;

// import java.util.HashMap;
// import java.util.Map;

// public class SimpleCache {
//     private Map<String, Object> cache;

//     public SimpleCache() {
//         cache = new HashMap<>();
//     }

//     // Method to add data to the cache
//     public void put(String key, Object value) {
//         cache.put(key, value);
//     }

//     // Method to retrieve data from the cache
//     public Object get(String key) {
//         return cache.get(key);
//     }

//     // Method to check if the cache contains a key
//     public boolean containsKey(String key) {
//         return cache.containsKey(key);
//     }

//     // Method to remove data from the cache
//     public void remove(String key) {
//         cache.remove(key);
//     }

//     // Method to clear the cache
//     public void clear() {
//         cache.clear();
//     }

//     public static void main(String[] args) {
//         SimpleCache cache = new SimpleCache();

//         // Adding data to the cache
//         cache.put("user1", "John Doe");
//         cache.put("user2", "Jane Smith");

//         // Retrieving data from the cache
//         System.out.println("User1: " + cache.get("user1")); // Output: User1: John Doe

//         // Checking if a key exists in the cache
//         System.out.println("Contains user2? " + cache.containsKey("user2")); // Output: Contains user2? true

//         // Removing data from the cache
//         cache.remove("user1");

//         // Clearing the cache
//         cache.clear();
//     }
// }

interface SmartDevice {
    void turnOn();
    void turnOff();
    void setTemperature(int temp);
    void recordVideo();
}

class SmartLight implements SmartDevice {
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }

    //temperature not really relevant for lights
    public void setTemperature(int temp) {
        throw new UnsupportedOperationException("Light can't set temperature");
    }

    public void recordVideo() {
        throw new UnsupportedOperationException("Light can't record video");
    }
}

class SmartCamera implements SmartDevice {
    public void turnOn() { System.out.println("Camera ON"); }
    public void turnOff() { System.out.println("Camera OFF"); }

    public void setTemperature(int temp) {
        throw new UnsupportedOperationException("Camera doesn't control temperature");
    }

    public void recordVideo() { System.out.println("Recording video..."); }
}


//fix
interface PowerControllable {
    void turnOn();
    void turnOff();
}

interface TemperatureControllable {
    void setTemperature(int temp);
}

interface VideoCapable {
    void recordVideo();
}

class SmartLight implements PowerControllable {
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }
}

class SmartThermostat implements PowerControllable, TemperatureControllable {
    public void turnOn() { System.out.println("Thermostat ON"); }
    public void turnOff() { System.out.println("Thermostat OFF"); }
    public void setTemperature(int temp) {
        System.out.println("Temperature set to " + temp + "°C");
    }
}

class SmartCamera implements PowerControllable, VideoCapable {
    public void turnOn() { System.out.println("Camera ON"); }
    public void turnOff() { System.out.println("Camera OFF"); }
    public void recordVideo() {
        System.out.println("Recording video...");
    }
}
