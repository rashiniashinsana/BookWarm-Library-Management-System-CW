package lk.ijse.dao.custom.impl;
import javafx.collections.ObservableList;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin addAdmin){
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        Transaction saveTransaction = saveSession.beginTransaction();
        saveSession.persist(addAdmin);
        saveTransaction.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id , Admin admin) throws Exception {
        return false;
    }

    @Override
    public Admin search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<Admin> loadAll() throws Exception {
        return null;
    }

    @Override
    public Admin searchAdmin(String name, String password) {
        Session searchSession = SessionFactoryConfig.getInstance().getSession();
        Transaction searchTransaction = searchSession.beginTransaction();
        Query<Admin> query = searchSession.createQuery("FROM Admin WHERE name = :name AND password = :password", Admin.class);
        query.setParameter("name", name);
        query.setParameter("password", password);

        Admin admin = query.uniqueResult();
        searchTransaction.commit();
        searchSession.close();

        return admin;
    }
}