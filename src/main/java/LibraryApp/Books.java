package LibraryApp;


import javax.persistence.*;
import java.util.Date;

@Entity //Create table
@Table (name = "b_books") //Customized the name
public class Books { //Table name

    @Id //PK
    @Column (name = "book_id",length = 25,nullable = false,unique = true)
    private int id;

    @Column(name = "book_name",length = 25,nullable = false)
    private String bookName;
    @Column(name = "book_author",length = 25)
    private String bookAuthor;

    @Column(name = "book_year",length = 25)
    private String bookYear;

    @Column(name = "book_genre",length = 25)
    private String bookGenre;

    @Column(name = "book_price",length = 25)
    private double bookPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Books(){

    }

    public Books(String bookName, String bookAuthor, String bookYear, String bookGenre, double bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookGenre = bookGenre;
        this.bookPrice = bookPrice;

    }
    public Books(int id,String bookName, String bookAuthor, String bookYear, String bookGenre, double bookPrice) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookGenre = bookGenre;
        this.bookPrice = bookPrice;
        this.id = id;

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
