package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

public class BookService {

    private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) { //Added to param const so whenever it is called, its will be set manually.
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        Book book = new Book();

        System.out.println("Enter hotel name: ");
        book.setName(scanner.nextLine());

        System.out.println("Enter  location: ");
        book.setPrice(scanner.nextDouble());



    }


    public void addBook() {
        Book book = new Book();
        Author author = new Author();

        System.out.println("Enter the book name");
        book.setName(scanner.nextLine());

        System.out.println("Enter the book year");
        book.setYear(scanner.nextLine());

        System.out.println("Enter the book author name");
        author.setName(scanner.nextLine());

        System.out.println("Enter the book author last name");
        author.setSurname(scanner.nextLine());

        System.out.println("Enter the book price");
        book.setPrice(scanner.nextDouble());
//
//        author.setBook(book);
//        book.setAuthor(author);

        bookRepository.save(book);

        System.out.println("Book added. " + book.getBookList());







    }

    public void getAllBooks() {

        List<Book> bookList = bookRepository.findAll();
        if (!bookList.isEmpty()) {
            System.out.println("----------------------------ALL BOOKS----------------------------");
            for (Book book : bookList) {
                System.out.println(book);
            }
            System.out.println("------------------------------------------------------------------");
        } else {
            System.out.println("Book list is empty.");
        }

    }
}
