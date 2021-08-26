package bo.custom;

import bo.SuperBO;
import dto.DriverDTO;

import java.util.ArrayList;

public interface DriverBO extends SuperBO {
    public static boolean saveDriver(DriverDTO DriverDTO) throws Exception {
        return false;
    }

    public boolean deleteDriver(String nic)throws Exception;
    public boolean updateDriver(DriverDTO DriverDTO)throws Exception;
    public DriverDTO getDriver(String nic)throws Exception;
    public ArrayList<DriverDTO> getAllDrivers()throws Exception;
}
