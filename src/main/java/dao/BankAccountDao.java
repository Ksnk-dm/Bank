package dao;

import entity.BankAccount;
import entity.Currency;
import entity.Users;
import util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class BankAccountDao extends Dao<BankAccount> {

    @Override
    public void insert(BankAccount bankAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(bankAccount);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(BankAccount bankAccount) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(bankAccount);
        session.getTransaction().commit();
        session.close();
    }


    @Override
    public List<BankAccount> getAll(int drfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<BankAccount> list = session.createQuery("from BankAccount a where a.users.drfo=:drfo").setParameter("drfo", drfo).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public BankAccount getAcByUserAndCurr(Users users, Currency currency) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        BankAccount bankAccount = session.createQuery(
                "SELECT a from BankAccount a where a.users = :user and a.currency = :currency", BankAccount.class)
                .setParameter("user", users).setParameter("currency", currency).getSingleResult();
        session.close();
        return bankAccount;
    }


}
