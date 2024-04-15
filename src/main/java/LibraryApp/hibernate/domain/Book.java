package LibraryApp.hibernate.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "b_book")
public class Book {

    @Id
    private Long id;

    @Column(nullable = false,length = 30)
    private String name;

    @Column
    private Integer price;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Man
    private List<Author> rooms = new ArrayList<>();
}
