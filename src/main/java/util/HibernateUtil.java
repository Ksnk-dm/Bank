package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }catch (ConfigurationException e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


