import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);

        while (true) {
            // Main Menu
            String[] options = {"Add Book", "Add Member", "Borrow Book", "Return Book", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Select an option", "Library Management System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0: // Add Book
                    addBookUI(library);
                    break;
                case 1: // Add Member
                    addMemberUI(library);
                    break;
                case 2: // Borrow Book
                    borrowBookUI(library);
                    break;
                case 3: // Return Book
                    returnBookUI(library);
                    break;
                case 4: // Exit
                    JOptionPane.showMessageDialog(null, "Exiting Library Management System.");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    // Add a new book via JOptionPane
    public static void addBookUI(Library library) {
        String title = JOptionPane.showInputDialog("Enter the book title:");
        String author = JOptionPane.showInputDialog("Enter the author:");
        String isbn = JOptionPane.showInputDialog("Enter the ISBN:");
        Book book = new Book(title, author, isbn);
        library.addBook(book);
    }

    // Add a new member via JOptionPane
    public static void addMemberUI(Library library) {
        String[] memberOptions = {"Student", "Teacher"};
        int memberType = JOptionPane.showOptionDialog(null, "Select member type", "Add Member",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, memberOptions, memberOptions[0]);

        String name = JOptionPane.showInputDialog("Enter the member's name:");
        String memberID = JOptionPane.showInputDialog("Enter the member ID:");
        Member member = null;

        if (memberType == 0) {
            member = new Student(name, memberID);
        } else if (memberType == 1) {
            member = new Teacher(name, memberID);
        }

        if (member != null) {
            library.addMember(member);
        }
    }

    // Borrow a book via JOptionPane
    public static void borrowBookUI(Library library) {
        String memberID = JOptionPane.showInputDialog("Enter the member ID:");
        Member member = findMember(library, memberID);

        if (member != null) {
            String bookTitle = JOptionPane.showInputDialog("Enter the book title:");
            Book book = library.searchBook(bookTitle);

            if (book != null && member.borrowBook(book)) {
                JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to borrow book.");
            }
        }
    }

    // Return a book via JOptionPane
    public static void returnBookUI(Library library) {
        String memberID = JOptionPane.showInputDialog("Enter the member ID:");
        Member member = findMember(library, memberID);

        if (member != null) {
            String bookTitle = JOptionPane.showInputDialog("Enter the book title to return:");
            Book book = library.searchBook(bookTitle);

            if (book != null && member.returnBook(book)) {
                JOptionPane.showMessageDialog(null, "Book returned successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to return book.");
            }
        }
    }

    // Find a member by their member ID
    public static Member findMember(Library library, String memberID) {
        for (Member member : library.getMembers()) {
            if (member != null && member.getMemberID().equalsIgnoreCase(memberID)) {
                return member;
            }
        }
        JOptionPane.showMessageDialog(null, "Member not found.");
        return null;
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    public boolean borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }
}

import java.util.ArrayList;
import javax.swing.JOptionPane;

class Library {
    private Book[] books;
    private ArrayList<Member> members = new ArrayList<>();
    private int bookCount = 0;

    public Library(int maxBooks) {
        books = new Book[maxBooks];
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            JOptionPane.showMessageDialog(null, "Book added: " + book.getTitle());
        } else {
            JOptionPane.showMessageDialog(null, "Library is full, cannot add more books!");
        }
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[bookCount - 1]; // Swap with the last book
                books[--bookCount] = null;      // Nullify the last slot
                JOptionPane.showMessageDialog(null, "Book removed: " + isbn);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
        return null;
    }

    public void addMember(Member member) {
        members.add(member);
        JOptionPane.showMessageDialog(null, "Member added: " + member.getName());
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}

