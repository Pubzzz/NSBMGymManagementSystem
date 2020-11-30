package GymSystem.dao.custom.impl;

import GymSystem.dao.CrudUtil;
import GymSystem.dao.custom.MemberDAO;
import GymSystem.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {


    @Override
    public boolean add(Member ref) throws ClassNotFoundException, SQLException {

        return CrudUtil.executeUpdate("Insert into MEMBER values(?,?,?,?,?,?,?,?)", ref.getId(), ref.getName(), ref.getEmail(), ref.getTel(), ref.getSex(), ref.getPos(), ref.getBatch(), ref.getDeg());
    }

    @Override
    public boolean update(Member ref) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("update MEMBER set Mname=?,Memail=?,Mtel=?,Msex=?,Mpos=?,Mbatch=?,Mdegree=? where MID=?", ref.getName(), ref.getEmail(), ref.getTel(), ref.getSex(), ref.getPos(), ref.getBatch(), ref.getDeg(), ref.getId());
    }

    @Override
    public boolean delete(String id) throws ClassNotFoundException, SQLException {
        return CrudUtil.executeUpdate("delete from MEMBER where MID=?", id);
    }

    @Override
    public Member search1(String id) throws ClassNotFoundException, SQLException {
        ResultSet rst = CrudUtil.executeQuery("select * from MEMBER where MID=?", id);
        if (rst.next()) {
            return new Member(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
        }
        return null;
    }

    @Override
    public Member search2(String t) throws ClassNotFoundException, SQLException {
        return null;
    }


    @Override
    public ArrayList<Member> getAll() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Member> company = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("Select * from Member");
        while (rst.next()) {
            company.add(new Member(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)

            ));
        }
        return company;
    }

    public static String getidcountstaff() throws Exception {
        int count = 0;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from MEMBER where Mpos='Staff'");
        while (rst.next()) {
            count = rst.getInt(1);
        }
        String idcnt = Integer.toString(count);

        return idcnt;
    }

    public static String getidcountStudent() throws Exception {
        int count = 0;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from MEMBER where Mpos='Student' ");
        while (rst.next()) {
            count = rst.getInt(1);
        }
        String idcntM = Integer.toString(count);

        return idcntM;
    }

    public static boolean checkIfMemberExist(String id) throws Exception {
        boolean recordExist = false;
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from MEMBER where MID=?",id);

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
        ResultSet rst = CrudUtil.executeQuery("Select COUNT(*) from MEMBER where MID=?",id);

        while(rst.next()) {
            if(rst.getInt(1) == 1) {
                recordExist = true;
                break;
            }
        }
        return recordExist;
    }

}
