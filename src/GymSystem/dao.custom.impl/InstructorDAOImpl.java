package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.InstructorDAO;
import GymSystem.entity.Instructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDAOImpl implements InstructorDAO {


    @Override
    public boolean add(Instructor ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into INSTRUCTOR values(?,?,?,?,?,?)", ref.getId(),ref.getName(), ref.getNic(), ref.getGender(), ref.getEmail(), ref.getTp());

    }

    @Override
    public boolean update(Instructor ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update INSTRUCTOR set Iname=?,NIC=?,Isex=?,Iemail=?, Itel=? where IID=?",  ref.getName(), ref.getNic(), ref.getGender(), ref.getEmail(), ref.getTp(), ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from INSTRUCTOR where IID=?", id);
    }

    @Override
    public Instructor search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from INSTRUCTOR where IID=?", id);
        if (rst.next()){
            return new Instructor(
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
    public Instructor search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Instructor> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Instructor> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from INSTRUCTOR");
        while (rst.next()){
            company.add(new Instructor(
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
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from Instructor where IID=?",id);

        while(rst.next()) {
            if(rst.getInt(1) == 1) {
                recordExist = true;
                break;
            }
        }
        return recordExist;
    }

}
