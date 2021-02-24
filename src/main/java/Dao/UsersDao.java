package Dao;


import Entity.Users;
import Util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


public class UsersDao extends Dao<Users> {
    @Override
    public void insert(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(users);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Users users) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(users);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Users> getAll(int all) {
        return null;
    }

    public Users getUserByDrfo(int drfo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Users a = session.createQuery("SELECT u from Users u where u.drfo = :username", Users.class).setParameter("username", drfo).getSingleResult();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        return a;
    }

}
