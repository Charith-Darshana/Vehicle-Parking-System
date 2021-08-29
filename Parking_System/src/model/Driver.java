package model;

public class Driver {
    private String driverName;
    private String address;
    private String contactNo;
    private String nic;
    private String drivingLicenseNo;

    public Driver() {
    }

    public Driver(String driverName, String address, String contactNo, String nic, String drivingLicenseNo) {
        this.driverName = driverName;
        this.address = address;
        this.contactNo = contactNo;
        this.nic = nic;
        this.drivingLicenseNo = drivingLicenseNo;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", nic='" + nic + '\'' +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                '}';
    }
}
