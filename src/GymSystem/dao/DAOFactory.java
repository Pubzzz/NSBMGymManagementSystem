package GymSystem.dao;

import GymSystem.dao.custom.impl.AccessoriesDAOImpl;
import GymSystem.dao.custom.impl.AttendanceDAOImpl;
import GymSystem.dao.custom.impl.InstructorDAOImpl;
import GymSystem.dao.custom.impl.MemberDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public enum DAOTypes {
        MEMBER,ATTENDANCE,ACCESSORIES,INSTRUCTOR;
    }

    public  SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case MEMBER:
                return new MemberDAOImpl();
            case ATTENDANCE:
               // return new AttendanceDAOImpl();
            case ACCESSORIES:
              //  return new AccessoriesDAOImpl();
            case INSTRUCTOR:
                return new InstructorDAOImpl();




            default:
                return null;
        }
    }
}
