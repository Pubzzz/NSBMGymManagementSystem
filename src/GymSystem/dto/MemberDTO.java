package GymSystem.dto;

public class MemberDTO {
    private String id;
    private String name;
    private String email;
    private String tel;
    private String sex;
    private String pos;
    private String batch;
    private String deg;

    public MemberDTO(){

    }
    public MemberDTO(String id,String name,String email,String tel,String sex,String pos,String batch,String deg){
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.sex = sex;
        this.pos = pos;
        this.batch = batch;
        this.deg = deg;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }


}
