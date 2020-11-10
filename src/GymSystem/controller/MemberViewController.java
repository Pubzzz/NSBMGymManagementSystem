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
    private TableView<MemberDTO> table_Memeber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    static MemberBO bo = (MemberBO) BOFactory.getInstance().getBO(BOFactory.BOTyepes.MEMBER);

    public static boolean addCustomer(MemberDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addCustomer(ref);
    }

    public void onaction_search(ActionEvent actionEvent) {
    }

    public void onaction_register(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
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
            //getAllCustomers();


        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_update(ActionEvent actionEvent) {
    }

    public void onaction_remove(ActionEvent actionEvent) {
    }

    public void onaction_clear(ActionEvent actionEvent) {
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
    }

    private void setAllClear() {
        txt_MemId.clear();
        txt_MemName.clear();
        txt_MemEmail.clear();
        txt_MemTelNo.clear();
        txt_Batch.clear();
        txt_Degree.clear();
        radio_male.getUnSelectedColor();
        radio_female.getUnSelectedColor();
        radio_staff.getUnSelectedColor();
        radio_student.getUnSelectedColor();
    }

    private void getAllCustomers() throws Exception {
        ArrayList<MemberDTO> customerList;
        try {
            customerList = bo.getAllCustomers();
            ObservableList<MemberDTO> Member = FXCollections.observableArrayList(customerList);
            table_Memeber.setItems(Member);
            table_Memeber.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Memeber.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Memeber.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Memeber.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tel"));
            table_Memeber.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
            table_Memeber.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
            table_Memeber.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("position"));
            table_Memeber.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("batch"));
            table_Memeber.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("degree"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

