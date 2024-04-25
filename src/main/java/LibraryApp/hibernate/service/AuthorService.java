package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.exception.AuthorNotFound;
import LibraryApp.hibernate.repository.AuthorRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AuthorService {
    private Scanner scanner = new Scanner(System.in);


    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }

    public List<Book> findBookByAuthor(Object obj) {
        List<Book> bookFound = null;
        if (obj instanceof Long) {
            bookFound = authorRepository.findAuthorBooks((Long) obj);
        } else if (obj instanceof String) {
            bookFound = authorRepository.findAuthorBooks((String) obj);
        }


        if (bookFound != null) {
            bookFound.forEach(System.out::println);
        }

        return bookFound != null ? bookFound : Collections.emptyList();
    }

//    public Author findAuthor(long authorId) {
//        Author foundAuthor = authorRepository.findById(authorId);
//        try {
//            if (foundAuthor != null) {
//                System.out.println(foundAuthor);
//            } else {
//                throw new AuthorNotFound("Author not found with ID: " + authorId);
//            }
//        } catch (AuthorNotFound e) {
//            System.out.println(e.getMessage());
//        }
//        return foundAuthor;
//
//
//    }
//
//    public Author findAuthor(String authorName) {
//        Author foundAuthor = authorRepository.findByName(authorName);
//        try {
//            if (foundAuthor != null) {
//                System.out.println(foundAuthor);
//            } else {
//                throw new AuthorNotFound("Author not found with name: " + authorName);
//            }
//        } catch (AuthorNotFound e) {
//            System.out.println(e.getMessage());
//        }
//        return foundAuthor;
//    }

    public Author findAuthor(Object object) throws AuthorNotFound {
        if (object instanceof Long) {
            return authorRepository.findById((Long) object);
        } else if (object instanceof String) {
            return authorRepository.findByName((String) object);
        } else {
            throw new IllegalArgumentException("Invalid object type for book search");
        }
    }

    public void save() {

        Author author = new Author();

        do {
            System.out.println("Enter author ID");
            author.setId(scanner.nextLong());
            if (nullIdChecker(author.getId())){
                System.out.println("An author with the ID already exists");
            }
        }while (nullIdChecker(author.getId()));



        scanner.nextLine();

        System.out.println("Enter author name");
        author.setName(scanner.nextLine());

        System.out.println("Enter author last name");
        author.setLastname(scanner.nextLine());

        authorRepository.save(author);




    }



    private boolean nullIdChecker(Long id){
        Long authorFoundId = authorRepository.findById(id).getId();
        return !authorFoundId.equals(id);
    }
}


//    public Author findBookByAuthorName(String authName) {
//        Author authorFound = authorRepository.findByName(authName);
//        try {
//            if (authorFound != null) {
//                System.out.println(authorFound);
//                System.out.println(authorFound.getBookList());
//            } else {
//                throw new AuthorNotFound("Author not found with ID: " + authorFound);
//            }
//        } catch (AuthorNotFound e) {
//            System.out.println(e.getMessage());
//        }
//        return authorFound;
//    }
//
//    public void findbookByAuthorId(Long objInput) {
//        Author authorFound = authorRepository.findById(objInput);
//        if (authorFound != null) {
//            for (Book book : authorFound.getBookList()) {
//                System.out.println(book);
//            }
//        } else {
//            System.out.println("No book found by given author ID");
//        }
//    }


