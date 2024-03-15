package lk.ijse.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDTO;

import java.io.IOException;
import java.util.regex.Pattern;

public class SignupFormController {

    @FXML
    private Button btnSignUp;

    @FXML
    private PasswordField pwdConfirmPassword;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private TextField textUserName;

    @FXML
    private TextField txtEmail;

    @FXML
    private Hyperlink txtLogin;
    private UserBO userBO;

    @FXML
    private AnchorPane pane;


    @FXML
    void btnSignOnAction(ActionEvent event) {
        if(validateUser()){
            String name = textUserName.getText();
            String email = txtEmail.getText();
            String password = pwdPassword.getText();

            UserDTO userDTO = new UserDTO(name, email, password);
            try {
                boolean isSaved = userBO.saveUser(userDTO);
                if (isSaved){
                    new Alert(Alert.AlertType.CONFIRMATION, "User Registered Successfully").show();
                    txtLoginOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "User Registration Failed").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void txtLoginOnAction() {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userLoginForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean validateUser(){
        String name = textUserName.getText();
        boolean isFirstNameValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(name).matches();

        if (!isFirstNameValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid name").show();
            textUserName.setStyle("-fx-border-color:#ff0000;");
            textUserName.requestFocus();
            return false;
        }

        String email = txtEmail.getText();
        boolean isEmailValidated = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();

        if (!isEmailValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid email").show();
            txtEmail.setStyle("-fx-border-color:#ff0000;");
            txtEmail.requestFocus();
            return false;
        }

        String password = pwdPassword.getText();
        boolean isPasswordValidated = Pattern.compile("^[A-Za-z0-9+_.-]{4,20}$").matcher(password).matches();

        if (!isPasswordValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid password").show();
            pwdPassword.setStyle("-fx-border-color:#ff0000;");
            pwdPassword.requestFocus();
            return false;
        }
        return true;
    }
}
