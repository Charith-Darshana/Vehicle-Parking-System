package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FrontDisplayFormController implements Initializable {
    public TextField txtVehicleType;
    public ComboBox cmbVehicle;
    public ComboBox cmbDriver;
    public Label lblTime;
    public Label lblDate;

    public void onParkVehicle(ActionEvent actionEvent) {
    }

    public void onDiliveryShift(ActionEvent actionEvent) {
    }

    public void onManagement(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void generateDateTime() {
        lblDate.setText( LocalDate.now().toString());

        Timeline timeline = new Timeline( new KeyFrame( javafx.util.Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "hh:mm:ss a");
            lblTime.setText( LocalDateTime.now().format( formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount( Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateDateTime();
    }
}
