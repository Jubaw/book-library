package LibraryApp.hibernate.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 30)
    private String name;

    private String lastname;




    @OneToMany(mappedBy = "author",orphanRemoval = true,fetch = FetchType.EAGER)
    private Book book;


    private List<Author> authorsList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Author> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Author> authorsList) {
        this.authorsList = authorsList;
    }

    public String getSurname() {
        return lastname;
    }

    public void setSurname(String surname) {
        this.lastname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + lastname + '\'' +
                ", book=" + book +
                ", authorsList=" + authorsList +
                '}';
    }
}
