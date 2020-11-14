package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.TrackerDAO;
import GymSystem.entity.Instructor;
import GymSystem.entity.Tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackerDAOImpl implements TrackerDAO {
    @Override
    public boolean add(Tracker ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into TRACKER values(?,?,?,?,?,?)", ref.getId(), ref.getMid(), ref.getDate(), ref.getHgt(),ref.getWgt(),ref.getBMI(),ref.getCal());
    }

    @Override
    public boolean update(Tracker ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update TRACKER set TID=?,TDate=?,Height=?, Weight=?,BMI=?, Cal=? where MID=?",  ref.getId(), ref.getDate(), ref.getHgt(), ref.getWgt(), ref.getBMI(), ref.getCal(),ref.getId());
    }


    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from TRACKER where TID=?", id);
    }

    @Override
    public Tracker search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from TRACKER where TID=?", id);
        if (rst.next()){
            return new Tracker(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
        }
        return null;
    }

    @Override
    public Tracker search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Tracker> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Tracker> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from TRACKER");
        while (rst.next()){
            company.add(new Tracker(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)

            ));
        }
        return company;
    }
}
