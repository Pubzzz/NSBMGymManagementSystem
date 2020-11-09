package GymSystem.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> extends  SuperDAO {
    public void CrudTest();
    public boolean add(T t)throws ClassNotFoundException, SQLException;
    public boolean update(T t)throws ClassNotFoundException,SQLException;
    public boolean delete(ID t)throws ClassNotFoundException,SQLException;
    public T search1(ID t)throws ClassNotFoundException,SQLException;
    public T search2(ID t)throws ClassNotFoundException,SQLException;
    public ArrayList<T> getAll()throws ClassNotFoundException,SQLException, Exception;
}
