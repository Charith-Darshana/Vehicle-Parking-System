package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Driver;

import java.util.regex.Pattern;


public class DriverFormController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtNic;
    public TextField txtLicense;
    public Button btnDriver;
    public ImageView btnBack;

    public void saveDriver(ActionEvent actionEvent) {
        if (Pattern.compile("^[A-z]{1,}[ ][A-z]{1,}$").matcher(txtName.getText()).matches()) {
            if (Pattern.compile("^[A-z]{1,}[ ][A-z]{1,}$").matcher(txtAddress.getText()).matches()) {
                if (Pattern.compile("^[0-9]{9,10}$").matcher(txtContact.getText()).matches()) {
                    if (Pattern.compile("^[0-9]{11,12}$").matcher(txtNic.getText()).matches()) {
                        if (Pattern.compile("^[0-9]{11,12}$").matcher(txtLicense.getText()).matches()) {
                            Driver drivers = new Driver(
                                    txtName.getText(),
                                    txtAddress.getText(),
                                    txtContact.getText(),
                                    txtNic.getText(),
                                    txtLicense.getText()
                            );
                            try {
                                if (ManageDriver.getInstance().save(drivers)) {
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Driver is Saved");
                                    alert.show();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
//                        }else {
//                            txtContact.setFocusColor ( Paint.valueOf ( "red" ) );
//                            txtContact.requestFocus ( );
//                        }
//                    }else {
//                        txtAddress.setFocusColor ( Paint.valueOf ( "red" ) );
//                        txtAddress.requestFocus ( );
//                    }
//                }
//                else {
//                    txtLicense.setFocusColor ( Paint.valueOf ( "red" ) );
//                    txtLicense.requestFocus ( );
//                }
//            }else {
//                txtNic.setFocusColor ( Paint.valueOf ( "red" ) );
//                txtNic.requestFocus ( );
//            }
//        }else {
//            txtName.setFocusColor ( Paint.valueOf ( "red" ) );
//            txtName.requestFocus ( );
//        }

                        }
                    }
                }
            }
        }
    }

    public void backOnAction(MouseEvent mouseEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
}
