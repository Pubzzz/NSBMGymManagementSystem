package GymSystem.bo.custom;

import GymSystem.bo.SuperBO;
import GymSystem.dto.AccessoriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccessoriesBO extends SuperBO {
    public  boolean addAccessory(AccessoriesDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateAccessory(AccessoriesDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean removeAccessory(String id) throws SQLException, ClassNotFoundException ;

    public AccessoriesDTO searchAccessory(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<AccessoriesDTO> getAllAccessory()throws Exception;

}
