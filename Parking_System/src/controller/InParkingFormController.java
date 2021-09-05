package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Delivery;
import model.Driver;
import model.Parking;
import model.Vehicle;
import view.tm.DeliveryTM;
import view.tm.DriverTM;
import view.tm.ParkingTM;
import view.tm.VehicleTM;

import java.io.IOException;
import java.util.List;

public class InParkingFormController {
    public Button btnV;
    public Button btnD;
    public AnchorPane tblRoot;
    public TableView tblDriver;
    public TableColumn colDriverName;
    public TableColumn colDriverAddress;
    public TableColumn colDriverContact;
    public TableColumn colDriverNic;
    public TableColumn colDriverLicense;
    public TableView tblVehicle;
    public TableColumn colVehicleNumber;
    public TableColumn colVehicleType;
    public TableColumn colPassengers;
    public TableColumn colWeight;
    public TableView tblOnDelivery;
    public TableColumn colDeliveryVehicleNumber;
    public TableColumn colDeliveryType;
    public TableColumn colDeliveryDriverName;
    public TableColumn colDeliveryTime;
    public TableView tblPark;
    public TableColumn colParkVehicleNumber;
    public TableColumn colParkType;
    public TableColumn colParkSlot;
    public TableColumn colParkTime;
    public ComboBox cmbSelect;
    public Button btnLogOut;

    public void initialize(){
        loadAllVehicle();
        loadAllDrivers();
        loadAllParking();
        loadAllDelivery();

        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("In Parking");
        observableArrayList.add("On Delivery");
        observableArrayList.add("Vehicle");
        observableArrayList.add("Driver");
        cmbSelect.setItems(observableArrayList);

        colDriverName.setCellValueFactory ( new PropertyValueFactory<>( "driverName" ) );
        colDriverAddress.setCellValueFactory ( new PropertyValueFactory<> ( "address" ) );
        colDriverContact.setCellValueFactory ( new PropertyValueFactory<> ( "contactNo" ) );
        colDriverNic.setCellValueFactory ( new PropertyValueFactory<> ( "nic" ) );
        colDriverLicense.setCellValueFactory ( new PropertyValueFactory<> ( "drivingLicenseNo" ) );

        colVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colPassengers.setCellValueFactory ( new PropertyValueFactory<> ( "noOfPassengers" ) );
        colWeight.setCellValueFactory ( new PropertyValueFactory<> ( "maximumWeight" ) );

        colParkVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colParkType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colParkSlot.setCellValueFactory ( new PropertyValueFactory<> ( "parkingSlot" ) );
        colParkTime.setCellValueFactory ( new PropertyValueFactory<> ( "date" ) );

        colDeliveryVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colDeliveryType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colDeliveryDriverName.setCellValueFactory ( new PropertyValueFactory<> ( "driverName" ) );
        colDeliveryTime.setCellValueFactory ( new PropertyValueFactory<> ( "leftTime" ) );

    }

    public void addDriver(ActionEvent actionEvent) {
        try {
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblPark.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( true );


            Scene scene = new Scene ( FXMLLoader.load ( getClass ( ).getResource ( "../view/DriverForm.fxml" ) ) );

            Stage primaryStage = new Stage ( );
            primaryStage.setScene ( scene );
            primaryStage.show ( );
        } catch ( IOException e ){
            e.printStackTrace ( );
        }
    }

    public void addVehicle(ActionEvent actionEvent){
        tblVehicle.setVisible ( true );
        tblOnDelivery.setVisible ( false );
        tblPark.setVisible ( false );
        tblOnDelivery.setVisible ( false );
        tblDriver.setVisible ( false );

        try {
            Scene scene = new Scene ( FXMLLoader.load ( getClass ( ).getResource ( "../view/VehicleForm.fxml" ) ) );

            Stage primaryStage = new Stage ( );
            primaryStage.setScene ( scene );
            primaryStage.show ( );

        } catch ( IOException e ) {
            e.printStackTrace ( );
        }
    }

    public void cmdManagement(ActionEvent actionEvent) {
        Object value = cmbSelect.getValue ( );
        if ( value=="In Parking" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblPark.setVisible ( true );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( false );
        }else if ( value=="On Delivery" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblPark.setVisible ( false );
            tblOnDelivery.setVisible ( true );
            tblDriver.setVisible ( false );
        }else if ( value=="Vehicle" ){
            tblVehicle.setVisible ( true );
            tblOnDelivery.setVisible ( false );
            tblPark.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( false );
        }else if ( value=="Driver" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblPark.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( true );
        }
    }

    public void loadAllDrivers(){
        tblVehicle.refresh ();
        List<Driver> drivers = ManageDriver.getInstance ( ).getAll ( );

        ObservableList<DriverTM> driverTMS = FXCollections.observableArrayList ( );

        for (Driver driver: drivers) {
            driverTMS.add ( new DriverTM ( driver.getDriverName (),driver.getNic (),driver.getDrivingLicenseNo (),driver.getAddress (),driver.getContactNo () ) );
        }
        tblDriver.setItems ( driverTMS );
    }

    public void loadAllVehicle(){
        tblVehicle.refresh ();
        try {
            List<Vehicle> vehicleArrayList = ManageVehicle.getInstance ().getAll ( );

            ObservableList<VehicleTM> vehicleTMS = FXCollections.observableArrayList ( );

            for ( Vehicle vehicle : vehicleArrayList ) {
                vehicleTMS.add ( new VehicleTM ( vehicle.getVehicleNumber ( ) , vehicle.getMaximumWeight ( ) , vehicle.getVehicleType ( ) , vehicle.getNoOfPassengers ( ) ) );
            }
            tblVehicle.setItems ( vehicleTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void loadAllParking(){
        try {
            List<Parking> all = ManageParking.getInstance ( ).getAll ( );

            ObservableList<ParkingTM> parkingTMS = FXCollections.observableArrayList ( );

            for (Parking parking:all) {
                parkingTMS.add ( new ParkingTM ( parking.getVehicleNumber (),parking.getVehicleType (),parking.getParkingSlot (),parking.getDate () ) );
            }
            tblPark.setItems ( parkingTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void loadAllDelivery(){

        List<Delivery> all = ManageDelivery.getInstance ( ).getAll ( );

        ObservableList<DeliveryTM> deliveryTMS = FXCollections.observableArrayList ( );

        for ( Delivery delivery : all) {
            deliveryTMS.add ( new DeliveryTM ( delivery.getVehicleNumber (),delivery.getVehicleType (),delivery.getDriverName (),delivery.getLeftTime () ) );
        }
        tblOnDelivery.setItems ( deliveryTMS );
    }

    public void logOutOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }
}
