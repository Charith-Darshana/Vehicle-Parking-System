package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Vehicle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class VehicleFormController {
    public TextField txtNum;
    public TextField txtPassenger;
    public TextField txtWeight;
    public ComboBox txtType;
    public Button btnVehicle;
    public ImageView btnBack;

    public void initialize(){
        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("Van");
        observableArrayList.add("Buss");
        observableArrayList.add("Lorry");
        txtType.setItems(observableArrayList);
    }

    public void saveVehicle(ActionEvent actionEvent) {
        if (Pattern.compile("^[A-Z]{2}(-)[0-9]{4}$").matcher(txtNum.getText()).matches()) {
            if (Pattern.compile("^[0-9]{4}$").matcher(txtWeight.getText()).matches()) {
                if (Pattern.compile("^[0-9]{1,2}$").matcher(txtPassenger.getText()).matches()) {
                    Vehicle vehicle = new Vehicle(
                            txtNum.getText(),
                            (String) txtType.getValue(),
                            txtWeight.getText(),
                            Integer.parseInt(txtPassenger.getText())
                    );
                    try {
                        if (ManageVehicle.getInstance().save(vehicle)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vehicle is Saved");
                            Stage stage = (Stage) btnVehicle.getScene().getWindow();
                            stage.close();
                            alert.show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

//                }else {
//                    txtPassenger.setFocusColor ( Paint.valueOf ( "red" ) );
//                    txtPassenger.requestFocus ();
//                }
//
//            }else {
//                txtWeight.setFocusColor ( Paint.valueOf ( "red" ) );
//                txtWeight.requestFocus ();
//            }
//        }else {
//            txtNum.setFocusColor ( Paint.valueOf ( "red" ) );
//            txtNum.requestFocus ();
//        }
                }
            }
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
}