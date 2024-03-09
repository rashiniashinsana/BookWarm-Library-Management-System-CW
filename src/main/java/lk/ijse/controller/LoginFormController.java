package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class LoginFormController {

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

    @FXML
    void btnloginOnAction(ActionEvent event) {

    }

    @FXML
    void txtForgotPasswordOnAction(ActionEvent event) {

    }

}
