package controller;

import dao.CrudDAO;
import javafx.scene.control.Alert;
import model.Driver;

import java.util.ArrayList;
import java.util.List;

public class ManageDriver implements CrudDAO<Driver,String> {

    ArrayList<Driver> driverArrayList=new ArrayList<> ();

    private static ManageDriver manageDriver;

    private ManageDriver (){
        loadAll ();
    }

    public static ManageDriver getInstance(){
        if ( manageDriver==null ){
            manageDriver = new ManageDriver ();
            return manageDriver;
        }
        return manageDriver;
    }

    @Override
    public boolean save(Driver driver) {
        Driver driver1=get ( driver.getNic ( ) );
        if ( driver1!=null ){
            new Alert( Alert.AlertType.WARNING,"Duplicate NIC" ).show ();
        }else {
            boolean add = driverArrayList.add ( driver );
            return add;
        }

        return false;
    }

    @Override
    public boolean delete(String vehicleNumber) {
        return false;
    }

    @Override
    public boolean update(Driver driver) {
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return driverArrayList;
    }

    @Override
    public Driver get(String nic) {
        for ( int i = 0; i < driverArrayList.size (); i++ ) {
            Driver driver = driverArrayList.get ( i );
            if ( driver.getNic ().equals ( nic ) ){
                return driverArrayList.get ( i );
            }
        }
        return null;
    }

    @Override
    public List<Driver> loadAll() {
        driverArrayList.add ( new Driver ( "Avishka Fernando" , "Colombo" , "0779843356" , "7634987650v" , "B567837" ) );
        driverArrayList.add ( new Driver ( "Minod Bhanuka" , "Kottawa" , "0788867990" , "9087654379v" , "B765670" ) );
        driverArrayList.add ( new Driver ( "Bhanuka Rajapaksha" , "Colombo 3" , "0765411370" , "9678342565v" , "B775489" ) );
        driverArrayList.add ( new Driver ( "Dananjaya de Silva" , "Wadduwa" , "0757709874" , "9573536833V" , "B980980" ) );
        driverArrayList.add ( new Driver ( "Charith Asalanka" , "Matara" , "0776690999" , "7789023416v" , "B712455" ) );
        driverArrayList.add ( new Driver ( "Dasun Shanaka" , "Kalutara" , "0769901234" , "6643356789v" , "B663237" ) );
        driverArrayList.add ( new Driver ( "Wanindu Hasaranga" , "Galle" , "0715576660" , "7835348345V" , "B662809" ) );
        driverArrayList.add ( new Driver ( "Chamika Karunarathne" , "Horana" , "0707781235" , "8865543789v" , "B664234" ) );
        driverArrayList.add ( new Driver ( "Dushmanth Chameera" , "Panadura" , "0745589766" , "9965534654v" , "B465890" ) );
        driverArrayList.add ( new Driver ( "Akila Dananjaya" , "Polonnaruwa" , "0774563210" , "9135343537V" , "B321798" ) );
        driverArrayList.add ( new Driver ( "Praveen Jayawikkrama" , "Kandy" , "0786652341" , "9221678965v" , "B664986" ) );
        driverArrayList.add ( new Driver ( "Dinesh Chandimal" , "Trinco" , "0757790800" , "7789543677v" , "B651678" ) );
        driverArrayList.add ( new Driver ( "Angelo Mathews" , "Jaffna" , "0765543313" , "9865345678v" , "B446587" ) );
        driverArrayList.add ( new Driver ( "Dimuth Karunarathne" , "Hambanthota" , "0786690970" , "7987646113v" , "B559806" ) );
        driverArrayList.add ( new Driver ( "Kusal Perera" , "Hikkaduwa" , "0764456789" , "9076581056v" , "B234789" ) );
        driverArrayList.add ( new Driver ( "Kusal Mendis" , "Ambalangoda" , "0746688900" , "7798658767v" , "B778135" ) );

        return driverArrayList;
    }
}
