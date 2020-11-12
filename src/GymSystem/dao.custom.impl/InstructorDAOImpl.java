package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.InstructorDAO;
import GymSystem.entity.Instructor;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorDAOImpl implements InstructorDAO {
    @Override
    public void CrudTest() {

    }

    @Override
    public boolean add(Instructor instructor) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into Instructor values(?,?,?,?,?,?)");

    }

    @Override
    public boolean update(Instructor instructor) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String t) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Instructor search1(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public Instructor search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Instructor> getAll() throws ClassNotFoundException, SQLException, Exception {
        return null;
    }
}
