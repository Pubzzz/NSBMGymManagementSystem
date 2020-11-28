package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.TrackerBO;
<<<<<<< HEAD
=======
import GymSystem.dao.custom.impl.AttendanceDAOImpl;
import GymSystem.dao.custom.impl.MemberDAOImpl;
>>>>>>> ecf3c313fca613c1850538a2af372602082157be
import GymSystem.dao.custom.impl.TrackerDAOImpl;
import GymSystem.dto.MemberDTO;
import GymSystem.dto.TrackerDTO;
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

import java.io.Serializable;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TrackerViewController extends MemberDTO implements Initializable, Serializable {

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
    private JFXRadioButton radio_Type1;

    @FXML
    private JFXRadioButton radio_Type2;

    @FXML
    private JFXRadioButton radio_Type3;

    static TrackerBO bo = (TrackerBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.TRACKER);

    public static boolean addTracker(TrackerDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addTracker(ref);
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
        Double BMR;
        Double BMI;
        Double Cal;

        if (ifMemberExists(mid)) {
            BMI = Math.round((wgt) / ((hgt / 100) * (hgt / 100)) * 100.00) / 100.00;
            txt_BMI.setText(String.valueOf(BMI).format("%.3f", BMI));


            if (getGender(mid).contentEquals("Female")) {
                BMR = (447.593) + (9.247 * wgt) + (3.098 * hgt) - (4.330 * age);
            } else {
                BMR = (88.362) + (13.397 * wgt) + (4.799 * hgt) - (5.677 * age);
            }

            if (radio_Type1.isSelected()) {

                Cal = Math.round((BMR) * 1.2* 100.00) / 100.00;
            } else if (radio_Type2.isSelected()) {

                Cal = Math.round((BMR) * 1.375* 100.00) / 100.00;
            } else {

                Cal = Math.round((BMR) * 1.55* 100.00) / 100.00;
            }
            txt_Calories.setText(String.valueOf(Cal).format("%.3f", Cal));

            TrackerDTO cusModel = new TrackerDTO(id, mid, date, hgt, wgt, age, BMI, Cal);
            boolean addTracker = TrackerViewController.addTracker(cusModel);

            if (addTracker) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY ", ButtonType.OK);
                a.showAndWait();
                setAllClear();
                getAllTracker();
                setAllClear();

            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
                a.showAndWait();
            }
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "MEMBER DOES NOT EXIST", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_remove(ActionEvent actionEvent) throws Exception {
        String id = txt_TrackerID.getText();

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
        radio_Type2.setSelected(false);
        radio_Type1.setSelected(false);
        radio_Type3.setSelected(false);
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (ifSearchExists(txt_TrackerSearch.getText())) {
            TrackerDTO searchTracker = bo.searchTracker(txt_TrackerSearch.getText());
            txt_TrackerID.setText(searchTracker.getId());
            txt_MemberID.setText(searchTracker.getMid());
            txt_TrackerDate.setText(searchTracker.getDate());
            txt_Height.setText(String.valueOf(searchTracker.getHgt()));
            txt_Weight.setText(String.valueOf(searchTracker.getWgt()));
            txt_age.setText(String.valueOf(searchTracker.getAge()));
            txt_BMI.setText(String.valueOf(searchTracker.getBMI()));
            txt_Calories.setText(String.valueOf(searchTracker.getCal()));
            radio_Type2.setSelected(false);
            radio_Type1.setSelected(false);
            radio_Type3.setSelected(false);

        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR, "TRACKER RECORD CANNOT BE FOUND ", ButtonType.OK);
            a.showAndWait();
        }
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
        txt_Height.clear();
        txt_Weight.clear();
        txt_age.clear();
        txt_BMI.clear();
        txt_Calories.clear();
        txt_TrackerSearch.clear();
        radio_Type2.setSelected(false);
        radio_Type1.setSelected(false);
        radio_Type3.setSelected(false);
    }
    private String getGender(String mid)
    {
        String ans = null;
        try {
            ans=TrackerDAOImpl.getGender(mid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
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
            return TrackerDAOImpl.checkIfSearchExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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