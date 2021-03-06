package GymSystem.bo.custom.impl;

import GymSystem.bo.custom.MemberBO;
import GymSystem.dao.DAOFactory;
import GymSystem.dao.custom.MemberDAO;
import GymSystem.dto.MemberDTO;
import GymSystem.entity.Member;

import java.sql.SQLException;
import java.util.ArrayList;

public class MemberBOImpl implements MemberBO {

    MemberDAO dao = (MemberDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);

    @Override
    public boolean addCustomer(MemberDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Member(ref.getId(), ref.getName(),  ref.getEmail(),ref.getTel(),ref.getSex(),ref.getPos(),ref.getBatch(),ref.getDeg()));
    }

    @Override
    public boolean updateCustomer(MemberDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Member(ref.getId(), ref.getName(),  ref.getEmail(),ref.getTel(),ref.getSex(),ref.getPos(),ref.getBatch(),ref.getDeg()));
    }

    @Override
    public boolean removeCustomer(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public MemberDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Member search = dao.search1(id);
        return new MemberDTO(search.getId(), search.getName(),  search.getEmail(),search.getTel(),search.getSex(),search.getPos(),search.getBatch(),search.getDeg());
    }

    @Override
    public ArrayList<MemberDTO> getAllCustomers() throws Exception {
        ArrayList<MemberDTO> dtos = new ArrayList<>();
        ArrayList<Member> companies = dao.getAll();
        for (Member company : companies) {
            dtos.add(new MemberDTO(
                    company.getId(),
                    company.getName(),
                    company.getEmail(),
                    company.getTel(),
                    company.getSex(),
                    company.getPos(),
                    company.getBatch(),
                    company.getDeg()
            ));
        }
        return dtos;
    }

}
