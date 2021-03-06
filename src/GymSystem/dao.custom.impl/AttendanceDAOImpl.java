package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.AttendanceDAO;
import GymSystem.entity.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceDAOImpl implements AttendanceDAO{


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
    public Attendance search2(String name) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from ATTENDENCE where ATname=?",name);
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
    public static boolean checkIfMemberExist(String id) throws Exception {
        boolean recordExist = false;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from Member where MID=?",id);

        while(rst.next()) {
            if(rst.getInt(1) == 1) {
                recordExist = true;
                break;
            }
        }
        return recordExist;
    }
    public static boolean checkIfSearchExist(String id) throws Exception {
        boolean recordExist = false;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from ATTENDENCE where ATTID=?",id);

        while(rst.next()) {
            if(rst.getInt(1) == 1) {
                recordExist = true;
                break;
            }
        }
        return recordExist;
    }
    public static String getidcount() throws Exception {
        int count = 0;
        String date =LocalDate.now().toString();
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from ATTENDENCE where ATDATE=?",date);
        while (rst.next()) {
            count = rst.getInt(1);
        }
        String idcntM = Integer.toString(count);

        return idcntM;
    }
    public static String getMaxID() throws Exception {
        int count = 0;
        ResultSet rst = CrudUtil.executeQuery("Select MAX(ATTID) from ATTENDENCE ");
        while (rst.next()) {
            count = rst.getInt(1);
            count+=1;
        }
        String idcntM = Integer.toString(count);
        return idcntM;
    }

}
