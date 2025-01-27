package Library_management_system;

import java.util.ArrayList;
import java.util.List;

// Class to manage the library
class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Library_management_system.Member added successfully.");
    }

    public void removeMember(Member member) {
        if (members.remove(member)) {
            System.out.println("Library_management_system.Member removed successfully.");
        } else {
            System.out.println("Library_management_system.Member not found.");
        }
    }

    public void searchBook(String query) {
        System.out.println("Search Results:");
        for (Book book : books) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getGenre().contains(query)) {
                book.displayDetails();
            }
        }
    }

    public void manageTransactions(Member member, Book book, boolean isBorrowing) {
        if (isBorrowing) {
            member.borrowBook(book);
        } else {
            member.returnBook(book);
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }
}