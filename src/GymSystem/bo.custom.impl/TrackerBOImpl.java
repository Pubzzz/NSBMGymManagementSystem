package GymSystem.bo.custom.impl;

import GymSystem.bo.custom.TrackerBO;
import GymSystem.dao.DAOFactory;
import GymSystem.dao.custom.TrackerDAO;
import GymSystem.dto.TrackerDTO;
import GymSystem.entity.Tracker;

import java.sql.SQLException;
import java.util.ArrayList;

public class TrackerBOImpl implements TrackerBO {

    TrackerDAO dao = (TrackerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.TRACKER);
    @Override
    public boolean addTracker(TrackerDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Tracker(ref.getId(), ref.getMid(), ref.getDate(), ref.getHgt(),ref.getWgt(),ref.getAge(),ref.getBMI(),ref.getCal()));
    }


    @Override
    public boolean deleteTracker(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public TrackerDTO searchTracker(String id) throws SQLException, ClassNotFoundException {
            Tracker search = dao.search1(id);
        return new TrackerDTO(search.getId(), search.getMid(), search.getDate(), search.getHgt(),search.getWgt(),search.getAge(),search.getBMI(),search.getCal());

    }

    @Override
    public ArrayList<TrackerDTO> getAllTracker() throws Exception {
        ArrayList<TrackerDTO> dtos = new ArrayList<>();
        ArrayList<Tracker> companies = dao.getAll();
        for (Tracker company: companies){
            dtos.add(new TrackerDTO(
                    company.getId(),
                    company.getMid(),
                    company.getDate(),
                    company.getHgt(),
                    company.getWgt(),
                    company.getAge(),
                    company.getBMI(),
                    company.getCal()

            ));
        }
        return dtos;
    }
}

