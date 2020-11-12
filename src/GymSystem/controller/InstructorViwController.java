package GymSystem.controller;

import GymSystem.dto.MemberDTO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class InstructorViwController {

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_Remove;

    @FXML
    private JFXButton btn_Clear;

    @FXML
    private JFXTextField txt_InstructorId;

    @FXML
    private JFXTextField txt_InstructorName;

    @FXML
    private JFXTextField txt_InstructorNIC;

    @FXML
    private JFXTextField txt_InstructorEmail;

    @FXML
    private JFXTextField txt_InstructorTelNo;

    @FXML
    private JFXTextField txt_InstructorSearch;

    @FXML
    private JFXRadioButton radio_Male;

    @FXML
    private JFXRadioButton radio_Female;

    @FXML
    private TableView table_Instructor;



    public void onaction_register(ActionEvent actionEvent) {
    }

    public void onaction_update(ActionEvent actionEvent) {
    }

    public void onaction_remove(ActionEvent actionEvent) {
    }

    public void onaction_clear(ActionEvent actionEvent) {
    }

    public void onaction_search(ActionEvent actionEvent) {
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
    }
}
