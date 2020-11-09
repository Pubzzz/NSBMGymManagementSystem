package GymSystem.bo.custom;

import GymSystem.dto.MemberDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberBO {
    public  boolean addCustomer(MemberDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateCustomer(MemberDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

    public  MemberDTO searchCustomer(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<MemberDTO> getAllCustomers()throws Exception;
}
