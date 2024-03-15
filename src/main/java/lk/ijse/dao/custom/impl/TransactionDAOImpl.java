package lk.ijse.dao.custom.impl;

import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.entity.Transaction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Date;
import java.time.LocalDate;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public boolean save(Transaction addTransaction) throws Exception {
        Session saveSession = SessionFactoryConfig.getInstance().getSession();
        org.hibernate.Transaction saveBranch = saveSession.beginTransaction();
        saveSession.persist(addTransaction);
        saveBranch.commit();
        saveSession.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public boolean update(String id, Transaction dto) throws Exception {
        return false;
    }

    @Override
    public Transaction search(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<Transaction> loadAll() {
        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Query<Transaction> query = session.createQuery("FROM Transaction WHERE returning < CURRENT_DATE", Transaction.class);
            transactions.addAll(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public ObservableList<Transaction> getUserTransaction(String user, String status) {
        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Query<Transaction> query = session.createQuery("FROM Transaction WHERE userName = :userName AND status = :status", Transaction.class);
            query.setParameter("userName", user);
            query.setParameter("status",status);
            transactions.addAll(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public ObservableList<Transaction> getBranchTransaction(String branch) {
        ObservableList<Transaction> transactions = FXCollections.observableArrayList();
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Query<Transaction> query = session.createQuery("FROM Transaction WHERE branch = :branch", Transaction.class);
            query.setParameter("branch", branch);
            transactions.addAll(query.getResultList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public boolean updateStatus(int id, String status) {
        Session updateSession = SessionFactoryConfig.getInstance().getSession();
        Transaction updateTransaction = (Transaction) updateSession.beginTransaction();
        Transaction existingTransaction = updateSession.get(Transaction.class, id);
        if (existingTransaction!= null) {
            existingTransaction.setStatus(status);
            existingTransaction.setReturning(Date.valueOf(LocalDate.now()));
            updateSession.merge(existingTransaction);
        } else {
            //updateTransaction.commit();
            updateSession.close();
            return false;
        }
        //updateTransaction.commit();
        updateSession.close();
        return true;
    }
}