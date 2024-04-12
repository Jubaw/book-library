package LibraryApp;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Books {

    private String bookName;
    private String bookAuthor;
    private String bookYear;
    private String bookGenre;
    private double bookPrice;


    public Books(){

    }

    public Books(String bookName, String bookAuthor, String bookYear, String bookGenre, double bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookGenre = bookGenre;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }


    @Override
    public String toString() {
        return "Books " +
                " Book name='" + bookName + '\'' +
                ", Book author='" + bookAuthor + '\'' +
                ", Book year='" + bookYear + '\'' +
                ", Book genre='" + bookGenre + '\'' +
                ", Book price=" + bookPrice;
    }
}
