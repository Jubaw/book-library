package LibraryApp.hibernate.config;

import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import LibraryApp.hibernate.domain.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {


    private static SessionFactory sessionFactory;

    static {
        try {


            Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Author.class)
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Genre.class);

            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Initialization of SESSION FACTORY has failed !!!");
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //getter SF
    public static void shutDown() {
        getSessionFactory().close();
    }

    //Session kapatalım
    public static void closeSession(Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
