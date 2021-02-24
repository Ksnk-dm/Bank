package Dao;


import Entity.Currency;
import Util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class CurrencyDao extends Dao<Currency>{
    @Override
    public void insert(Currency exch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(exch);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Currency currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(currency);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Currency> getAll(int all) {
        return null;
    }

    public Currency getCurByName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Currency a = session.createQuery("SELECT u from Currency u where u.name= :username", Currency.class).setParameter("username",name).getSingleResult();
        session.getTransaction().commit();
        session.close();
        return a;
    }

}
