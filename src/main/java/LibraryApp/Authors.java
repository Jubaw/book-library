package LibraryApp;

import javax.persistence.Embeddable;

@Embeddable
public class Authors {

    private String authorName;

    private String authorSurname;


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }





}
