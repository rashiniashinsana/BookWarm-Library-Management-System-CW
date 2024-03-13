package lk.ijse.dao;


import lk.ijse.entity.Book;
import lk.ijse.entity.Branch;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO{
    boolean save(T dto) throws Exception;

    boolean delete(String id) throws Exception;

    boolean update(String id , T dto) throws Exception;

    Book search(String id) throws Exception;

    List<Branch> loadAll() throws Exception;
}
