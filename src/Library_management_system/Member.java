package Library_management_system;

import java.util.ArrayList;
import java.util.List;

// Class to represent library members
class Member {
    private String memberId;
    private String name;
    private String membershipType;
    private List<Book> borrowedBooks;

    public Member(String memberId, String name, String membershipType) {
        this.memberId = memberId;
        this.name = name;
        this.membershipType = membershipType;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < 3 && book.isAvailable()) {
            borrowedBooks.add(book);
            book.issueBook();
        } else {
            System.out.println("Cannot borrow book. Limit reached or book not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook();
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    public void viewBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books borrowed.");
        } else {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                book.displayDetails();
            }
        }
    }
}