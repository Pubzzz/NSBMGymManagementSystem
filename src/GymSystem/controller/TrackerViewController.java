package GymSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class TrackerViewController {

    @FXML
    private JFXButton btn_Calculate;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_Remove;

    @FXML
    private JFXButton btn_Clear;

    @FXML
    private TableView table_tracker;

    @FXML
    private JFXTextField txt_TrackerID;

    @FXML
    private JFXTextField txt_MemberID;

    @FXML
    private JFXTextField txt_TrackerDate;

    @FXML
    private JFXTextField txt_Height;

    @FXML
    private JFXTextField txt_Weight;

    @FXML
    private JFXTextField txt_BMI;

    @FXML
    private JFXTextField txt_Calories;

    @FXML
    private JFXTextField txt_TrackerSearch;

    @FXML
    private JFXRadioButton radio_type1;

    @FXML
    private JFXRadioButton radio_type2;

    @FXML
    private JFXRadioButton radio_type3;

    public void onaction_calculate(ActionEvent actionEvent) {
    }

    public void onaction_update(ActionEvent actionEvent) {
    }

    public void onaction_remove(ActionEvent actionEvent) {
    }

    public void onaction_clear(ActionEvent actionEvent) {
    }

    public void onaction_Clicked(MouseEvent mouseEvent) {
    }

    public void onaction_search(ActionEvent actionEvent) {
    }
}
