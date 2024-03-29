package lk.ijse.bo.custom.impl;


import javafx.collections.ObservableList;
import lk.ijse.bo.SuperBO;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.entity.Admin;

import java.util.List;

public class AdminBOImpl implements AdminBO, SuperBO {
    private final AdminDAO adminDAO = (AdminDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);

    @Override
    public boolean saveAdmin(AdminDTO dto) throws Exception {
        return adminDAO.save(new Admin(
                dto.getName(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean updateAdmin(String id , AdminDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteAdmin(String id) throws Exception {
        return false;
    }

    @Override
    public AdminDTO searchAdmin(String id) throws Exception {
        return null;
    }

    @Override
    public ObservableList<AdminDTO> getAllAdmins() throws Exception {
        return null;
    }

    @Override
    public Admin searchAdmin(String name, String password) {
        Admin admin = adminDAO.searchAdmin(name, password);
        if (admin != null){
            return new Admin(
                    admin.getName(),
                    admin.getPassword()
            );
        }
        return null;
    }
}
