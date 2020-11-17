package GymSystem.dto;

public class AccessoriesDTO {
    private String id ;
    private String type  ;
    private String brand ;
    private String qty ;

    public AccessoriesDTO(){

    }
    public AccessoriesDTO(String id,String type,String brand,String qty){
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
