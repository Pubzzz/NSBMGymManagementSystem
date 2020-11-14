package GymSystem.bo;

import GymSystem.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }

        return boFactory;

    }

    public enum BOTypes {
        MEMBER, ATTENDANCE, ACCESSORIES ,INSTRUCTOR,TRACKER;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {

            case MEMBER:
                return new MemberBOImpl();
            case ATTENDANCE:
                return new AttendanceBOImpl();
            case ACCESSORIES:
//                return new AccessorieBOImpl();
            case INSTRUCTOR:
                return new InstructorBOImpl();
            case TRACKER:
               return (SuperBO) new TrackerBOImpl();


            default:
                return null;
        }
    }
}
