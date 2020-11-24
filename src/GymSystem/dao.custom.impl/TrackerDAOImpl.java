package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.TrackerDAO;
import GymSystem.entity.Tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackerDAOImpl implements TrackerDAO {


    @Override
    public boolean add(Tracker ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into TRACKER values(?,?,?,?,?,?,?,?)", ref.getId(), ref.getMid(), ref.getDate(), ref.getHgt(),ref.getWgt(),ref.getAge(),ref.getBMI(),ref.getCal());
    }

    @Override
    public boolean update(Tracker ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update TRACKER set TDate=?,Height=?, Weight=?,age=?,BMI=?, Cal=? where MID=? AND TID=?",  ref.getDate(), ref.getHgt(), ref.getWgt(),ref.getAge(), ref.getBMI(), ref.getCal(),ref.getMid(), ref.getId());
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
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    rst.getDouble(8)
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
                    rst.getDouble(4),
                    rst.getDouble(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    rst.getDouble(8)

            ));
        }
        return company;
    }

    public static String getGender(String id) throws Exception {
        String gender = null;
        ResultSet rst = CrudUtil.executeQuery("Select Msex from MEMBER where MID=?",id);
        while (rst.next()) {
            gender = rst.getString(1);
        }
        return gender;
    }

}
