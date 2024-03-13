package lk.ijse.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dto.AdminDTO;
import lk.ijse.entity.Admin;

import java.io.IOException;
import java.util.regex.Pattern;

public class AdminLoginFormController {

    @FXML
    private Button btnLogin;

    @FXML
    private Pane pane;

    @FXML
    private TextField textUserName;

    @FXML
    private Text txtCCare;

    @FXML
    private Hyperlink txtForgotPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text txtSupport;

    @FXML
    private Text txtTerms;


    private final AdminBO adminBO = (AdminBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ADMIN);

    public void initialize(){
        addDefaultAdmin();
    }


    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (validateAdmin()){
            searchAdmin();
        }
    }

    private void searchAdmin() {
        String username = textUserName.getText();
        String password = txtPassword.getText();
        try {
            Admin admin = adminBO.searchAdmin(username,password);
            if (admin == null){
                new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
            } else {
                loadDashboard();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
        }
    }

    private void loadDashboard() {
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/admin/adminNavigationForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    private boolean validateAdmin() {
        String name = textUserName.getText();
        boolean isFirstNameValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(name).matches();

        if (!isFirstNameValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid user name").show();
            textUserName.setStyle("-fx-border-color:#ff0000;");
            textUserName.requestFocus();
            return false;
        }

        String password = txtPassword.getText();
        boolean isPasswordValidated = Pattern.compile("^[A-Za-z0-9+_.-]{4,20}$").matcher(password).matches();

        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid password").show();
            txtPassword.setStyle("-fx-border-color:#ff0000;");
            txtPassword.requestFocus();
            return false;
        }
        return true;

    }

    @FXML
    void txtForgotPasswordOnAction(ActionEvent event) {

        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/ForgotPassword.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Admin Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    public void txtSignUpOnAction(ActionEvent actionEvent) {
    }


    private void addDefaultAdmin() {

        AdminDTO adminDTO = new AdminDTO("sandun","1234");
        try {
            adminBO.saveAdmin(adminDTO);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
}
