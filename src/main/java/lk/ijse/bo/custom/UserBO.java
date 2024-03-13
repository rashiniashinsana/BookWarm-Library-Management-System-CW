package lk.ijse.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.User;

public interface UserBO extends SuperBO {

    boolean saveUser(UserDTO dto) throws Exception;

    boolean updateUser(String id,UserDTO dto) throws Exception;

    boolean deleteUser(String id) throws Exception;

    UserDTO searchUser(String id) throws Exception;

    ObservableList<UserDTO> getAllUsers() throws Exception;

    User searchUser(String name, String password) throws Exception;

    User searchUserId(String name) throws Exception;

}