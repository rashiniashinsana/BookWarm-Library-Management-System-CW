package lk.ijse.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.entity.Admin;

public interface AdminBO extends SuperBO {

    boolean saveAdmin(AdminDTO dto) throws Exception;

    boolean updateAdmin(String id,AdminDTO dto) throws Exception;

    boolean deleteAdmin(String id) throws Exception;

    AdminDTO searchAdmin(String id) throws Exception;

    ObservableList<AdminDTO> getAllAdmins() throws Exception;

    Admin searchAdmin(String name, String password);

}
