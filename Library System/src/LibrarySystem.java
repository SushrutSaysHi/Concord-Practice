import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    static List<Book> books = new ArrayList<>();

    static void addBook(String isbn, String title, String author) {
        books.add(new Book(isbn, title, author));
        System.out.println("Book added!");
    }

    static void checkBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn) && b.isAvailable) {
                System.out.println("Book available");
                return;
            }
        }
        System.out.println("Book not available!");
    }

    static boolean borrowBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn) && b.isAvailable) {
                b.isAvailable = false;
                System.out.println("Book borrowed!");
                return true;
            }
        }
        System.out.println("Book not available!");
        return false;
    }

    static boolean returnBook(String isbn) {
        for (Book b : books) {
            if (b.isbn.equals(isbn) && !b.isAvailable) {
                b.isAvailable = true;
                System.out.println("Book returned successfully!");
                return true;
            }
        }
        System.out.println("Book not found or already available!");
        return false;
    }

    static void displayBooks() {
        for (Book b : books) {
            b.displayBook();
        }
    }

    public static void main(String[] args) {
        addBook("1", "Python Programming", "Author1");
        addBook("2", "Java Programming", "Author2");
        addBook("3", "C++ Programming", "Author3");
        borrowBook("1");
        checkBook("1");
        returnBook("1");
        returnBook("2");
        borrowBook("3");
        borrowBook("3");
        displayBooks();
    }
}

class Book {
    public String isbn;
    public String title;
    public String author;
    public boolean isAvailable;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void displayBook() {
        System.out.println("Book ID: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}