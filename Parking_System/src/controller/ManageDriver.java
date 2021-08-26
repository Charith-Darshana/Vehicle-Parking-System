package controller;

import db.DB;
import dto.DriverDTO;

public class ManageDriver {
    public boolean saveDriver( DriverDTO driver ){
        DB db = new DB ( );
        db.saveDrivers( driver.getDriverName ( ) , driver.getAddress ( ) , driver.getContact ( ) , driver.getNic ( ) , driver.getDrivingLicense ( ) );

        return true;
    }
}
