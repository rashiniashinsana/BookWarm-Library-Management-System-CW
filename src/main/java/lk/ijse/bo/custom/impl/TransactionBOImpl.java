package lk.ijse.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.bo.custom.TransactionBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.TransactionDAO;
import lk.ijse.dto.TransactionDTO;
import lk.ijse.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionBOImpl implements TransactionBO {

    private final TransactionDAO transactionDAO = (TransactionDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TRANSACTION);

    @Override
    public boolean saveTransaction(TransactionDTO dto) throws Exception {
        return transactionDAO.save(new Transaction(

//                dto.getId(),
//                dto.getBranch(),
//                dto.getBookTitle(),
//                dto.getUserName(),
//                dto.getBorrowing(),
//                dto.getReturning(),
//                dto.getStatus()
//
        ));
    }

    @Override
    public boolean updateTransaction(String id, TransactionDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteTransaction(String id) throws Exception {
        return false;
    }

    @Override
    public TransactionDTO searchTransaction(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<TransactionDTO> getAllTransaction() throws Exception {
        List<Transaction> transactionList = transactionDAO.loadAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            transactionDTOS.add(new TransactionDTO(
                    transaction.getId(),
                    transaction.getBranch(),
                    transaction.getBookTitle(),
                    transaction.getUserName(),
                    transaction.getBorrowing(),
                    transaction.getReturning(),
                    transaction.getStatus()
            ));
        }
        return FXCollections.observableArrayList(transactionDTOS);
    }

    @Override
    public ObservableList<TransactionDTO> getUserTransaction(String user, String status) {
        List<Transaction> transactionList = transactionDAO.getUserTransaction(user,status);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            transactionDTOS.add(new TransactionDTO(
                    transaction.getId(),
                    transaction.getBranch(),
                    transaction.getBookTitle(),
                    transaction.getUserName(),
                    transaction.getBorrowing(),
                    transaction.getReturning(),
                    transaction.getStatus()
            ));
        }
        return FXCollections.observableArrayList(transactionDTOS);
    }

    @Override
    public boolean updateStatus(int id, String status) throws Exception {
        return transactionDAO.updateStatus(id,status);
    }

    @Override
    public ObservableList<TransactionDTO> getBranchTransaction(String branch) {
        List<Transaction> transactionList = transactionDAO.getBranchTransaction(branch);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            transactionDTOS.add(new TransactionDTO(
                    transaction.getId(),
                    transaction.getBranch(),
                    transaction.getBookTitle(),
                    transaction.getUserName(),
                    transaction.getBorrowing(),
                    transaction.getReturning(),
                    transaction.getStatus()
            ));
        }
        return FXCollections.observableArrayList(transactionDTOS);
    }
}