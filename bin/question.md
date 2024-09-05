## Java Strings

Understanding Strings in Java
In Java, a String is an object that represents a sequence of characters. It is one of the most commonly used classes in the Java programming language. Java strings are immutable, meaning once a String object is created, its value cannot be changed.

1. Creating Strings
There are multiple ways to create a string in Java:

Using String Literals:

```java
String str1 = "Hello, World!";
```

When you create a string literal, it is stored in a special memory area called the string pool.

Using the new Keyword:

java
Copy code
String str2 = new String("Hello, World!");
This creates a new String object in the heap memory, even if an equivalent string exists in the string pool. 