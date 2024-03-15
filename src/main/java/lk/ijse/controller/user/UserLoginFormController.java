package lk.ijse.controller.user;

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
import lk.ijse.bo.custom.UserBO;
import lk.ijse.entity.User;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserLoginFormController {

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
    private Hyperlink txtSignUp;

    @FXML
    private Text txtSupport;

    @FXML
    private Text txtTerms;
    public static  String member;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    void btnLoginOnAction(ActionEvent event) {
        if (validateAdmin()){
            searchUser();
        }
    }

    @FXML
    void txtForgotPasswordOnAction(ActionEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/ForgotPassword.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void txtSignUpOnAction(ActionEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userSignupForm.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchUser(){
//        String username = textUserName.getText();
//        String password = txtPassword.getText();
//        try {
//
//            User user = UserBO.searchUser(username,password);
//            if (user == null){
//                new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
//            } else {
//                member = username;
//                loadDashboard();
//            }
//        } catch (Exception e) {
//            new Alert(Alert.AlertType.WARNING,"Incorrect username or password").show();
//        }
    }


    private void loadDashboard(){
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userDashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("User Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    private boolean validateAdmin(){
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
}
