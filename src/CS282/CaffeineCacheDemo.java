// package CS282;

// import com.github.benmanes.caffeine.cache.Cache;
// import com.github.benmanes.caffeine.cache.Caffeine;

// import java.util.concurrent.TimeUnit;

// public class CaffeineCacheDemo {
//     public static void main(String[] args) {
//         // Create a cache with a maximum size and expiration policy
//         Cache<String, String> cache = Caffeine.newBuilder()
//                 .maximumSize(100)
//                 .expireAfterWrite(10, TimeUnit.MINUTES)
//                 .build();

//         // Add data to the cache
//         cache.put("user1", "John Doe");

//         // Retrieve data from the cache
//         String user1 = cache.getIfPresent("user1");
//         System.out.println("User1: " + user1); // Output: User1: John Doe

//         // Remove data from the cache
//         cache.invalidate("user1");
//     }
// }
