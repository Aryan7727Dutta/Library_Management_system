package Library_management_system;
// Class to represent individual books
class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Library_management_system.Book issued successfully.");
        } else {
            System.out.println("Library_management_system.Book is not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Library_management_system.Book returned successfully.");
    }

    public void displayDetails() {
        System.out.println("Library_management_system.Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}
