package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Pattern;

public class LoginFormController {
    public TextField txtUserName;
    public TextField txtPassword;
    public Button btnLogin;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if (Pattern.compile("^[A-z, /]*\\b$").matcher(txtUserName.getText()).matches()) {
            if (Pattern.compile("^\\d{4}$").matcher(txtPassword.getText()).matches()) {
                String email = txtUserName.getText().trim();
                String password = txtPassword.getText().trim();

                if (email.length() > 0 && password.length() > 0) {

                    if (email.equalsIgnoreCase("Park")
                            && password.equalsIgnoreCase("1234")) {


                        URL resource = this.getClass().
                                getResource("/view/InParkingForm.fxml");
                        Parent load = FXMLLoader.load(resource);
                        Scene scene = new Scene(load);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();


                    } else {
                        new Alert(Alert.AlertType.WARNING, "Try Again !!",
                                ButtonType.OK, ButtonType.NO).show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Empty !!",
                            ButtonType.OK, ButtonType.NO).show();
                }
//            }else {
//                txtPassword.setFocusColor(Paint.valueOf("red"));
//                txtPassword.requestFocus();
//            }
//        }else{
//            txtUserName.(Paint.valueOf("red"));
//            txtUserName.requestFocus();
//        }
            }

        }
    }
}
