package dto;

public class VehicleDTO {
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private String noOfPassenger;

    public VehicleDTO() {
    }

    public VehicleDTO(String vehicleNumber, String vehicleType, String maximumWeight, String noOfPassenger) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.noOfPassenger = noOfPassenger;
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

    public String getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(String maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public String getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(String noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", maximumWeight='" + maximumWeight + '\'' +
                ", noOfPassenger='" + noOfPassenger + '\'' +
                '}';
    }
}
