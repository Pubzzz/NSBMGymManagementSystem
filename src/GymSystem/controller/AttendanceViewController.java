package GymSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

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


    public void onaction_add(ActionEvent actionEvent) {
    }

    public void onaction_update(ActionEvent actionEvent) {
    }

    public void onaction_remove(ActionEvent actionEvent) {
    }

    public void onaction_clear(ActionEvent actionEvent) {
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
    }

    public void onaction_search(ActionEvent actionEvent) {
    }
}
