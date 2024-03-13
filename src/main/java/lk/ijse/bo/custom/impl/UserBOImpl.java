package lk.ijse.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.User;

import java.util.List;

public class UserBOImpl implements UserBO {
    private final UserDAO userDAO = (UserDAO)
            DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO dto) throws Exception {
        return userDAO.save(new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateUser(String id , UserDTO dto) throws Exception {
        return userDAO.update(id,new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return false;
    }

    @Override
    public UserDTO searchUser(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<UserDTO> getAllUsers() throws Exception {
        return null;
    }

    @Override
    public User searchUser(String name, String password) {
        User user = userDAO.searchUser(name,password);
        if (user != null){
            return new User(
                    user.getName(),
                    user.getPassword()
            );
        }
        return null;
    }

    @Override
    public User searchUserId(String name)  {
        User user = userDAO.searchUserId(name);
        if (user != null){
            return new User(
                    user.getId()
            );
        }
        return null;
    }
}
