package view.tm;

import model.Driver;

public class DriverTM extends Driver {
    private String driverName;
    private String address;
    private String contactNo;
    private String nic;
    private String drivingLicenseNo;

    public DriverTM(String[] strings) {
    }

    public DriverTM(String driverName, String address, String contactNo, String nic, String drivingLicenseNo) {
        this.driverName = driverName;
        this.address = address;
        this.contactNo = contactNo;
        this.nic = nic;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getContactNo() {
        return contactNo;
    }

    @Override
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String getNic() {
        return nic;
    }

    @Override
    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    @Override
    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    @Override
    public String toString() {
        return "DriverTM{" +
                "driverName='" + driverName + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", nic='" + nic + '\'' +
                ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
                '}';
    }
}
