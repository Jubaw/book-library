package LibraryApp.hibernate.controller;

import LibraryApp.hibernate.config.HibernateUtils;
import LibraryApp.hibernate.repository.AuthorRepository;
import LibraryApp.hibernate.repository.BookRepository;
import LibraryApp.hibernate.service.AuthorService;
import LibraryApp.hibernate.service.BookService;

import java.util.Scanner;

public class LibraryManagementSystem {

    private static Scanner scanner = new Scanner(System.in);


    public static void displayLibraryManagementMenu() {


        //1 HotelRepo to be used in all application.
        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepository);
        BookService bookService = new BookService(bookRepository, authorRepository, authorService);


        boolean exit = false;

        while (!exit) {
            System.out.println("======= Library Management ======");
            System.out.println("1.Library Operations");
            System.out.println("2.Author Operations");
            System.out.println("TBD");
            System.out.println("TBD");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayLibraryOperationsMenu(bookService);
                    break;
                case 2:
                    displayAuthorOperationsMenu(authorService);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Good Bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid entry, try again");
                    break;

            }
        }

    }

    private static void displayAuthorOperationsMenu(AuthorService authorService) {

        System.out.println("Author Operations Menu");

        System.out.println("Library Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Book Operations ====");
            System.out.println("1. Find Author By Name");
            System.out.println("2. Find Book By ID");
            System.out.println("3. Delete Book By ID");
            System.out.println("4. Find All Books");
            System.out.println("5. Update Books By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //todo:1A Save Hotel
                    System.out.println("Enter the firstname");
                    authorService.findAuthorByName(scanner.nextLine());
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }


    private static void displayLibraryOperationsMenu(BookService bookService) {
        //HotelService hotelService = new HotelService(); uygulama içerisinde açmak yerine, param const ile çağırarak
        //her çağrılışında oluşacak kaynak israfını önleriz.

        System.out.println("Library Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Book Operations ====");
            System.out.println("1. Add a new book");
            System.out.println("2. Find Book By ID");
            System.out.println("3. Delete Book By ID");
            System.out.println("4. Find All Books");
            System.out.println("5. Find books by Author Name");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //todo:1A Save Hotel
                    bookService.addBook();
                    break;
                case 2:
                    //2-a: Finding book
                    System.out.println("Enter book ID");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();
                    bookService.findBookById(bookId);
                    break;

                //Find By Name
                case 3:
                    //todo:CascadeType.REMOVE kullan
                    System.out.println("Enter book ID you want to remove");
                    Long removeBookId = scanner.nextLong();
                    bookService.removeBook(removeBookId);


                    break;
                case 4:
                    //3a- Tüm otelleri listeleme
                    bookService.getAllBooks();
                    break;
                case 5:
                    System.out.println("Enter the author firstname");
                    bookService.findBookByAuthorName(scanner.nextLine());
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

}
