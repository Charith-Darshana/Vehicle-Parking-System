package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Delivery;
import model.Driver;
import model.Parking;
import model.Vehicle;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class FrontDisplayFormController {
    public TextField txtVehicleType;
    public ComboBox cmbVehicle;
    public ComboBox cmbDriver;
    public Label lblTime;
    public Label lblDate;
    public Button btnPark;
    public Button btnShift;
    public Button btnManagement;
    public Label lblSlot;

    public void initialize(){
        generateDateTime();
        getAllVehicle();
        getAllDrivers();
    }

    public void getAllVehicle(){
        cmbDriver.setItems (null);
        try {
            List< Vehicle > all = ManageVehicle.getInstance ().getAll ( );

            ObservableList<String> observableList = FXCollections.observableArrayList ( );

            System.out.println(observableList);

            for (Vehicle vehicle : all ) {
                observableList.add ( vehicle.getVehicleNumber () ) ;
            }
            cmbVehicle.setItems (observableList);
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void getAllDrivers(){
        try {
            List<Driver> all = ManageDriver.getInstance ( ).getAll ( );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for (Driver driver : all) {
                observableList.add ( driver.getDriverName ( ) );
            }
            cmbDriver.setItems ( observableList );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void onParkVehicle(ActionEvent actionEvent) {
        try {
            SimpleDateFormat formatter=new SimpleDateFormat ( "dd/MM/yyyy HH:mm" );
            Date date=new Date ( );

            ManageDelivery manageDelivery=ManageDelivery.getInstance ( );
            Delivery delivery=manageDelivery.get ( (String) cmbVehicle.getValue ( ) );
            if ( delivery != null ) {
                manageDelivery.delete ( delivery.getVehicleNumber ( ) );
            }
            else {

                Parking parking=new Parking (
                        (String) cmbVehicle.getValue ( ) ,
                        txtVehicleType.getText ( ) ,
                        lblSlot.getText ( ) ,
                        formatter.format ( date )
                );


                if ( ManageParking.getInstance ( ).save ( parking ) ) {
                    Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Vehicle is Park" );
                    alert.show ( );
                    clearText ( );
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void onDiliveryShift(ActionEvent actionEvent) {
        try {
            boolean delete = ManageParking.getInstance ( ).delete ((String) cmbVehicle.getValue () );
            if ( delete ){
                SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm");
                Date date = new Date();

                Delivery delivery = new Delivery (
                        (String) cmbVehicle.getValue ( ) ,
                        txtVehicleType.getText ( ) ,
                        (String) cmbDriver.getValue ( ) ,
                        formatter.format ( date )
                );
                try {
                    if ( ManageDelivery.getInstance ().save ( delivery ) ){
                        Alert alert = new Alert( Alert.AlertType.INFORMATION, "Its Deliver");
                        alert.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace ( );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
        clearText();
    }

    public void onManagement(ActionEvent actionEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml")));
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void generateDateTime() {
        lblDate.setText(LocalDate.now().toString());

        Timeline timeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void clearText(){
        cmbVehicle.setValue ( null );
        txtVehicleType.setText ( "" );
        cmbDriver.setValue ( null );
        btnShift.setDisable ( false );
        btnPark.setDisable ( false );
    }

    public void selectVehicleNumber(ActionEvent actionEvent) {
        try {
            List< Vehicle > all = ManageVehicle.getInstance ( ).getAll ( );

            for ( Vehicle vehicle : all ) {
                try {
                    if ( cmbVehicle.getValue ( ).equals ( vehicle.getVehicleNumber ( ) ) ) {
                        txtVehicleType.setText ( vehicle.getVehicleType ( ) );

                        switch (txtVehicleType.getText ( )) {
                            case "Bus":
                                lblSlot.setText ( "14" );
                                break;
                            case "Van":
                                String s = ManageParking.getInstance ( ).vanSlot ( );
                                lblSlot.setText ( s );
                                break;
                            case "Cargo Lorry":
                                String s1=ManageParking.getInstance ( ).cargoSlot ( );
                                lblSlot.setText ( s1 );
                                break;
                        }
                    }
                    Parking parking = ManageParking.getInstance ( ).get ( (String) cmbVehicle.getValue ( ) );
                    if ( parking != null ) {
                        btnPark.setDisable ( true );
                    }
                    else {
                        btnPark.setDisable ( false );
                    }
                    Delivery delivery = ManageDelivery.getInstance ( ).get ( (String) cmbVehicle.getValue ( ) );
                    btnShift.setDisable ( delivery != null );
                } catch ( NullPointerException ignored ) {

                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void selectDriverName(ActionEvent actionEvent) {
        try {
            List< Parking > all = ManageParking.getInstance ( ).getAll ( );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for ( Parking parking : all) {
                observableList.add ( parking.getVehicleType () );
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }
}
