package LibraryApp.hibernate.exception;

public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(String message) {
        super(message);
    }

}
