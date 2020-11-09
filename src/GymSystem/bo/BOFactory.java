package GymSystem.bo;

import GymSystem.bo.custom.MemberBO;
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

    public enum BOTyepes {
        MEMBER, ATTENDANCE, ACCESSORIES ,INSTRUCTOR;
    }

    public SuperBO getBO(BOTyepes types) {
        switch (types) {

            case MEMBER:
                return new MemberBOImpl();


            default:
                return null;
        }
    }
}
