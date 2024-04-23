package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.exception.AuthorNotFound;
import LibraryApp.hibernate.repository.AuthorRepository;
import LibraryApp.hibernate.repository.BookRepository;

import java.util.Scanner;

public class AuthorService {
    private Scanner scanner = new Scanner(System.in);


    private final AuthorRepository authorRepository;


    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;

    }


    public Author findAuthorById(Long id) {
        Author foundAuthor = authorRepository.findById(id);
        try {
            if (foundAuthor != null) {
                System.out.println(foundAuthor);
            } else {
                throw new AuthorNotFound("Author not found with ID: " + id);
            }
        } catch (AuthorNotFound e) {
            System.out.println(e.getMessage());
        }
        return foundAuthor;
    }

    public Author findAuthorByName(String name) {
        Author authorFound = authorRepository.findByName(name);
        try {
            if (authorFound != null) {
                System.out.println(authorFound);
            } else {
                throw new AuthorNotFound("Author not found with ID: " + authorFound);
            }
        } catch (AuthorNotFound e) {
            System.out.println(e.getMessage());
        }
        return authorFound;
    }

}
