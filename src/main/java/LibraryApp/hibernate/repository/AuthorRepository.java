package LibraryApp.hibernate.repository;

import LibraryApp.hibernate.config.HibernateUtils;
import LibraryApp.hibernate.domain.Author;
import LibraryApp.hibernate.domain.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorRepository {

    private Session session;


    public void save(Author author) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);

        }
    }


    public Author findById(Long authorId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Author author = session.get(Author.class, authorId);
            return author;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }


    public Author findByName(String name) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Query<Author> query = session.createQuery("FROM Author WHERE lower(name) = :name", Author.class);
            query.setParameter("name", name.toLowerCase());
            return query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    //6-c:
    public List<Author> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            List<Author> author = session.createQuery("FROM Author", Author.class).getResultList();
            return author;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public void delete(Author author) {
        try {


            session = HibernateUtils.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(author);
            transaction.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());

        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<Book> findAuthorBooks(long authorId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String hql = "SELECT b FROM Book b WHERE b.author.id = :authorId";
            List<Book> books = session.createQuery(hql, Book.class)
                    .setParameter("authorId", authorId)
                    .getResultList();
            return books;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }

    public List<Book> findAuthorBooks(String authorName) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            String hql = "SELECT b FROM Book b WHERE b.author.name = :authorName";
            List<Book> books = session.createQuery(hql, Book.class)
                    .setParameter("authorName", authorName)
                    .getResultList();
            return books;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        } finally {
            HibernateUtils.closeSession(session);
        }
    }
}
