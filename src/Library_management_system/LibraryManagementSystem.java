package Library_management_system;

import java.util.*;
// Main class to test the system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library_management_system.Library Management System!");
        System.out.println("You are the librarian. Let's manage the library.");

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add a Library_management_system.Book");
            System.out.println("2. Remove a Library_management_system.Book");
            System.out.println("3. View All Books");
            System.out.println("4. Add a Library_management_system.Member");
            System.out.println("5. Remove a Library_management_system.Member");
            System.out.println("6. Search for a Library_management_system.Book");
            System.out.println("7. Manage Transactions");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book details (ID, Title, Author, Genre):");
                    String bookId = scanner.nextLine();
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    String genre = scanner.nextLine();
                    library.getBooks().add(new Book(bookId, title, author, genre));
                    System.out.println("Library_management_system.Book added successfully.");
                    break;

                case 2:
                    System.out.println("Enter the ID of the book to remove:");
                    bookId = scanner.nextLine();
                    library.getBooks().removeIf(book -> book.getBookId().equals(bookId));
                    System.out.println("Library_management_system.Book removed if it existed.");
                    break;

                case 3:
                    System.out.println("All Books in the Library_management_system.Library:");
                    for (Book book : library.getBooks()) {
                        book.displayDetails();
                    }
                    break;

                case 4:
                    System.out.println("Enter member details (ID, Name, Membership Type):");
                    String memberId = scanner.nextLine();
                    String name = scanner.nextLine();
                    String membershipType = scanner.nextLine();
                    library.addMember(new Member(memberId, name, membershipType));
                    break;

                case 5:
                    System.out.println("Enter the ID of the member to remove:");
                    memberId = scanner.nextLine();
                    library.getMembers().removeIf(member -> member.getMemberId().equals(memberId));
                    System.out.println("Library_management_system.Member removed if they existed.");
                    break;

                case 6:
                    System.out.println("Enter search query (Title, Author, Genre):");
                    String query = scanner.nextLine();
                    library.searchBook(query);
                    break;

                case 7:
                    System.out.println("Enter Library_management_system.Member ID:");
                    memberId = scanner.nextLine();
                    Member member = library.getMembers().stream()
                            .filter(m -> m.getMemberId().equals(memberId))
                            .findFirst()
                            .orElse(null);

                    if (member == null) {
                        System.out.println("Library_management_system.Member not found.");
                        break;
                    }

                    System.out.println("Enter Library_management_system.Book ID:");
                    bookId = scanner.nextLine();
                    Book book = library.getBooks().stream()
                            .filter(b -> b.getBookId().equals(bookId))
                            .findFirst()
                            .orElse(null);

                    if (book == null) {
                        System.out.println("Library_management_system.Book not found.");
                        break;
                    }

                    System.out.println("1. Borrow Library_management_system.Book\n2. Return Library_management_system.Book");
                    int action = scanner.nextInt();
                    scanner.nextLine();

                    if (action == 1) {
                        library.manageTransactions(member, book, true);
                    } else if (action == 2) {
                        library.manageTransactions(member, book, false);
                    } else {
                        System.out.println("Invalid action.");
                    }
                    break;

                case 8:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
