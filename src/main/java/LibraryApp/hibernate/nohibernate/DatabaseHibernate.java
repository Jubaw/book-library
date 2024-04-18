package LibraryApp.hibernate.nohibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseHibernate {
    SessionFactory sf;

    public DatabaseHibernate() {
        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Books.class);
        sf = con.buildSessionFactory();

    }

    public void addBook(int id, String bookName, String bookAuthor, String bookYear, String bookGenre, int price, Session session) {
        Books newBook = new Books(id, bookName, bookAuthor, bookYear, bookGenre, price);
        session.save(newBook);
    }




    public void closeSessionFactory() {
        if (sf != null) {
            sf.close();
        }
    }
}





//    public void addBook(int id, String bookName, String bookAuthor, String bookYear, String bookGenre, int price) {
//        Books newBook = new Books(id, bookName, bookAuthor, bookYear, bookGenre, price);
////        Books newBook = new Books(new Books(id, bookName, bookAuthor, bookYear, bookGenre, price));
//        Configuration con = new Configuration().
//                configure("hibernate.cfg.xml").
//                addAnnotatedClass(Books.class);
//
//
//        SessionFactory sf = con.buildSessionFactory();
//        Session session = sf.openSession();
//        Transaction tx = session.beginTransaction();
//
//        session.save(newBook);
//
//        tx.commit();
//        session.close();
//    }



