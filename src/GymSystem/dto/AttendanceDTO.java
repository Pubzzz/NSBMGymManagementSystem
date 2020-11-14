package GymSystem.dto;

public class AttendanceDTO {

    private String mid;
    private String aid;
    private String name;
    private String time;
    private String payment;


    public AttendanceDTO(){

    }
    public AttendanceDTO(String mid,String name,String aid,String time,String payment){
        this.mid = mid;
        this.name = name;
        this.aid = aid;
        this.time = time;
        this.payment = payment;
    }
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) { this.aid = aid; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) { this.time = time; }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }


}
