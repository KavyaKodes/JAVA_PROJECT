import java.util.*;

public class SmartLibraryAssistant {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static void printHeader() {
    System.out.println("\n======================================");
    System.out.println("        SMART LIBRARY ASSISTANT        ");
    System.out.println("======================================");
}


    public static void main(String[] args) {
        while (true) {
            printHeader();

            System.out.println("\n--- Smart Library Assistant ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt("Choose an option: ");


            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBooks();
                case 3 -> issueBook();
                case 4 -> returnBook();
                case 5 -> searchBook();
                case 6 -> {
                    System.out.println("Exiting system...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static class Book {
    int id;
    String name;
    boolean isIssued;

    Book(int id, String name) {
        this.id = id;
        this.name = name;
        this.isIssued = false;
    }
}

// Safely read integer input
static int readInt(String message) {
    System.out.print(message);

    while (!sc.hasNextInt()) {
        System.out.println(" Invalid input! Please enter a number.");
        sc.next(); // discard wrong input
        System.out.print(message);
    }
    return sc.nextInt();
}

        static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = readInt("Enter Book ID: ");

        sc.nextLine();

        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();

        books.add(new Book(id, name));
        System.out.println("Book added successfully!");
    }

        static void viewBooks() {
        System.out.println("\nID\tNAME\t\tSTATUS");
System.out.println("------------------------------------");

for (Book b : books) {
    System.out.println(
        b.id + "\t" + b.name + "\t\t" +
        (b.isIssued ? "Issued" : "Available")
    );
}

    }

        static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();

        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");

                } else {
                    System.out.println("Book already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

        static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = readInt("Enter Book ID: ");


        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

        static void searchBook() {
        System.out.print("Enter Book ID to search: ");
        int id = readInt("Enter Book ID: ");


        for (Book b : books) {
            if (b.id == id) {
                System.out.println(
                    "Found: " + b.name + " | " +
                    (b.isIssued ? "Issued" : "Available")
                );
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

