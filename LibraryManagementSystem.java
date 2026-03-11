import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean issued;

    Book(String t, String a) {
        title = t;
        author = a;
        issued = false;
    }

    void display() {
        System.out.println("Title: " + title + 
                           " | Author: " + author + 
                           " | Issued: " + issued);
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author name: ");
                    String author = sc.nextLine();

                    books.add(new Book(title, author));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : books) {
                            b.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book title: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(search)) {
                            b.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(issueTitle)) {
                            if (!b.issued) {
                                b.issued = true;
                                System.out.println("Book issued successfully.");
                            } else {
                                System.out.println("Book already issued.");
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();

                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(returnTitle)) {
                            if (b.issued) {
                                b.issued = false;
                                System.out.println("Book returned successfully.");
                            } else {
                                System.out.println("This book was not issued.");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}