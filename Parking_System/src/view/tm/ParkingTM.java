package view.tm;

public class ParkingTM {
    private String vehicleNumber;
    private String vehicleType;
    private String parkingSlot;
    private String date;

    public ParkingTM() {
    }

    public ParkingTM(String vehicleNumber, String vehicleType, String parkingSlot, String date) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.date = date;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(String parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ParkingTM{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", parkingSlot='" + parkingSlot + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
