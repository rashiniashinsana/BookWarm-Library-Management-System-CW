package lk.ijse.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BookBO;
import lk.ijse.dto.BookDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class AdminBookManagementController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

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
    private TableView<BookDTO> tblBookManagement;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtTitle;

    @FXML
    private Label lblBookManagement;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblTitle;



    private final BookBO bookBO = (BookBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BOOK);

    private final String branchName = AdminNavigationController.branchName;

    public void initialize(){
        //updateRealTime(lblTime);
        lblTitle.setText("Welcome  "+branchName+" Branch");
        txtBranchName.setText(branchName);
        reload();
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("branch"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (validateBook()){
            String branch = txtBranchName.getText();
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            String status = "Available";

            BookDTO bookDTO = new BookDTO(branch,title,author,genre,status);
            try {
                boolean isSaved = bookBO.saveBook(bookDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Added Successfully").show();
                    btnClearOnAction();
                    reload();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Book Added Failed").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        resetBoarderColour();
        txtBookId.setText("");
        txtBranchName.setText(branchName);
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        reload();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtBookId.getText();
        if (Pattern.compile("\\d+").matcher(id).matches()) {
            try {
                boolean isDeleted = bookBO.deleteBook(id);
                if (isDeleted){
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Delete Successfully").show();
                    txtBookId.setStyle("-fx-border-color:#ff0000;");
                    txtBookId.requestFocus();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Invalid book id").show();
                txtBookId.setStyle("-fx-border-color:#ff0000;");
                txtBookId.requestFocus();
            }
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtBookId.getText();
        if (Pattern.compile("\\d+").matcher(id).matches()) {
            try {
                BookDTO bookDTO = bookBO.searchBook(id);
                if (bookDTO != null){
                    txtBranchName.setText(bookDTO.getBranch());
                    txtTitle.setText(bookDTO.getTitle());
                    txtAuthor.setText(bookDTO.getAuthor());
                    txtGenre.setText(bookDTO.getGenre());
                }  else {
                    new Alert(Alert.AlertType.ERROR, "Please enter a valid book id").show();
                    txtBookId.setStyle("-fx-border-color:#ff0000;");
                    txtBookId.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtBookId.getText();

        if (Pattern.compile("\\d+").matcher(id).matches() && validateBook()) {
            String branch = txtBranchName.getText();
            String title = txtTitle.getText();
            String author = txtAuthor.getText();
            String genre = txtGenre.getText();
            String status = "Availble";

            BookDTO bookDTO = new BookDTO(branch,title,author,genre,status);
            try {
                boolean isUpdated = bookBO.saveBook(bookDTO);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Book Update Successfully").show();
                    btnClearOnAction();
                    reload();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Book Update Failed").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else {
            new Alert(Alert.AlertType.WARNING, "Invalid Book ID").show();
            txtBookId.setStyle("-fx-border-color:#ff0000;");
            txtBookId.requestFocus();
        }
    }

    private void btnClearOnAction() {
        resetBoarderColour();
        txtBookId.setText("");
        txtBranchName.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        reload();

    }

    private void loadAllBooks(){
        try {
            tblBookManagement.setItems(bookBO.getAllBooks(txtBranchName.getText()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateBook(){
        String title = txtTitle.getText();
        boolean isTitleValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(title).matches();

        if (!isTitleValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book title").show();
            txtTitle.setStyle("-fx-border-color:#ff0000;");
            txtTitle.requestFocus();
            return false;
        }

        String author = txtAuthor.getText();
        boolean isAuthorValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(author).matches();

        if (!isAuthorValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book author").show();
            txtAuthor.setStyle("-fx-border-color:#ff0000;");
            txtAuthor.requestFocus();
            return false;
        }

        String genre = txtGenre.getText();
        boolean isGenreValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(genre).matches();

        if (!isGenreValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid book genre").show();
            txtGenre.setStyle("-fx-border-color:#ff0000;");
            txtGenre.requestFocus();
            return false;
        }
        return true;
    }


    @FXML
    private void btnViewTransactionsOnAction() {
        try {
            URL resource = AdminBookManagementController.class.getResource("/view/admin/viewTransactionForm.fxml.fxml");
            Parent parent = FXMLLoader.load(resource);
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Transaction Form");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reload(){
        loadAllBooks();
        setCellValueFactory();
    }

    private void resetBoarderColour(){
        txtBookId.setStyle("-fx-border-color: black");
        txtAuthor.setStyle("-fx-border-color: black");
        txtTitle.setStyle("-fx-border-color: black");
        txtGenre.setStyle("-fx-border-color: black");
    }

    private void updateRealTime(Label label) {
        lblDate.setText(LocalDate.now().toString());
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            String currentTime = LocalDateTime.now().format(timeFormatter);
            Platform.runLater(() -> label.setText(currentTime));
        }, 0, 1, TimeUnit.SECONDS);
    }

}

