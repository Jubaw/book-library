package LibraryApp.hibernate.controller;

import LibraryApp.hibernate.config.HibernateUtils;
import LibraryApp.hibernate.repository.BookRepository;
import LibraryApp.hibernate.service.BookService;

import java.util.Scanner;

public class LibraryManagementSystem {

    private static Scanner scanner = new Scanner(System.in);


    public static void displayLibraryManagementMenu() {


        //1 HotelRepo to be used in all application.
        BookRepository bookRepository = new BookRepository();
        BookService bookService = new BookService(bookRepository);


        boolean exit = false;

        while (!exit) {
            System.out.println("======= Library Management ======");
            System.out.println("1.Library Operations");
            System.out.println("2.Room Operations");
            System.out.println("3.Guest Operations");
            System.out.println("4.Reservation Operations");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayLibraryOperationsMenu(bookService);
                    break;
                case 2:

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
            System.out.println("5. Update Books By ID");
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
                    //2-a: Finding hotel
                    System.out.println("Enter book ID");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    // hotelService.findHotelById(scanner.nextLong()); da yapılabilir.
                    break;
                case 3:
                    //todo:CascadeType.REMOVE kullan

                    break;
                case 4:
                    //3a- Tüm otelleri listeleme
                    bookService.getAllBooks();
                    break;
                case 5:

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
