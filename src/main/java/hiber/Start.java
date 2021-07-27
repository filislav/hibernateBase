package hiber;

import hiber.dao.AuthorDAO;
import hiber.dao.BookDAO;

public class Start {
    public static void main(String[] args) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        new AuthorDAO().getAuthorList().forEach(e->{
            System.out.println(String.format("id=%d; name=%s",e.getId(),e.getName()));
        });
        new BookDAO().getBookList().forEach(e->{
            System.out.println(String.format("id=%d; title=%s",e.getId(),e.getTitle()));
        });
    }
}
