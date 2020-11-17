package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.TrackerBO;
import GymSystem.dto.TrackerDTO;
import GymSystem.entity.Tracker;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TrackerViewController implements Initializable {

    @FXML
    private JFXButton btn_Calculate;

    @FXML
    private JFXButton btn_Update;

    @FXML
    private JFXButton btn_Remove;

    @FXML
    private JFXButton btn_Clear;

    @FXML
    private TableView <TrackerDTO>table_tracker;

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
    private JFXTextField txt_age;

    @FXML
    private JFXTextField txt_TrackerSearch;

    @FXML
    private JFXRadioButton radio_type1;

    @FXML
    private JFXRadioButton radio_type2;

    @FXML
    private JFXRadioButton radio_type3;

    static TrackerBO bo = (TrackerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.TRACKER);

    public static boolean addTracker(TrackerDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addTracker(ref);
    }

    public static boolean updateTracker(TrackerDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateTracker(ref);
    }

    public static boolean deleteTracker(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteTracker(id);
    }

    public static TrackerDTO searchTracker(String id) throws SQLException, ClassNotFoundException {
        return bo.searchTracker(id);
    }
    public void onaction_calculate(ActionEvent actionEvent) throws Exception {
        String id = txt_TrackerID.getText();
        String mid=txt_MemberID.getText();
        String date=txt_TrackerDate.getText();
        Double hgt=Double.valueOf (txt_Height.getText());
        Double wgt=Double.valueOf(txt_Weight.getText());
        Integer age = Integer.valueOf(txt_age.getText());
        Double BMI;
        Double Cal=Double.valueOf(txt_Calories.getText());
        BMI=(wgt*wgt)/(hgt/100);

        //CALCULATE BMR AND CAL

        TrackerDTO cusModel = new TrackerDTO(id, mid, date, hgt, wgt,age,BMI,Cal);
        boolean addTracker= TrackerViewController.addTracker(cusModel);

        if(addTracker){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllTracker();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_update(ActionEvent actionEvent) throws Exception {
        String id = txt_TrackerID.getText();
        String mid=txt_MemberID.getText();
        String date=txt_TrackerDate.getText();
        Double hgt=Double.valueOf (txt_Height.getText());
        Double wgt=Double.valueOf(txt_Weight.getText());
        Integer age = Integer.valueOf(txt_age.getText());
        Double BMI=Double.valueOf(txt_BMI.getText());
        Double Cal= Double.valueOf(txt_Calories.getText());

        TrackerDTO cusModel = new TrackerDTO(id, mid, date, hgt, wgt,age,BMI,Cal);
        boolean update = TrackerViewController.updateTracker(cusModel);
        if(update){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllTracker();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_remove(ActionEvent actionEvent) throws Exception {
        String id = txt_TrackerDate.getText();

        boolean remove = deleteTracker(id);
        if(remove){
            Alert a = new Alert(Alert.AlertType.CONFIRMATION, "DELETED SUCCESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllTracker();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_clear(ActionEvent actionEvent) {
        setAllClear();
    }

    public void onaction_Clicked(MouseEvent mouseEvent) {
        TrackerDTO selectedItem = table_tracker.getSelectionModel().getSelectedItem();

        txt_TrackerID.setText(selectedItem.getId());
        txt_MemberID.setText(selectedItem.getMid());
        txt_TrackerDate.setText(selectedItem.getDate());
        txt_Height.setText(String.valueOf(selectedItem.getHgt()));
        txt_Weight.setText(String.valueOf(selectedItem.getWgt()));
        txt_age.setText(String.valueOf(selectedItem.getAge()));
        txt_BMI.setText(String.valueOf(selectedItem.getBMI()));
        txt_Calories.setText(String.valueOf(selectedItem.getCal()));
    }

    public void onaction_search(ActionEvent actionEvent) {
    }
    private void setDate() {
        txt_TrackerDate.setText(LocalDate.now().toString());
    }

    private void getAllTracker() throws Exception {
        ArrayList<TrackerDTO> TrackerList;
        try {
            TrackerList = bo.getAllTracker();
            ObservableList<TrackerDTO> Tracker = FXCollections.observableArrayList(TrackerList);
            table_tracker.setItems(Tracker);
            table_tracker.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_tracker.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("mid"));
            table_tracker.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
            table_tracker.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("hgt"));
            table_tracker.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("wgt"));
            table_tracker.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("age"));
            table_tracker.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("BMI"));
            table_tracker.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Cal"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void setAllClear(){
        txt_TrackerID.clear();
        txt_MemberID.clear();
       txt_TrackerDate.clear();
        txt_Height.clear();
        txt_Weight.clear();
        txt_age.clear();
        txt_BMI.clear();
        txt_Calories.clear();
        txt_TrackerSearch.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllTracker();
            setDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}