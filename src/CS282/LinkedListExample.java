package CS282;
//this is generic implementation of Linked List.
class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void delete(T data) {
        if (head == null) return;

        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
            size--;
        }
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
       LinkedList <Integer> intList = new LinkedList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println("Integer Linked List: ");
        intList.display();
        System.out.println("Size: " + intList.size());

        LinkedList<String> stringList = new LinkedList<>();
        stringList.add("Hello");
        stringList.add("World");
        System.out.println("String Linked List: ");
        stringList.display();
        System.out.println("Size: " + stringList.size());
    }
}
