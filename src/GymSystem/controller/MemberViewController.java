package GymSystem.controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
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
    private TableView table_Memeber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void onaction_search(ActionEvent actionEvent) {
    }

    public void onaction_register(ActionEvent actionEvent) {
    }

    public void onaction_update(ActionEvent actionEvent) {
    }

    public void onaction_remove(ActionEvent actionEvent) {
    }

    public void onaction_clear(ActionEvent actionEvent) {
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
    }
}
