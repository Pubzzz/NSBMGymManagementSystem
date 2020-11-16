package GymSystem.bo.custom;

import GymSystem.dto.AccessoriesDTO;
import GymSystem.dto.MemberDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AccessoriesBO {
    public  boolean addAccessory(AccessoriesDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateAccessory(AccessoriesDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean removeAccessory(String id) throws SQLException, ClassNotFoundException ;

    public  MemberDTO searchAccessory(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<MemberDTO> getAllAccessory()throws Exception;

    boolean addAccessory(AccessoriesDTO ref);

    boolean updateAccessory(AccessoriesDTO ref);
}
