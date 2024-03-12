package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class ForgotPasswordFormController {

    @FXML
    private Rectangle forgotPasswordPane;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private Pane pane;

    @FXML
    private TextField textUserName;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private PasswordField txtEmail;

    @FXML
    private Hyperlink txtLoginPage;

    @FXML
    private PasswordField txtOtp;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void btnForgotOnAction(ActionEvent event) {

    }

    @FXML
    void btnSendOtpOnAction(ActionEvent event) {

    }

    @FXML
    void txtLoginPageOnAction(ActionEvent event) {

    }

}
