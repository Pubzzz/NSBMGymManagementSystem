package GymSystem.dto;

public class AttendanceDTO {

    private String id;
    private String mid;
    private String name;
    private String date;
    private String time;
    private String payment;


    public AttendanceDTO(){

    }
    public AttendanceDTO(String id,String mid,String name,String date,String time, String payment){
        this.id = id;
        this.mid = mid;
        this.name = name;
        this.date = date;
        this.time = time;
        this.payment = payment;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
