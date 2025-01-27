package Library_management_system;

import java.util.List;

// Class to represent librarians
class Librarian {
    private String librarianId;
    private String name;
    private String assignedSection;

    public Librarian(String librarianId, String name, String assignedSection) {
        this.librarianId = librarianId;
        this.name = name;
        this.assignedSection = assignedSection;
    }

    public void addBook(List<Book> books, Book book) {
        books.add(book);
        System.out.println("Library_management_system.Book added successfully.");
    }

    public void removeBook(List<Book> books, Book book) {
        if (books.remove(book)) {
            System.out.println("Library_management_system.Book removed successfully.");
        } else {
            System.out.println("Library_management_system.Book not found in the collection.");
        }
    }

    public void viewAllBooks(List<Book> books) {
        System.out.println("All Books in the Library_management_system.Library:");
        for (Book book : books) {
            book.displayDetails();
        }
    }
}