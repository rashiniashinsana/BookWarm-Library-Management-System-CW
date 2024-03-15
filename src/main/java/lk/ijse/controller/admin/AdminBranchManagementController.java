package lk.ijse.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dto.BranchDTO;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

public class AdminBranchManagementController {

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchManager;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableView<BranchDTO> tblBranchId;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtBranchManager;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSearch;

    public static String branchName;

    private final BranchBO branchBO = (BranchBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.BRANCH);

    public void initialize(){
        reload();
        openBranch();
    }

    private void setCellValueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBranchManager.setCellValueFactory(new PropertyValueFactory<>("manager"));
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (validateBranch()){
            String name = txtBranchName.getText();
            String manager = txtBranchManager.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();

            BranchDTO branchDTO = new BranchDTO(name,manager,address,email);
            try {
                boolean isSaved = branchBO.saveBranch(branchDTO);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Registered Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch Registration Failed").show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void btnClearOnAction() {
        resetBoarderColour();
        reload();
        txtSearch.setText("");
        txtBranchName.setText("");
        txtBranchManager.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtSearch.getText();
        if (Pattern.compile("\\d+").matcher(id).matches()){
            try {
                boolean isDeleted = branchBO.deleteBranch(id);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Delete Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch not found").show();
                    txtSearch.setStyle("-fx-border-color:#ff0000;");
                    txtSearch.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  else {
            new Alert(Alert.AlertType.WARNING, "Invalid Branch ID").show();
            txtSearch.setStyle("-fx-border-color:#ff0000;");
            txtSearch.requestFocus();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtSearch.getText();
        if (Pattern.compile("\\d+").matcher(id).matches()) {
            try {
                BranchDTO branchDTO = branchBO.searchBranch(id);
                if (branchDTO != null) {
                    txtBranchName.setText(branchDTO.getName());
                    txtBranchManager.setText(branchDTO.getManager());
                    txtAddress.setText(branchDTO.getAddress());
                    txtEmail.setText(branchDTO.getEmail());
                    txtSearch.setStyle("-fx-border-color:black;");
                } else {
                    new Alert(Alert.AlertType.ERROR, "Please enter a valid id").show();
                    txtSearch.setStyle("-fx-border-color:#ff0000;");
                    txtSearch.requestFocus();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtSearch.getText();

        if (Pattern.compile("\\d+").matcher(id).matches() && validateBranch()) {
            String name = txtBranchName.getText();
            String manager = txtBranchManager.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();

            BranchDTO branchDTO = new BranchDTO(name,manager,address,email);
            try {
                boolean isUpdated = branchBO.updateBranch(id,branchDTO);
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated Successfully").show();
                    btnClearOnAction();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Branch not found").show();
                    txtSearch.setStyle("-fx-border-color:#ff0000;");
                    txtSearch.requestFocus();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            new Alert(Alert.AlertType.WARNING, "Invalid Branch ID").show();
            txtSearch.setStyle("-fx-border-color:#ff0000;");
            txtSearch.requestFocus();
        }
    }

    private boolean validateBranch(){
        String name = txtBranchName.getText();
        boolean isNameValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(name).matches();

        if (!isNameValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid branch name").show();
            txtBranchName.setStyle("-fx-border-color:#ff0000;");
            txtBranchName.requestFocus();
            return false;
        }

        String managerName = txtBranchManager.getText();
        boolean isManagerValidated = Pattern.compile("^[A-Za-z]{1,20}$").matcher(managerName).matches();

        if (!isManagerValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid manager name").show();
            txtBranchManager.setStyle("-fx-border-color:#ff0000;");
            txtBranchManager.requestFocus();
            return false;
        }

        String address = txtAddress.getText();
        boolean isAddressValidated = Pattern.compile("^[A-z]{1,20}$").matcher(address).matches();
        if (!isAddressValidated) {
            txtAddress.requestFocus();
            txtAddress.setStyle("-fx-border-color:#ff0000;");
            return false;
        }

        String email =txtEmail.getText();
        boolean isEmailValidated = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();

        if (!isEmailValidated) {
            new Alert(Alert.AlertType.WARNING, "Please enter a valid email").show();
            txtEmail.setStyle("-fx-border-color:#ff0000;");
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }

    private void openBranch(){
        try {
            tblBranchId.setOnMouseClicked(event -> {
                BranchDTO selectedItem = tblBranchId.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Optional<ButtonType> result = new Alert(Alert.AlertType.INFORMATION, "Are you sure want to open this Branch?", ok, no).showAndWait();
                    if (result.orElse(no) == ok) {
                        branchName = selectedItem.getName();
                        loadBranch();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllBranches(){
        try {
            tblBranchId.setItems(branchBO.getAllBranches());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBranch(){
        try {
            AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/admin/bookManageForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(branchName+" Branch");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            new Alert(Alert.AlertType.WARNING,e.getMessage()).show();
        }
    }

    private void reload(){
        loadAllBranches();
        setCellValueFactory();
    }

    private void resetBoarderColour(){
        txtSearch.setStyle("-fx-border-color: black");
        txtBranchName.setStyle("-fx-border-color: black");
        txtBranchManager.setStyle("-fx-border-color: black");
        txtAddress.setStyle("-fx-border-color: black");
        txtEmail.setStyle("-fx-border-color: black");
    }
}
