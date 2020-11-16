package GymSystem.entity;

public class Accessories {
    private String id;
    private String type;
    private String brand;
    private String qty;


    public Accessories(){

    }
    public Member(String id,String name,String email,String tel,String sex,String pos,String batch,String deg){
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.qty = qty;

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }



}
