package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.AttendanceBO;
import GymSystem.bo.custom.MemberBO;
import GymSystem.dto.AttendanceDTO;
import GymSystem.dto.MemberDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AttendanceViewController {

    @FXML
    private JFXButton btn_Add;

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
    private JFXTextField txt_AttendanceId;

    @FXML
    private JFXTextField txt_AttendanceDate;

    @FXML
    private JFXTextField txt_AttendanceTime;

    @FXML
    private JFXRadioButton radio_Payment;

    @FXML
    private TableView table_Attendance;

    @FXML
    private JFXTextField txt_AttendanceSearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    static AttendanceBO bo = (AttendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);

    public static boolean addAttendance(AttendanceDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addAttendance(ref);
    }

    public static boolean updateAttendance(AttendanceDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateAttendance(ref);
    }

    public static boolean removeAttendance(String id) throws SQLException, ClassNotFoundException {
        return bo.removeAttendance(id);
    }

    public static AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException {
        return bo.searchAttendance(id);
    }


    public void onaction_add(ActionEvent actionEvent) {
    }

    public void onaction_update(ActionEvent actionEvent) throws Exception{
        String id = txt_MemId.getText();
        String name = txt_MemName.getText();
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
        String aid = txt_AttendanceId.getText();
        String date = txt_AttendanceDate.getText();
        String time = txt_AttendanceTime.getText();

        AttendanceDTO cusModel = new AttendanceDTO(id, name, sex, position,);
        boolean updateAttendance = AttendanceViewController.updateAttendance(cusModel);


        if(updateAttendance){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAttendance();
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
        AttendanceDTO selectedItem = table_Attendance.getSelectionModel().getSelectedItem();

        txt_AttendanceId.setText(selectedItem.getId());
        txt_MemName.setText(selectedItem.getName());
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        MemberDTO searchAttendance = bo.searchAttendance(txt_AttendanceSearch.getText());
        txt_MemId.setText(searchCustomer.getId());
        txt_MemName.setText(searchCustomer.getName());
        txt_AttendanceId.setText(searchCustomer.getId());
        txt_AttendanceDate.setText(searchCustomer.getId());
        txt_AttendanceTime.setText(searchCustomer.getId());
    }
    private void setAllClear() {
        txt_MemId.clear();
        txt_MemName.clear();

    }
    private void getAllCustomers() throws Exception {
        ArrayList<MemberDTO> customerList;
        try {
            customerList = bo.getAllCustomers();
            ObservableList<MemberDTO> Member = FXCollections.observableArrayList(customerList);
            table_Attendance.setItems(Member);
            table_Attendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Attendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Attendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Attendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("tel"));
            table_Attendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
            table_Attendance.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("position"));
            table_Attendance.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("batch"));
            table_Attendance.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("degree"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
