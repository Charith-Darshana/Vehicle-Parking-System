package bo.custom.impl;

import bo.custom.DriverBO;
import dto.DriverDTO;

import java.util.ArrayList;

public class DriverBOImpl implements DriverBO {

    @Override
    public boolean saveDriver(DriverDTO DriverDTO) throws Exception {
        return programDAO.save(new Program(programDTO.getProgram_code(),programDTO.getProgram_name(),programDTO.getProgram_type(),programDTO.getDuration()));
    }

    @Override
    public boolean deleteDriver(String nic) throws Exception {
        return false;
    }

    @Override
    public boolean updateDriver(DriverDTO DriverDTO) throws Exception {
        return false;
    }

    @Override
    public DriverDTO getDriver(String nic) throws Exception {
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllDrivers() throws Exception {
        return null;
    }
}
