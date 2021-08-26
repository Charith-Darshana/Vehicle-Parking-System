package db;

public class DB {
    static String[][] drivers = new String[16][5];
    static String[][] vehicles = new String[14][4];

    public String [][] getDrivers(){
        return drivers;
    }

    public void saveDrivers( String driverName, String address, String contact, String nic, String drivingLicense){
        for (int i = 0; i < 16; i++) {
            if ( drivers[i][0]==null ) {
                drivers[ i ][ 0 ] = driverName;
                drivers[ i ][ 1 ] = address;
                drivers[ i ][ 2 ] = contact;
                drivers[ i ][ 3 ] = nic;
                drivers[ i ][ 4 ] = drivingLicense;
                return;
            }
        }
    }

    public void saveVehicle(String vehicleNumber , String vehicleType , String maximumWeight , String noOfPassenger ){
        for (int i = 0; i < 14; i++) {
            if ( vehicles[i][0]==null ){
                vehicles[i][0] =vehicleNumber;
                vehicles[i][1] =vehicleType;
                vehicles[i][2] =maximumWeight;
                vehicles[i][3] =noOfPassenger;
                return;
            }
        }
    }

}
