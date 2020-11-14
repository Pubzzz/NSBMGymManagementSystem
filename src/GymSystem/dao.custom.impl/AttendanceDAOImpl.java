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

        return CrudUtil.executeUpdate("Insert into ATTENDENCE values(?,?,?,?,?,?)", ref.getId(), ref.getMid(), ref.getName(), ref.getDate(), ref.getTime(),ref.getPayment());
    }

    @Override
    public boolean update(Attendance ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update ATTENDENCE set MID=?,ATname=?,ATdate=?,ATtime=?,Apay=? where ATTID=?",  ref.getMid(), ref.getName(),ref.getDate(), ref.getTime(), ref.getPayment(), ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from ATTENDENCE where ATTID=?", id);
    }

    @Override
    public Attendance search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from ATTENDENCE where ATTID=?", id);
        if (rst.next()){
            return new Attendance(
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
    public Attendance search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }


    @Override
    public ArrayList<Attendance> getAll() throws Exception {
        ArrayList<Attendance> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from ATTENDENCE");
        while (rst.next()){
            company.add(new Attendance(
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
