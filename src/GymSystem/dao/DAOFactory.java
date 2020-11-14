package GymSystem.dao;

import GymSystem.dao.custom.impl.*;

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
        MEMBER,ATTENDANCE,ACCESSORIES,INSTRUCTOR,TRACKER;
    }

    public  SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case MEMBER:
                return new MemberDAOImpl();
            case ATTENDANCE:
                return new AttendanceDAOImpl();
            case ACCESSORIES:
              //  return new AccessoriesDAOImpl();
            case INSTRUCTOR:
                return new InstructorDAOImpl();
            case TRACKER:
                return new TrackerDAOImpl();




            default:
                return null;
        }
    }
}
