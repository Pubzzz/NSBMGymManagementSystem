package GymSystem.bo.custom;

import GymSystem.bo.SuperBO;
import GymSystem.dto.TrackerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface TrackerBO extends SuperBO {
    public  boolean addTracker(TrackerDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateTracker(TrackerDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean deleteTracker(String id) throws SQLException, ClassNotFoundException ;

    public  TrackerDTO searchTracker(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<TrackerDTO> getAllTracker()throws Exception;
}
