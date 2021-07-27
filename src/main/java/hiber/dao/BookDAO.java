package hiber.dao;

import hiber.HibernateUtil;
import hiber.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookDAO {
    private SessionFactory sessionFactory;
    public BookDAO(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public List<Book> getBookList(){
        Session session = sessionFactory.openSession();
        session.get(Book.class,1L);

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);

        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }
}
