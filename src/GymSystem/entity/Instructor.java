package GymSystem.entity;

public class Instructor {

    private String id;
    private String name;
    private String nic;
    private String gender;
    private String email;
    private String tp;

    public Instructor(){

    }
    public Instructor(String id, String name, String nic, String gender, String email, String tp) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.gender = gender;
        this.email = email;
        this.tp = tp;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String address) {
        this.gender = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }
}
