package GymSystem.bo;

import GymSystem.bo.custom.impl.AccessorieBOImpl;
import GymSystem.bo.custom.impl.AttendanceBOImpl;
import GymSystem.bo.custom.impl.InstructorBOImpl;
import GymSystem.bo.custom.impl.MemberBOImpl;

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
        MEMBER, ATTENDANCE, ACCESSORIES ,INSTRUCTOR;
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {

            case MEMBER:
                return new MemberBOImpl();
            case ATTENDANCE:
//                return new AttendanceBOImpl();
            case ACCESSORIES:
//                return new AccessorieBOImpl();
            case INSTRUCTOR:
//                return new InstructorBOImpl();


            default:
                return null;
        }
    }
}
