package LibraryApp.hibernate.exception;

public class BookNotFound extends RuntimeException{

    public BookNotFound(String message) {
        super(message);
    }

}
