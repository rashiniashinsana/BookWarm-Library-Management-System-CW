package lk.ijse.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Transaction;


public interface TransactionDAO extends CrudDAO<Transaction> {

    ObservableList<Transaction> getUserTransaction(String user, String status);

    boolean updateStatus(int id,String status);
}