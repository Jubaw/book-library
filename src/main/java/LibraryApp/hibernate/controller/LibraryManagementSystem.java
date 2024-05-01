package LibraryApp.hibernate.controller;

import LibraryApp.hibernate.config.HibernateUtils;
import LibraryApp.hibernate.repository.AuthorRepository;
import LibraryApp.hibernate.repository.BookRepository;
import LibraryApp.hibernate.service.AuthorService;
import LibraryApp.hibernate.service.BookService;
import com.sun.source.tree.IfTree;

import java.util.Objects;
import java.util.Scanner;

public class LibraryManagementSystem {

    private static Scanner scanner = new Scanner(System.in);


    public static void displayLibraryManagementMenu() {


        //1 HotelRepo to be used in all application.
        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepository);
        BookService bookService = new BookService(bookRepository, authorRepository);


        boolean exit = false;

        while (!exit) {
            System.out.println("======= Library Management ======");
            System.out.println("1.Book Operations");
            System.out.println("2.Author Operations");
            System.out.println("TBD");
            System.out.println("TBD");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayBookOperationsMenu(bookService, authorService);
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


        boolean exit = false;
        while (!exit) {
            System.out.println("==== Manager Operations ====");
            System.out.println("1. Add Author");
            System.out.println("2. Delete Author");
            System.out.println("3. Find Author");
            System.out.println("3. Update Author");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    authorService.save();
//                    if (scanner.hasNextLong()){
//                        authorService.findAuthor(scanner.nextLong());
//                    }else if (scanner.hasNextLine()){
//                        authorService.findAuthor(scanner.nextLine());
//                    }
                    break;
                case 2:
                    System.out.println("Enter the firstname or ID of Author you want to delete");
                    if (scanner.hasNextLong()){
//                        authorService.delete(scanner.nextLong());
                    }
                case 3:
                    System.out.println("Enter the firstname or ID");
                    authorService.findAuthor(scanner.next());
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


    private static void displayBookOperationsMenu(BookService bookService, AuthorService authorService) {
        //HotelService hotelService = new HotelService(); uygulama içerisinde açmak yerine, param const ile çağırarak
        //her çağrılışında oluşacak kaynak israfını önleriz.

        System.out.println("Library Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Book Operations ====");
            System.out.println("1. Add a new book");
            System.out.println("2. Search Book");
            System.out.println("3. Search books by Author");
            System.out.println("4. Search All Books");
            System.out.println("5. Delete Book");
            System.out.println("0. Return to Main Menu");
            //todo: borrow
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookService.addBook();
                    break;
                case 2:
                    System.out.println("Enter book name or ID");
                    bookService.findBook(scanner.next());
                    break;
                case 3:
                    System.out.println("Enter the author's name or ID");
//                    authorService.findBookByAuthor(scanner.next());

                    if (scanner.hasNextLong()) {
                        authorService.findBookByAuthor(scanner.nextLong());
                    } else if (scanner.hasNextLine()) {
                        authorService.findBookByAuthor(scanner.nextLine());
                    }
                    break;
                case 4:
                    bookService.getAllBooks();
                    break;
                case 5:
                    System.out.println("Enter book name or ID you want to remove");
                    if (scanner.hasNextLong()) {
                        bookService.removeBook(scanner.nextLong());
                        scanner.nextLine();
                    } else if (scanner.hasNextLine()) {
                        bookService.removeBook(scanner.nextLine());
                    }
                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.err.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

}
