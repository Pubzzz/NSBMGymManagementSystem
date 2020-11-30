package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.AccessoriesBO;
import GymSystem.dao.custom.impl.AccessoriesDAOImpl;
import GymSystem.dto.AccessoriesDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AccessoriesViewController implements Initializable {

    @FXML
    private JFXButton btn_Add;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_Remove;

    @FXML
    private JFXButton btn_Clear;

    @FXML
    private JFXTextField txt_AccessoryId;

    @FXML
    private JFXTextField txt_AccessoryType;

    @FXML
    private JFXTextField txt_AccessoryBrand;

    @FXML
    private JFXTextField txt_AccessoryQty;

    @FXML
    private JFXTextField txt_AccessorySearch;

    @FXML
    private TableView<AccessoriesDTO> table_Accessories;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllAccessories();
            GenerateID();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static AccessoriesBO bo = (AccessoriesBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ACCESSORIES);

    public static boolean addAccessories(AccessoriesDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addAccessory(ref);
    }

    public static boolean updateAccessories(AccessoriesDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateAccessory(ref);
    }

    public static boolean deleteAccessories(String id) throws SQLException, ClassNotFoundException {
        return bo.removeAccessory(id);
    }


    public static AccessoriesDTO searchAccessories(String id) throws SQLException, ClassNotFoundException {
        return bo.searchAccessory(id);

    }

    public void onactione_register(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txt_AccessoryId.getText();
        String type = txt_AccessoryType.getText();
        String brand = txt_AccessoryBrand.getText();
        String qty = txt_AccessoryQty.getText();

        AccessoriesDTO cusModel = new AccessoriesDTO(id, type, brand, qty);
        boolean addAccessory = AccessoriesViewController.addAccessories(cusModel);

        if (addAccessory) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            GenerateID();


        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    private void getAllAccessories() {
        ArrayList<AccessoriesDTO> accessoryList;
        try {
            accessoryList = bo.getAllAccessory();
            ObservableList<AccessoriesDTO> Acceessory = FXCollections.observableArrayList(accessoryList);
            table_Accessories.setItems(Acceessory);
            table_Accessories.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Accessories.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
            table_Accessories.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("brand"));
            table_Accessories.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void setAllClear() {
        GenerateID();
        txt_AccessoryType.clear();
        txt_AccessoryBrand.clear();
        txt_AccessoryQty.clear();
    }

    public void onaction_update(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = txt_AccessoryId.getText();
        String type = txt_AccessoryType.getText();
        String brand = txt_AccessoryBrand.getText();
        String qty = txt_AccessoryQty.getText();

        AccessoriesDTO cusModel = new AccessoriesDTO(id, type, brand, qty);
        boolean updateAccessories = AccessoriesViewController.updateAccessories(cusModel);

        if (updateAccessories) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            GenerateID();
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_remove(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String id = txt_AccessoryId.getText();

        boolean removeAccessory = deleteAccessories(id);
        if (removeAccessory) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAccessories();
            GenerateID();
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_clear(ActionEvent actionEvent) {
        setAllClear();
    }

    public void onaction_clicked(MouseEvent mouseEvent) {

        AccessoriesDTO selectedItem = table_Accessories.getSelectionModel().getSelectedItem();

        txt_AccessoryId.setText(selectedItem.getId());
        txt_AccessoryType.setText(selectedItem.getType());
        txt_AccessoryBrand.setText(selectedItem.getBrand());
        txt_AccessoryQty.setText(selectedItem.getQty());
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (ifSearchExists(txt_AccessorySearch.getText())) {
            AccessoriesDTO searchAccessory = bo.searchAccessory(txt_AccessorySearch.getText());

            txt_AccessoryId.setText(searchAccessory.getId());
            txt_AccessoryType.setText(searchAccessory.getType());
            txt_AccessoryBrand.setText(searchAccessory.getBrand());
            txt_AccessoryQty.setText(searchAccessory.getQty());
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "ACCESSORY CANNOT BE FOUND ", ButtonType.OK);
            a.showAndWait();
        }
    }
    private boolean ifSearchExists(String mid) {
        try {
            return AccessoriesDAOImpl.checkIfSearchExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void GenerateID() {
        try {
            txt_AccessoryId.setText(AccessoriesDAOImpl.getMaxID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
