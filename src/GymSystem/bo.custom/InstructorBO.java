package GymSystem.bo.custom;

import GymSystem.dto.InstructorDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InstructorBO {
    public  boolean addInstructor(InstructorDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateInstructor(InstructorDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteInstructor(String id) throws SQLException, ClassNotFoundException ;

    public  InstructorDTO searchInstructor(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<InstructorDTO> getAllInstructor()throws Exception;
}
