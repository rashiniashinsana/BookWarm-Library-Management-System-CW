package lk.ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdminNavigationController {

    @FXML
    private Pane NavigationPane;

    @FXML
    private AnchorPane root;

    @FXML
    private Pane btnBookManagement;

    @FXML
    private Pane btnBranchManagement;

    @FXML
    private Pane btnEditProfile;

    @FXML
    private Pane btnIssuedBooksManagement;

    @FXML
    private Pane btnLogoutOnAction;

    @FXML
    private Pane btnOverView;

    @FXML
    private Pane btnRegisterUser;

    @FXML
    private Pane btnAuthorManagement;



    @FXML
    void btnEditProfileOnAction(MouseEvent event) {

    }

    @FXML
    void btnIssuedBooktOnAction(MouseEvent event) {

    }

    @FXML
    void btnLogoutOnAction(MouseEvent event) {

    }



    @FXML
    void btnBookManagementOnAction(MouseEvent event) throws IOException {

        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminBookManagement.fxml")));
    }

    @FXML
    void btnBranchManagementOnAction(MouseEvent event) throws IOException {

        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminBranchManagement.fxml")));

    }


    @FXML
    void btnOverViewOnAction(MouseEvent event) throws IOException {
        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/AdminNavigation.fxml")));
    }

    @FXML
    void btnUserManagementOnAction(MouseEvent event) throws IOException {

        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminUserManagement.fxml")));

    }



}

