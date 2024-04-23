package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.exception.AuthorNotFound;
import LibraryApp.hibernate.repository.AuthorRepository;
import LibraryApp.hibernate.repository.BookRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, AuthorService authorService) { //Added to param const so whenever it is called, its will be set manually.
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }


    public void addBook() {
        Book book = new Book();
        Author author = new Author();


        System.out.println("Enter the book name");
        book.setName(scanner.nextLine());

        System.out.println("Enter the book year");
        book.setYear(scanner.nextLine());

        System.out.println("Enter the book price");
        book.setPrice(scanner.nextDouble());
        scanner.nextLine();


        System.out.println("Enter the Author Id:");
        Long authId = scanner.nextLong();
        scanner.nextLine();

        Author authorFound = authorRepository.findById(authId);
        if (authorFound != null) {
            book.setAuthor(authorFound);
        } else {
            author.setId(authId);
            System.out.println("Enter the author name");
            author.setName(scanner.nextLine());
            System.out.println("Enter the author surname");
            author.setLastname(scanner.nextLine());
            book.setAuthor(author);


        }

//        if (author.getId() == null) {
//            authorRepository.save(author);
//        }

        // save the book

        authorRepository.save(author);
        bookRepository.save(book);


        System.out.println("Book added. " + book);

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

    public Book findBookById(Long bookId) {

        BookRepository bookRepository = new BookRepository();
        List<Book> bookList = bookRepository.findAll();

        for (Book book : bookList) {
            if (book.getId().equals(bookId)) {

                System.out.println("Room: " + book);
                return book;
            }
        }
        return null;

    }

    public void removeBook(Long removeBookId) {

        Book bookFound = bookRepository.findById(removeBookId);

        if (bookFound != null){
            System.out.println("Book: " + bookFound);
            System.out.println("You want to delete ? Y/N");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                bookRepository.delete(bookFound);
                System.out.println("Deletion successfull");
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Deletion aborted");
            }else {
                System.out.println("No valid answer given, aborting...");
            }
        }else {
            System.out.println("No book found for ID given");
        }
    }

    public Author findBookByAuthorName(String authName) {
        Author authorFound = authorRepository.findByName(authName);
        try {
            if (authorFound != null) {
                System.out.println(authorFound);
                System.out.println(authorFound.getBookList());
            } else {
                throw new AuthorNotFound("Author not found with ID: " + authorFound);
            }
        } catch (AuthorNotFound e) {
            System.out.println(e.getMessage());
        }
        return authorFound;
    }
}
