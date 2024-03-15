package lk.ijse.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.TransactionDTO;

public interface TransactionBO extends SuperBO {

    boolean saveTransaction(TransactionDTO dto) throws Exception;

    boolean updateTransaction(String id,TransactionDTO dto) throws Exception;

    boolean deleteTransaction(String id) throws Exception;

    TransactionDTO searchTransaction(String id) throws Exception;

    ObservableList<TransactionDTO> getAllTransaction() throws Exception;

    ObservableList<TransactionDTO> getUserTransaction(String user, String status) throws Exception;

    boolean updateStatus(int id,String status) throws Exception;

    ObservableList<TransactionDTO> getBranchTransaction(String branch) throws Exception;

}
