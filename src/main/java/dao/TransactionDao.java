package dao;

import entity.Transaction;
import util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TransactionDao extends Dao<Transaction> {

    @Override
    public void insert(Transaction exch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(exch);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Transaction transaction) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(transaction);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Transaction> getAll(int all) {
        return null;
    }
}
