/*
 * Implementation of a simple queue as a generic class.
 * This example demonstrates the use of generics in Java.
 */

package CS282;
public class QueueExample<T> {
    private T[] queue;
    private int front, rear, size, capacity;

    // Constructor to initialize the queue
    public QueueExample(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity]; // Generic array creation
        front = 0;
        rear = -1;
        size = 0;
    }

    // Method to add an item to the queue
    public void enqueue(T item) {
        if (size == capacity) {
            System.out.println("Queue is full. Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = item;
        size++;
        System.out.println(item + " enqueued to queue.");
    }

    // Method to remove an item from the queue
    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        T item = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println(item + " dequeued from queue.");
        return item;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        QueueExample<Integer> intQueue = new QueueExample<>(5);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        intQueue.enqueue(5);
        intQueue.enqueue(6); // This should show queue is full

        System.out.println("Dequeued: " + intQueue.dequeue());
        System.out.println("Dequeued: " + intQueue.dequeue());

        System.out.println("Current size of queue: " + intQueue.size());
    }
}