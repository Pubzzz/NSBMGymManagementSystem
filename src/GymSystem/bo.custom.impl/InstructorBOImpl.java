package GymSystem.bo.custom.impl;

import GymSystem.bo.custom.InstructorBO;
import GymSystem.dao.DAOFactory;
import GymSystem.dao.custom.InstructorDAO;
import GymSystem.dto.InstructorDTO;
import GymSystem.entity.Instructor;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstructorBOImpl implements InstructorBO{

    InstructorDAO dao = (InstructorDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.INSTRUCTOR);
    @Override
    public boolean addInstructor(InstructorDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Instructor(ref.getId(), ref.getName(), ref.getNic(), ref.getGender(),ref.getEmail(),ref.getTp()));
    }

    @Override
    public boolean updateInstructor(InstructorDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Instructor(ref.getId(), ref.getName(), ref.getNic(), ref.getGender(),ref.getEmail(),ref.getTp()));
    }

    @Override
    public boolean deleteInstructor(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public InstructorDTO searchInstructor(String id) throws SQLException, ClassNotFoundException {
        Instructor search = dao.search1(id);
        return new InstructorDTO(search.getId(), search.getName(), search.getNic(), search.getGender(),search.getEmail(),search.getTp());

    }

    @Override
    public ArrayList<InstructorDTO> getAllInstructor() throws Exception {
        ArrayList<InstructorDTO> dtos = new ArrayList<>();
        ArrayList<Instructor> companies = dao.getAll();
        for (Instructor company: companies){
            dtos.add(new InstructorDTO(
                    company.getId(),
                    company.getName(),
                    company.getNic(),
                    company.getGender(),
                    company.getEmail(),
                    company.getTp()
            ));
        }
        return dtos;
    }
}
