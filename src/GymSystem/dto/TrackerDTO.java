package GymSystem.dto;

public class TrackerDTO {
    private String id ;
    private String mid;
    private String date;
    private Double hgt;
    private Double wgt;
    private Double BMI;
    private Double Cal;

    public TrackerDTO() {
    }

    public TrackerDTO(String id, String mid, String date, Double hgt, Double wgt, Double BMI,Double Cal) {
        this.id = id;
        this.mid = mid;
        this.date = date;
        this.hgt = hgt;
        this.wgt = wgt;
        this.BMI = BMI;
        this.Cal=Cal;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHgt() {
        return hgt;
    }

    public void setHgt(Double hgt) {
        this.hgt = hgt;
    }

    public double getWgt() {
        return wgt;
    }

    public void setWgt(double wgt) { this.wgt = wgt; }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public double getCal() {
        return Cal;
    }

    public void setCal(double Cal) { this.Cal = Cal; }



}
