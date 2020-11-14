package GymSystem.bo.custom;

import GymSystem.dto.InstructorDTO;
import GymSystem.dto.TrackerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrackerBO {
    public  boolean addTracker(TrackerDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateTracker(TrackerDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteTracker(String id) throws SQLException, ClassNotFoundException ;

    public  TrackerDTO searchTracker(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<TrackerDTO> getAllTracker()throws Exception;
}
