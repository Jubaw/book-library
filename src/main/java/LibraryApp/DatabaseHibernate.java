package LibraryApp;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;

public class DatabaseHibernate {
    public static void main(String[] args) {
        Books books1 = new Books();
        books1.setId(1);
        books1.setBookName("Les Miserables");
        books1.setBookAuthor("Victor Hugo");
        books1.setBookYear("1871");
        books1.setBookGenre("Historical Fiction");

        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Books.class);


        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();


        tx.commit();
        session.close();
        sf.close();


    }


}
