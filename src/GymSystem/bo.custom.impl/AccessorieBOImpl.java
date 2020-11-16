package GymSystem.bo.custom.impl;

import GymSystem.dao.DAOFactory;
import GymSystem.dao.custom.AccessoriesDAO;
import GymSystem.dto.AccessoriesDTO;
import GymSystem.entity.Accessories;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessorieBOImpl {


    AccessoriesDAO dao = (AccessoriesDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ACCESSORIES);

    @Override
    public boolean addAccessory(AccessoriesDTO ref) throws ClassNotFoundException, SQLException {
        return dao.add(new Accessories(ref.getId(), ref.getType(),  ref.getBrand(),ref.getQty()));

    }

    @Override
    public boolean updateAccessory(AccessoriesDTO ref) throws SQLException, ClassNotFoundException {
        return dao.update(new Accessories(ref.getId(), ref.getType(),  ref.getBrand(),ref.getQty()));
    }

    @Override
    public boolean removeAccessory(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    @Override
    public AccessoriesDTO searchAccessory(String id) throws SQLException, ClassNotFoundException {
        Accessories search = dao.search1(id);
        return new AccessoriesDTO(search.getId(), search.getType(),  search.getBrand(),search.getQty());
    }

    @Override
    public ArrayList<AccessoriesDTO> getAllAccessory() throws Exception {
        ArrayList<AccessoriesDTO> dtos = new ArrayList<>();
        ArrayList<Accessories> companies = dao.getAll();
        for (Accessories company : companies) {
            dtos.add(new AccessoriesDTO(
                    company.getId(),
                    company.getType(),
                    company.getBrand(),
                    company.getQty(),

            ));
        }
        return dtos;
    }

}
