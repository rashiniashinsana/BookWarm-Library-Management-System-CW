package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private Pane btnUserManagement;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colISBN;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<?> tblBookDetails;


    @FXML
    void btnEditProfileOnAction(MouseEvent event) throws IOException {
        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminAccountSettings.fxml")));

    }

    @FXML
    void btnIssuedBooktOnAction(MouseEvent event) throws IOException {
        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminIssuedBookManagement.fxml")));

    }

    @FXML
    void btnLogoutOnAction(MouseEvent event) throws IOException {
        NavigationPane.getChildren().clear();
        NavigationPane.getChildren().add(FXMLLoader.load(this.getClass().getResource("/View/AdminNavigation.fxml")));
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


    public void btnViewBooksOnAction(MouseEvent event) {

    }
}

