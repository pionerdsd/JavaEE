package by.homework.servlets.dao;
import by.homework.servlets.DB.HibernateUtil;
import by.homework.servlets.dao.daoInterface;
import by.homework.servlets.entity.Users;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.util.List;
public class DaoUsers implements daoInterface<Users> {
    @Override
    public void insert(Users o) {
        Session session = HibernateUtil.getSession();
        session.save(o);
        HibernateUtil.closeSession(session);
    }
    @Override
    public void update(Users o) {
        Session session = HibernateUtil.getSession();
        session.update(o);
        HibernateUtil.closeSession(session);
    }
    @Override
    public void delete(Users o) {
        Session session = HibernateUtil.getSession();
        session.delete(o);
        HibernateUtil.closeSession(session);
    }
    @Override
    public Users get(int id) {
        Session session = HibernateUtil.getSession();
        Users user = session.get(Users.class, id);
        HibernateUtil.closeSession(session);
        return user;
    }
    @Override
    public List<Users> getAll(String sql) {
        Session session = HibernateUtil.getSession();
        List<Users> list = session.createQuery(sql).list();
        HibernateUtil.closeSession(session);
        return list;
    }
  }

