package LibraryApp.hibernate.repository;

import LibraryApp.hibernate.config.HibernateUtils;
import LibraryApp.hibernate.domain.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepository {


    private Session session;



    public void save(Book book) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);

        }
    }


    public Book findById(Long bookId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Book book = session.get(Book.class, bookId);
            return book;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }


    //6-c:
    public List<Book> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Book> books = session.createQuery("FROM Book", Book.class).getResultList();
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());;
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Book book) {
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //delete from t_hotel where id =
            session.delete(book);
            transaction.commit();
            //insert
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}
