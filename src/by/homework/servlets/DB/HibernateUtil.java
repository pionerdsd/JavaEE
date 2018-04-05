package by.homework.servlets.DB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;





public class HibernateUtil {
    private static SessionFactory factory;
    static {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static Session getSession(){
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public static void closeSession (Session session) {
        if (session != null){
            session.getTransaction().commit();
            session.close();
        }
    }

    public static void closeFactory(){
        if(factory != null) {
            factory.close();
        }
    }
}
