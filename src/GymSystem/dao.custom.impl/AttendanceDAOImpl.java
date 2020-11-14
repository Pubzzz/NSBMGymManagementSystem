package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.AttendanceDAO;
import GymSystem.entity.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO{

    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Attendance ref) throws ClassNotFoundException, SQLException {

        return CrudUtil.executeUpdate("Insert into ATTENDANCE values(?,?,?,?,?)", ref.getMid(), ref.getName(), ref.getAid(), ref.getTime(), ref.getPayment());
    }

    @Override
    public boolean update(Attendance ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update ATTENDANCE set Mname=?,Memail=?,Mtel=?,Msex=?,Mpos=?,Mbatch=?,Mdegree=? where MID=?",  ref.getName(), ref.getEmail(), ref.getTel(), ref.getSex(), ref.getPos(), ref.getBatch(), ref.getDeg(), ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from ATTENDANCE where MID=?", id);
    }

    @Override
    public Attendance search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from ATTENDANCE where MID=?", id);
        if (rst.next()){
            return new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
        }
        return null;
    }

    @Override
    public Attendance search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }


    @Override
    public ArrayList<Attendance> getAll() throws Exception {
        ArrayList<Attendance> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from ATTENDANCE");
        while (rst.next()){
            company.add(new Attendance(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            ));
        }
        return company;
    }

}
