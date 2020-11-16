package GymSystem.bo.custom;

public interface AccessoriesBO {
  public  boolean addAccessory(AccessoriesDTO ref) throws ClassNotFoundException, SQLException;

    public  boolean updateAccessory(AccessoriesDTO ref) throws SQLException, ClassNotFoundException ;

    public  boolean removeAccessory(String id) throws SQLException, ClassNotFoundException ;

    public  MemberDTO searchAccessory(String id) throws SQLException, ClassNotFoundException;

    public ArrayList<MemberDTO> getAllAccessory()throws Exception;

    boolean addAccessory(AccessoriesDTO ref);

    boolean updateAccessory(AccessoriesDTO ref);
}
