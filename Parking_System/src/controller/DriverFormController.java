package controller;

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

    public void saveDriver(ActionEvent actionEvent){
        String driverName = txtName.getText ( );
        String address = txtAddress.getText ( );
        String contact =  txtContact.getText ( );
        String nic = txtNic.getText ( );
        String drivingLicense = txtLicense.getText ( );


        DriverDTO driversDTO = new DriverDTO (
                txtName.getText ( ) ,
                txtAddress.getText ( ) ,
                txtContact.getText ( ) ,
                txtNic.getText ( ) ,
                txtLicense.getText ( )
        );

        if ( new ManageDriver ().saveDriver ( driversDTO ) ){
            Alert alert = new Alert( Alert.AlertType.INFORMATION, "Driver is Saved");
            alert.show();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
