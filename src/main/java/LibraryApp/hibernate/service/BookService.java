package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.repository.BookRepository;

import java.util.Scanner;

public class BookService {

    private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { //Added to param const so whenever it is called, its will be set manually.
        this.bookRepository = bookRepository;
    }

    public void saveBook() {

        Book book = new Book();
        System.out.println("Enter book ID: ");
        book.set(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name: ");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location: ");
        hotel.setLocations(scanner.nextLine());

        hotelRepository.save(hotel);
        System.out.println("Hotel is saved successfully. Hotel ID: " + hotel.getId());

    }


}
