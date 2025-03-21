package CS282;

import java.util.HashMap;
import java.util.Map;

public class SimpleCache {
    private Map<String, Object> cache;

    public SimpleCache() {
        cache = new HashMap<>();
    }

    // Method to add data to the cache
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    // Method to retrieve data from the cache
    public Object get(String key) {
        return cache.get(key);
    }

    // Method to check if the cache contains a key
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    // Method to remove data from the cache
    public void remove(String key) {
        cache.remove(key);
    }

    // Method to clear the cache
    public void clear() {
        cache.clear();
    }

    public static void main(String[] args) {
        SimpleCache cache = new SimpleCache();

        // Adding data to the cache
        cache.put("user1", "John Doe");
        cache.put("user2", "Jane Smith");

        // Retrieving data from the cache
        System.out.println("User1: " + cache.get("user1")); // Output: User1: John Doe

        // Checking if a key exists in the cache
        System.out.println("Contains user2? " + cache.containsKey("user2")); // Output: Contains user2? true

        // Removing data from the cache
        cache.remove("user1");

        // Clearing the cache
        cache.clear();
    }
}