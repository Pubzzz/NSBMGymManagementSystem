package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.AttendanceBO;
import GymSystem.dao.custom.impl.AttendanceDAOImpl;
import GymSystem.dao.custom.impl.MemberDAOImpl;
import GymSystem.dao.custom.impl.TrackerDAOImpl;
import GymSystem.dto.AttendanceDTO;
import GymSystem.entity.Attendance;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.time.format.DateTimeFormatter;

public class AttendanceViewController implements Initializable {

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
    private TableView<AttendanceDTO> table_Attendance;

    @FXML
    private JFXTextField txt_AttendanceSearch;


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


    public void onaction_add(ActionEvent actionEvent) throws Exception {


        String id = txt_AttendanceId.getText();
        String mid = txt_MemId.getText();
        if (ifMemberExists(mid)) {
        String name = txt_MemName.getText();
        String date = txt_AttendanceDate.getText();
        String time = txt_AttendanceTime.getText();
        String payment;
        if (radio_Payment.isSelected()) {
            payment = "Done";
        }
        else{
            payment="Due";
        }

        AttendanceDTO cusModel = new AttendanceDTO(id, mid, name, date, time, payment);
        boolean addAttendance = AttendanceViewController.addAttendance(cusModel);
            if (addAttendance) {

                Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
                a.showAndWait();
                setAllClear();
                getAllAttendance();
            }
            else {
                Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
                a.showAndWait();
            }
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING, "MEMBER DOES NOT EXIST ", ButtonType.OK);
            a.showAndWait();
        }

    }

    public void onaction_update(ActionEvent actionEvent) throws Exception{
        String id = txt_AttendanceId.getText();
        String mid = txt_MemId.getText();
        String name = txt_MemName.getText();
        String date = txt_AttendanceDate.getText();
        String time = txt_AttendanceTime.getText();
        String payment;
        if (radio_Payment.isSelected()) {
            payment = "Done";
        }
        else{
            payment="Due";
        }

        AttendanceDTO cusModel = new AttendanceDTO(id, mid, name, date, time, payment);
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

        String id = txt_AttendanceId.getText();

        boolean removeAttendance = removeAttendance(id);
        if(removeAttendance){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllAttendance();
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
        txt_MemId.setText(selectedItem.getMid());
        txt_MemName.setText(selectedItem.getName());
        txt_AttendanceDate.setText(selectedItem.getDate());
        txt_AttendanceTime.setText(selectedItem.getTime());
        if(selectedItem.getPayment().contentEquals("Done")){
            radio_Payment.setSelected(true);
        }
        else{
            radio_Payment.setSelected(false);
        }
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (ifSearchExists(txt_AttendanceSearch.getText())) {
            AttendanceDTO searchAttendance = bo.searchAttendance(txt_AttendanceSearch.getText());
            txt_AttendanceId.setText(searchAttendance.getId());
            txt_MemId.setText(searchAttendance.getMid());
            txt_MemName.setText(searchAttendance.getName());
            txt_AttendanceDate.setText(searchAttendance.getDate());
            txt_AttendanceTime.setText(searchAttendance.getTime());
            if (searchAttendance.getPayment().contentEquals("Done")) {
                radio_Payment.setSelected(true);
            } else {
                radio_Payment.setSelected(false);
            }
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "ATTENDANCE RECORD CANNOT BE FOUND ", ButtonType.OK);
            a.showAndWait();
        }
    }
    private void setAllClear() {
        txt_MemId.clear();
        txt_MemName.clear();
        txt_AttendanceId.clear();
        radio_Payment.setSelected(false);
        txt_AttendanceSearch.clear();

    }
    private void getAllAttendance() throws Exception {
        ArrayList<AttendanceDTO> attendanceList;
        try {
            attendanceList = bo.getAllAttendances();
            ObservableList<AttendanceDTO> Member = FXCollections.observableArrayList(attendanceList);
            table_Attendance.setItems(Member);
            table_Attendance.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Attendance.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("mid"));
            table_Attendance.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Attendance.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
            table_Attendance.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("time"));
            table_Attendance.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("payment"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void setDate() {
        txt_AttendanceDate.setText(LocalDate.now().toString());

    }


    private void setTime() {
        LocalTime myDateObj = LocalTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        txt_AttendanceTime.setText(formattedDate.toString());
    }
    private boolean ifMemberExists(String mid) {
        try {
            return AttendanceDAOImpl.checkIfMemberExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean ifSearchExists(String mid) {
        try {
            return AttendanceDAOImpl.checkIfSearchExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllAttendance();
            setDate();
            setTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
