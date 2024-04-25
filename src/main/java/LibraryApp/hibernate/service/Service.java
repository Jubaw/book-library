package LibraryApp.hibernate.service;

import LibraryApp.hibernate.domain.Book;

import java.util.List;

public interface Service {
    List<Book> findAuthor();
}
