package GymSystem.controller;
import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.MemberBO;
import GymSystem.dto.MemberDTO;
import GymSystem.entity.Member;
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
        MemberDTO searchCustomer = bo.searchCustomer(txt_MemSearch.getText());
        txt_MemId.setText(searchCustomer.getId());
        txt_MemName.setText(searchCustomer.getName());
        txt_MemEmail.setText(searchCustomer.getEmail());
        txt_MemTelNo.setText(searchCustomer.getTel());
        // how to update on sex and position
        txt_Batch.setText(searchCustomer.getBatch());
        txt_Degree.setText(searchCustomer.getDeg());
    }

    public void onaction_register(ActionEvent actionEvent) throws Exception {
        String id = txt_MemId.getText();
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

    public void onaction_update(ActionEvent actionEvent) throws Exception {
        String id = txt_MemId.getText();
        String name = txt_MemName.getText();
        String email = txt_MemEmail.getText();
        String tel = txt_MemTelNo.getText();
        String batch = txt_Batch.getText();
        String degree = txt_Degree.getText();
        String sex,position;
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

        MemberDTO cusModel = new MemberDTO(id, name, email, tel, sex, position, batch, degree);
        boolean updateCustomer = MemberViewController.updateCustomer(cusModel);


        if(updateCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_remove(ActionEvent actionEvent) throws Exception {
        String id = txt_MemId.getText();

        boolean removeCustomer = removeCustomer(id);
        if(removeCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllCustomers();
        }else{
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
        // how to update on sex and position
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
        ArrayList<MemberDTO> customerList;
        try {
            customerList = bo.getAllCustomers();
            ObservableList<MemberDTO> Member = FXCollections.observableArrayList(customerList);
            table_Member.setItems(Member);
            table_Member.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Member.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Member.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Member.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tel"));

            /*table_Member.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
            table_Member.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("position"));*/
            table_Member.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("batch"));
            table_Member.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("degree"));

            table_Member.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
            table_Member.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
            table_Member.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("position"));
            table_Member.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("batch"));
            table_Member.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("degree"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

