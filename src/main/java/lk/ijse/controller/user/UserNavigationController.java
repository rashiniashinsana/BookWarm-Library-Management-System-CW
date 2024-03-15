package lk.ijse.controller.user;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserNavigationController {

    @FXML
    private Pane NavigationPane;

    @FXML
    private Pane btnAccountSetting;

    @FXML
    private Pane btnBorrow;

    @FXML
    private Button btnEdit;

    @FXML
    private Pane btnHistory;

    @FXML
    private Pane btnLogout;

    @FXML
    private Pane btnOverView;

    @FXML
    private Button btnReturn;

    @FXML
    private AnchorPane pane;

    public void initialize(){

    }

    @FXML
    void btnAccountSettingOnAction(MouseEvent event) {

        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userAccountSettings.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnBorrowOnAction(MouseEvent event) {

        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userBorrowBooksForm.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnEditOnAction(MouseEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userAccountSettings.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnHistoryManagementOnAction(MouseEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userHistory.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnLogoutOnAction(MouseEvent event) {
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userLoginForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Home Form");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    @FXML
    void btnOverViewOnAction(MouseEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userNavigationForm.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnReturnOnAction(MouseEvent event) {
        pane.getChildren().clear();
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/userBorrowBooksForm.fxml"));
            pane.getChildren().add(anchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
