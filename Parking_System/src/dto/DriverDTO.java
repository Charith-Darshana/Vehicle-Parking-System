package dto;

public class DriverDTO {
    private String driverName;
    private String address;
    private String contact;
    private String nic;
    private String drivingLicense;

    public DriverDTO() {
    }

    public DriverDTO(String driverName, String address, String contact, String nic, String drivingLicense) {
        this.driverName = driverName;
        this.address = address;
        this.contact = contact;
        this.nic = nic;
        this.drivingLicense = drivingLicense;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "driverName='" + driverName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", nic='" + nic + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                '}';
    }
}
