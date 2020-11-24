package GymSystem.controller;

import GymSystem.dao.custom.impl.InstructorDAOImpl;
import GymSystem.dao.custom.impl.MemberDAOImpl;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardViewController implements Initializable {



    @FXML
    private JFXButton btn_ViewMember;

    @FXML
    private JFXButton btn_Viewattendance;

    @FXML
    private JFXButton btn_Viewinstructor;

    @FXML
    private Label lbl_MemStaff;

    @FXML
    private Label lbl_MemStudent;


    public void onaction_ViewMember(ActionEvent actionEvent)  {


    }

    public void onaction_Viewattendance(ActionEvent actionEvent) {

    }

    public void onaction_Viewinstructor(ActionEvent actionEvent) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getstaffcount();
        getMemcount();

    }

    private void getstaffcount()
    {
        try {
            lbl_MemStaff.setText(MemberDAOImpl.getidcountstaff());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getMemcount()
    {
        try {
            lbl_MemStudent.setText(MemberDAOImpl.getidcountStudent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
