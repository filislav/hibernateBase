package hiber.dao;

import hiber.HibernateUtil;
import hiber.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AuthorDAO {
    private SessionFactory sessionFactory;
    public AuthorDAO(){
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    public List<Author> getAuthorList(){
        Session session = sessionFactory.openSession();
        session.get(Author.class,1L);
        //подготовка запроса
        //объект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class); //определяет какая таблица в запросе будет основная
        cq.select(root);

        //запрос
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();//сессию жедательно закрывать в ручную
        return authorList;
    }
    public Author getAuthor(String name){
        return null;
    }

}
