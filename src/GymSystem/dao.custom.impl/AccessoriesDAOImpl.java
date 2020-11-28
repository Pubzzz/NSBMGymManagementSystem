package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.AccessoriesDAO;
import GymSystem.entity.Accessories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccessoriesDAOImpl implements AccessoriesDAO {
    @Override
    public boolean add(Accessories ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("Insert into ACCESSORY values(?,?,?,?)", ref.getId(), ref.getType(), ref.getBrand(), ref.getQty());
    }

    @Override
    public boolean update(Accessories ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update ACCESSORY set Atype=?,Abrand=?,AQuan=? where AID=?",  ref.getType(), ref.getBrand(), ref.getQty(), ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from ACCESSORY where AID=?", id);
    }

    @Override
    public Accessories search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from ACCESSORY where AID=?", id);
        if (rst.next()){
            return new Accessories(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            );
        }
        return null;
    }

    @Override
    public Accessories search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<Accessories> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Accessories> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from ACCESSORY");
        while (rst.next()){
            company.add(new Accessories(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)

            ));
        }
        return company;
    }
    public static boolean checkIfSearchExist(String id) throws Exception {
        boolean recordExist = false;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from Accessory where AID=?",id);

        while(rst.next()) {
            if(rst.getInt(1) == 1) {
                recordExist = true;
                break;
            }
        }
        return recordExist;
    }


}

