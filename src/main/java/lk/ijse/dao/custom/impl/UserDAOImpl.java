package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean save(User saveUser){
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.persist(saveUser);
        saveTransaction.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id , User user) throws Exception {
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = updateSession.beginTransaction();
        User existingUser = updateSession.get(User.class, id);
        if (existingUser!= null) {
            existingUser.setName(user.getName());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            updateSession.merge(existingUser);
        } else {
            updateTransaction.commit();
            updateSession.close();
            return false;
        }
        updateTransaction.commit();
        updateSession.close();
        return true;
    }

    @Override
    public Book search(String id) throws Exception {
        return null;
    }

    @Override
    public List<Branch> loadAll() throws Exception {
        return null;
    }

    @Override
    public User searchUser(String name, String password) {
        Session searchSession = SessionFactoryConfig.getInstance().getSession();
        Transaction searchTransaction = searchSession.beginTransaction();
        Query<User> query = searchSession.createQuery("FROM User WHERE name = :name AND password = :password", User.class);
        query.setParameter("name", name);
        query.setParameter("password", password);

        User user = query.uniqueResult();
        searchTransaction.commit();
        searchSession.close();

        return user;
    }

    @Override
    public User searchUserId(String name) {
        Session searchSession = SessionFactoryConfig.getInstance().getSession();
        Transaction searchTransaction = searchSession.beginTransaction();
        Query<User> query = searchSession.createQuery("FROM User WHERE name = :name", User.class);
        query.setParameter("name", name);

        User user = query.uniqueResult();
        searchTransaction.commit();
        searchSession.close();

        return user;
    }
}
