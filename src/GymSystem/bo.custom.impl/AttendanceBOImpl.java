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
        return dao.add(new Attendance(ref.getId(), ref.getMid(), ref.getName(), ref.getDate(), ref.getTime(), ref.getPayment()));

    }

    @Override
    public boolean updateAttendance(AttendanceDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Attendance(ref.getId(), ref.getMid(), ref.getName(), ref.getDate(), ref.getTime(), ref.getPayment()));
    }


    @Override
    public boolean removeAttendance(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public AttendanceDTO searchAttendance(String Mid) throws SQLException, ClassNotFoundException {
        Attendance search = dao.search1(Mid);
        return new AttendanceDTO(search.getId(), search.getMid(), search.getName(), search.getDate(), search.getTime(), search.getPayment());
    }

    @Override
    public ArrayList<AttendanceDTO> getAllAttendances() throws Exception {
        ArrayList<AttendanceDTO> dtos = new ArrayList<>();
        ArrayList<Attendance> companies = dao.getAll();
        for (Attendance company : companies) {
            dtos.add(new AttendanceDTO(
                    company.getId(),
                    company.getMid(),
                    company.getName(),
                    company.getDate(),
                    company.getTime(),
                    company.getPayment()
            ));
        }
        return dtos;
    }
}
