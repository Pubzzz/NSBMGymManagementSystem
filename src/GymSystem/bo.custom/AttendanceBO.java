package GymSystem.bo.custom;

import GymSystem.bo.SuperBO;
import GymSystem.dto.AttendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBO extends SuperBO {
    public  boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateAttendance(AttendanceDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean removeAttendance(String id) throws SQLException, ClassNotFoundException ;

    public  AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<AttendanceDTO> getAllAttendances()throws Exception;
}
