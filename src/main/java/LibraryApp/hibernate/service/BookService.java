package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.exception.AuthorNotFound;
import LibraryApp.hibernate.exception.BookNotFound;
import LibraryApp.hibernate.repository.AuthorRepository;
import LibraryApp.hibernate.repository.BookRepository;

import java.util.List;
import java.util.Scanner;

public class BookService {

    private Scanner scanner = new Scanner(System.in);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) { //Added to param const so whenever it is called, its will be set manually.
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

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

//    public Book findBook(String firstname) {
//        Book bookFound = bookRepository.findByName(firstname);
//        try {
//            if (bookFound != null) {
//                System.out.println(bookFound);
//            } else {
//                throw new AuthorNotFound("Book not found with name: " + firstname);
//            }
//        } catch (AuthorNotFound e) {
//            System.out.println(e.getMessage());
//        }
//
//        return bookFound;
//    }

//    public Book findBook(Long id) {
//        Book bookFound = bookRepository.findById(id);
//        try {
//            if (bookFound != null) {
//                System.out.println(bookFound);
//            } else {
//                throw new AuthorNotFound("Book not found with ID: " + id);
//            }
//        } catch (AuthorNotFound e) {
//            System.out.println(e.getMessage());
//        }
//        return bookFound;
//    }



    public Book findBook(Object object) {
        Book bookFound = null;
        if (object instanceof Long) {
            bookFound = bookRepository.findById((Long) object);
        } else if (object instanceof String) {
            bookFound = bookRepository.findByName((String) object);
        }
        try {
            if (bookFound != null) {
                System.out.println(bookFound);
            } else {
                throw new BookNotFound("Book not found with ID: " + object);
            }
        } catch (BookNotFound e) {
            System.out.println(e.getMessage());
        }
        return bookFound;
    }


    public void removeBook(Object removeBookNameId) {
        Book bookFound = null;
        if (removeBookNameId instanceof Long) {
            bookFound = bookRepository.findById((Long) removeBookNameId);

        } else if (removeBookNameId instanceof String) {
            bookFound = bookRepository.findByName((String) removeBookNameId);
        }

        if (bookFound != null) {
            System.out.println("Book: " + bookFound);
            System.out.println("You want to delete ? Y/N");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                bookRepository.delete(bookFound);
                System.out.println("Deletion successfull");
            } else if (input.equalsIgnoreCase("n")) {
                System.out.println("Deletion aborted");
            } else {
                System.out.println("No valid answer given, aborting...");
            }
        } else {
            System.out.println("No book found for ID given");
        }
    }


//    public void removeBook(String bookName) {
//
//        Book bookFound = bookRepository.findByName(bookName);
//
//        if (bookFound != null) {
//            System.out.println("Book: " + bookFound);
//            System.out.println("You want to delete ? Y/N");
//            String input = scanner.nextLine();
//            if (input.equalsIgnoreCase("y")) {
//                bookRepository.delete(bookFound);
//                System.out.println("Deletion successfull");
//            } else if (input.equalsIgnoreCase("n")) {
//                System.out.println("Deletion aborted");
//            } else {
//                System.out.println("No valid answer given, aborting...");
//            }
//        } else {
//            System.out.println("No book found for ID given");
//        }
//    }


}
