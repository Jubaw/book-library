package LibraryApp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.xml.crypto.Data;

public class Runner {
    public static void main(String[] args) {

        DatabaseHibernate databaseHibernate = new DatabaseHibernate();
        Session session = databaseHibernate.sf.openSession();
        Transaction tx = session.beginTransaction();

        databaseHibernate.addBook(1, "Les Miserables", "Victor Hugo", "1871", "Historical Fiction", 1000, session);
        databaseHibernate.addBook(2, "Crime and Punishment", "Fyodor Dostoyevski", "1866", "Roman", 1000, session);
        databaseHibernate.addBook(3, "War and Peace", "Lev Tolstoy", "1861", "Roman", 1000, session);
        tx.commit();
        session.close();
        databaseHibernate.closeSessionFactory();
//        Menu menu = new Menu();
//        menu.menuDisplay();

    }
}