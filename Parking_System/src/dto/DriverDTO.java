package dto;

public class DriverDTO {
    private String name;
    private String address;
    private String contact;
    private String nic;
    private String license;

    public DriverDTO() {
    }

    public DriverDTO(String name, String address, String contact, String nic, String license) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.nic = nic;
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", nic='" + nic + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}