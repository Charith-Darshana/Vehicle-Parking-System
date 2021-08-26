package controller;

import bo.custom.DriverBO;
import dto.DriverDTO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DriverFormController implements Initializable {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtNic;
    public TextField txtLicense;
    public Button btnDriver;

    public void saveDriver(ActionEvent actionEvent) throws Exception {
        boolean b = DriverBO.saveDriver(new DriverDTO(txtName.getText(), txtAddress.getText(), txtContact.getText(),txtNic.getText(), txtLicense.getText()));

        if(b){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Course Added Success...");
            alert.showAndWait();
        }
        txtCode.setText("");
        txtName.setText("");
        txtType.setText("");
        txtDuration.setText("");

        loadAllPrograms();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
