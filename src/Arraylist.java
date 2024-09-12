
import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist {
    public static void main(String[] args) {
        //With Generics
        ArrayList<String> fruits = new ArrayList<>();

        //Without Genrics (Not Recommended)
        // ArrayList list = new ArrayList();

        //Adding Elements
        fruits.add("orange");
        fruits.add("Apple");
        fruits.add("Berry");

        /**
         * add(E,e): adds an elements towards the end of the list.
         * add(int index, E element): adds an element at mentioned index.
         */
        fruits.add(3, "Mango");
        fruits.add(0, "Strawberry");
        
         //Accessing: `get(int index)` - returns the element at the index.
         String Fruits = fruits.get(2);

         //Modifying Elements: `set(int index, E element)` - replaces an element at the specified position with the specified element.
         fruits.set(2, "Peace");

         //Removing Elements: `remove(int index) - remove an element at specified location
         //`remove(Object o)` - removes the first occurence of specified element.
         fruits.remove(0);
         fruits.remove("Berry");

         //Checking the Size - `Size()` returns number of elements in ArrayList.
         int size = fruits.size();

         //Checking for containment - `contains(Object O)`: return `true` or `false` based on if the arraylist contains element or not.
         boolean hasDragonFruit = fruits.contains("Dragon Fruit");

         //Clearing the List - `clear()`: removes all things from ArrayList.
        //  fruits.clear();

         //Iterating in ArrayList
         //a traditional for-loop
         for(int i=0; i< fruits.size(); i++)
         {
            System.out.println(fruits.get(i));
         }

         //Enhanced for loop (For-Each loop)
         for(String fruit: fruits)
         {
            System.out.println(fruit);
         }

         //Using iterator
         Iterator<String> iterator = fruits.iterator();
         while(iterator.hasNext()){
            System.out.println(iterator.next());
         } 

         //Using Stream
         fruits.stream().forEach(System.out::println);
    }
}

/**
 * ArrayList vs Arrays: Key Differences
 * - size: Arrays have af fixed size, but ArrayList can grow or shrink.
 * - Performance: Arrays are faster usually, but arraylist is slow because of dynamic resizing.
 * - type-safety  
 */
