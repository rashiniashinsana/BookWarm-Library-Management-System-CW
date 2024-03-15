package lk.ijse.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AdminNavigationController {

    public static String branchName;
    @FXML
    private Pane NavigationPane;

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
    private Pane btnUserManagement;

    @FXML
    private Button btnViewBooks;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookGenre;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colBookTitle;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblBookManagement;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDashboard;


    @FXML
    void btnBookManagementOnAction(MouseEvent event) {

    }

    @FXML
    void btnBranchManagementOnAction(MouseEvent event) {

    }

    @FXML
    void btnEditProfileOnAction(MouseEvent event) {

    }

    @FXML
    void btnIssuedBooksOnAction(MouseEvent event) {

    }

    @FXML
    void btnLogoutOnAction(MouseEvent event) {

    }

    @FXML
    void btnOverViewOnAction(MouseEvent event) {

    }

    @FXML
    void btnUserManagementOnAction(MouseEvent event) {

    }

    @FXML
    void btnViewBooksOnAction(ActionEvent event) {

    }

}
