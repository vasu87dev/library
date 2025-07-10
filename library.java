import java.util.*;

class Book {
    private String title;
    private String author;
    private String id;

    public Book(String id, String title, String author) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getId() { return id; }

    public String getTitle() { return title; }

    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "Book ID: " + id + " | Title: " + title + " | Author: " + author;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added successfully.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("⚠️ No books available.");
            return;
        }
        System.out.println("📚 List of Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("🔍 Book found:");
                System.out.println(book);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Book not found.");
        }
    }

    public void removeBook(String id) {
        Iterator<Book> it = books.iterator();
        boolean removed = false;
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getId().equals(id)) {
                it.remove();
                System.out.println("🗑️ Book removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("❌ Book ID not found.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n===== 📖 Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter Title to Search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Remove: ");
                    String removeId = sc.nextLine();
                    library.removeBook(removeId);
                    break;

                case 5:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("❗ Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
