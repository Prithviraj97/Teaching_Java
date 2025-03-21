package CS282;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
    private Map<Integer, Long> cache = new HashMap<>();

    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        // Check if the result is already in the cache
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Calculate the Fibonacci number and store it in the cache
        long result = fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        FibonacciMemoization fib = new FibonacciMemoization();

        // Calculate Fibonacci numbers
        System.out.println("Fibonacci(10): " + fib.fibonacci(10)); // Output: 55
        System.out.println("Fibonacci(20): " + fib.fibonacci(20)); // Output: 6765
        System.out.println("Fibonacci(30): " + fib.fibonacci(30)); // Output: 832040
    }
}
