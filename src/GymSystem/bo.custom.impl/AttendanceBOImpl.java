package GymSystem.bo.custom.impl;

import GymSystem.bo.custom.AttendanceBO;
import GymSystem.dao.DAOFactory;
import GymSystem.dao.custom.AttendanceDAO;
import GymSystem.dto.AttendanceDTO;
import GymSystem.entity.Attendance;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBOImpl implements AttendanceBO {

    AttendanceDAO dao = (AttendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);

    @Override
    public boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Attendance(ref.getMid(), ref.getName(), ref.getAid(),ref.getTime(),ref.getPayment()));

    }

    @Override
    public boolean updateCustomer(AttendanceDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Attendance(ref.getMid(), ref.getName(),  ref.getAid(),ref.getTime(),ref.getPayment()));
    }

    @Override
    public boolean removeAttendance(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public AttendanceDTO searchAttendance(String Mid) throws SQLException, ClassNotFoundException {
        Attendance search = dao.search1(Mid);
        return new AttendanceDTO(search.getMId(), search.getName(),  search.getAid(),search.getTime(),search.getPayment());
    }

    @Override
    public ArrayList<AttendanceDTO> getAllAttendances() throws Exception {
        ArrayList<AttendanceDTO> dtos = new ArrayList<>();
        ArrayList<Attendance> companies = dao.getAll();
        for (Attendance company : companies) {
            dtos.add(new AttendanceDTO(
                    company.getMId(),
                    company.getName(),
                    company.getAid(),
                    company.getTime(),
                    company.getPayment(),
            ));
        }
        return dtos;
    }
}
