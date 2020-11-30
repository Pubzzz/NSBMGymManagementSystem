package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.MemberBO;
import GymSystem.dao.custom.impl.MemberDAOImpl;
import GymSystem.dao.custom.impl.TrackerDAOImpl;
import GymSystem.dto.MemberDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
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

public class MemberViewController implements Initializable {

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_Remove;

    @FXML
    private JFXButton btn_Clear;

    @FXML
    private JFXTextField txt_MemId;

    @FXML
    private JFXTextField txt_MemName;

    @FXML
    private JFXTextField txt_MemEmail;

    @FXML
    private JFXTextField txt_MemTelNo;

    @FXML
    private JFXTextField txt_Batch;

    @FXML
    private JFXTextField txt_Degree;

    @FXML
    private JFXTextField txt_MemSearch;

    @FXML
    private JFXRadioButton radio_male;

    @FXML
    private JFXRadioButton radio_female;

    @FXML
    private JFXRadioButton radio_student;

    @FXML
    private JFXRadioButton radio_staff;

    @FXML
    private TableView<MemberDTO> table_Member;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static MemberBO bo = (MemberBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.MEMBER);

    public static boolean addCustomer(MemberDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addCustomer(ref);
    }

    public static boolean updateCustomer(MemberDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateCustomer(ref);
    }

    public static boolean removeCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.removeCustomer(id);
    }

    public static MemberDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return bo.searchCustomer(id);
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (ifSearchExists(txt_MemSearch.getText())) {
            MemberDTO searchCustomer = bo.searchCustomer(txt_MemSearch.getText());
            txt_MemId.setText(searchCustomer.getId());
            txt_MemName.setText(searchCustomer.getName());
            txt_MemEmail.setText(searchCustomer.getEmail());
            txt_MemTelNo.setText(searchCustomer.getTel());
            if (searchCustomer.getSex().contentEquals("Female")) {
                radio_male.setSelected(false);
                radio_female.setSelected(true);
            } else {
                radio_male.setSelected(true);
                radio_female.setSelected(false);
            }
            if (searchCustomer.getPos().contentEquals("Student")) {
                radio_student.setSelected(true);
                radio_staff.setSelected(false);
            } else {
                radio_staff.setSelected(true);
                radio_student.setSelected(false);
            }
            txt_Batch.setText(searchCustomer.getBatch());
            txt_Degree.setText(searchCustomer.getDeg());
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "MEMBER CANNOT BE FOUND ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_register(ActionEvent actionEvent) throws Exception {

        String id = txt_MemId.getText();
        if (!(ifMemberExists(id))) {
        String name = txt_MemName.getText();
        String email = txt_MemEmail.getText();
        String tel = txt_MemTelNo.getText();
        String sex;
        String position;
        if (radio_male.isSelected()) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        if (radio_student.isSelected()) {
            position = "Student";
        } else {
            position = "Staff";
        }
        String batch = txt_Batch.getText();
        String degree = txt_Degree.getText();

        MemberDTO cusModel = new MemberDTO(id, name, email, tel, sex, position, batch, degree);
        boolean addCustomer = MemberViewController.addCustomer(cusModel);

            if (addCustomer) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
                a.showAndWait();
                setAllClear();
                getAllCustomers();
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
                a.showAndWait();
            }
        }
            else{
                Alert a = new Alert(Alert.AlertType.ERROR, "MEMBER ALREADY EXISTS ", ButtonType.OK);
                a.showAndWait();
            }
        }



    public void onaction_update(ActionEvent actionEvent) throws Exception {

        String id = txt_MemId.getText();

        String name = txt_MemName.getText();
        String email = txt_MemEmail.getText();
        String tel = txt_MemTelNo.getText();
        String sex;
        if (radio_male.isSelected()) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        String position;
        if (radio_student.isSelected()) {
            position = "Student";
        } else {
            position = "Staff";
        }
        String batch = txt_Batch.getText();
        String degree = txt_Degree.getText();

        MemberDTO cusModel = new MemberDTO(id, name, email, tel, sex, position, batch, degree);
        boolean updateCustomer = MemberViewController.updateCustomer(cusModel);
            if (updateCustomer) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
                a.showAndWait();
                setAllClear();
                getAllCustomers();
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
                a.showAndWait();
            }
    }

    public void onaction_remove(ActionEvent actionEvent) throws Exception {
        String id = txt_MemId.getText();

        boolean removeCustomer = removeCustomer(id);
        if (removeCustomer) {
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_clear(ActionEvent actionEvent) {
        setAllClear();
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
        MemberDTO selectedItem = table_Member.getSelectionModel().getSelectedItem();

        txt_MemId.setText(selectedItem.getId());
        txt_MemName.setText(selectedItem.getName());
        txt_MemEmail.setText(selectedItem.getEmail());
        txt_MemTelNo.setText(selectedItem.getTel());
        if (selectedItem.getSex().contentEquals("Female")) {
            radio_male.setSelected(false);
            radio_female.setSelected(true);
        } else {
            radio_male.setSelected(true);
            radio_female.setSelected(false);
        }
        if (selectedItem.getPos().contentEquals("Student")) {
            radio_student.setSelected(true);
            radio_staff.setSelected(false);
        } else {
            radio_staff.setSelected(true);
            radio_student.setSelected(false);
        }
        txt_Batch.setText(selectedItem.getBatch());
        txt_Degree.setText(selectedItem.getDeg());
    }

    private void setAllClear() {
        txt_MemId.clear();
        txt_MemName.clear();
        txt_MemEmail.clear();
        txt_MemTelNo.clear();
        txt_Batch.clear();
        txt_Degree.clear();
        radio_male.setSelected(false);
        radio_female.setSelected(false);
        radio_staff.setSelected(false);
        radio_student.setSelected(false);
        txt_MemSearch.clear();
    }

    private void getAllCustomers() throws Exception {
        ArrayList<MemberDTO> MemberList;
        try {
            MemberList = bo.getAllCustomers();
            ObservableList<MemberDTO> Member = FXCollections.observableArrayList(MemberList);
            table_Member.setItems(Member);
            table_Member.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Member.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Member.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Member.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tel"));
            table_Member.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("sex"));
            table_Member.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("pos"));
            table_Member.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("batch"));
            table_Member.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("deg"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean ifMemberExists(String mid) {
        try {
            return TrackerDAOImpl.checkIfMemberExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean ifSearchExists(String mid) {
        try {
            return MemberDAOImpl.checkIfSearchExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}

