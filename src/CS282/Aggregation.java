package CS282;
import java.util.ArrayList;
import java.util.List;

public class Aggregation {

	public static void main(String[] args) {
		Book book1 = new Book("Java Basics", "Harold Dune");
		Book book2 = new Book("Python Fundamentals", "Blake Drost");
		
		List<Book> booklist = new ArrayList<>();
		booklist.add(book1);
		booklist.add(book2);
		
		Library library = new Library(booklist);
		library.displayBooks();

	}
}

class Book{
	String title;
	String author;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public void display() {
		System.out.println("Title: " + title +", Author: "+ author);
	}
}

class Library{
	private List<Book> books;
	public Library(List<Book> books) {
		this.books = books;
	}
	
	public void displayBooks() {
		for(Book book: books) {
			book.display();
		}
	}	
}