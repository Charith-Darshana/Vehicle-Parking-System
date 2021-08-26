package controller;

import db.DB;
import dto.VehicleDTO;

public class ManageVehicle {
    public boolean saveVehicle ( VehicleDTO vehicle ) {
        DB db = new DB ( );
        db.saveVehicle ( vehicle.getVehicleNumber ( ) , vehicle.getVehicleType ( ) , vehicle.getMaximumWeight ( ) , vehicle.getNoOfPassenger ( ) );
        return true;
    }
}
