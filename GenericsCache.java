import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*PROBLEM: Applications cache different types of data (users, products, settings)
 * Need to store with expiration time and retrieve with type safety
 * SOLUTION: Implement a generic caching system with TTL and type safety
 */

class CacheEntry<T> {
    private T value;
    private LocalDateTime expiryTime;
    
    public CacheEntry(T value, int ttlSeconds) {
        this.value = value;
        this.expiryTime = LocalDateTime.now().plusSeconds(ttlSeconds);
    }
    
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }
    
    public T getValue() {
        return value;
    }
}

class SmartCache<K, V> {
    private Map<K, CacheEntry<V>> cache;
    private int defaultTTL;  // Time To Live in seconds
    private int hitCount;
    private int missCount;
    
    public SmartCache(int defaultTTL) {
        this.cache = new HashMap<>();
        this.defaultTTL = defaultTTL;
        this.hitCount = 0;
        this.missCount = 0;
    }
    
    public void put(K key, V value) {
        cache.put(key, new CacheEntry<>(value, defaultTTL));
        System.out.println("✓ Cached: " + key);
    }
    
    public void put(K key, V value, int customTTL) {
        cache.put(key, new CacheEntry<>(value, customTTL));
        System.out.println("✓ Cached: " + key + " (TTL: " + customTTL + "s)");
    }
    
    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        
        if (entry == null) {
            missCount++;
            System.out.println("✗ Cache MISS: " + key);
            return null;
        }
        
        if (entry.isExpired()) {
            cache.remove(key);
            missCount++;
            System.out.println("✗ Cache EXPIRED: " + key);
            return null;
        }
        
        hitCount++;
        System.out.println("✓ Cache HIT: " + key);
        return entry.getValue();
    }
    
    public void clear() {
        cache.clear();
        System.out.println("Cache cleared!");
    }
    
    public void displayStats() {
        System.out.println("\n=== CACHE STATISTICS ===");
        System.out.println("Total Entries: " + cache.size());
        System.out.println("Cache Hits: " + hitCount);
        System.out.println("Cache Misses: " + missCount);
        double hitRate = (hitCount + missCount) > 0 
            ? (hitCount * 100.0) / (hitCount + missCount) 
            : 0;
        System.out.println("Hit Rate: " + String.format("%.1f", hitRate) + "%");
    }
}

public class GenericsCache {
    public static void main(String[] args) throws InterruptedException {
        SmartCache<String, String> stringCache = new SmartCache<>(5); // 5 seconds TTL
        stringCache.put("key1", "value1");
        stringCache.put("key2", "value2", 10); // custom TTL of 10 seconds
        
        System.out.println("Retrieved: " + stringCache.get("key1")); // Should be a hit
        Thread.sleep(6000); // Wait for 6 seconds
        System.out.println("Retrieved: " + stringCache.get("key1")); // Should be expired
        
        System.out.println("Retrieved: " + stringCache.get("key2")); // Should be a hit
        
        stringCache.displayStats();
        
        stringCache.clear();
        stringCache.displayStats();
    }
}