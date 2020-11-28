package GymSystem.controller;

import GymSystem.dao.custom.impl.MemberDAOImpl;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class DashboardMainViewController  implements  Initializable {

    @FXML
    private Pane main_pain;

    @FXML
    private Pane main_panel;

    @FXML
    private JFXButton btn_Register;

    @FXML
    private JFXButton btn_Dashboard;

    @FXML
    private JFXButton btn_Attendance;

    @FXML
    private JFXButton btn_Instructor;

    @FXML
    private JFXButton btn_Accessories;

    @FXML
    private JFXButton btn_Signout;

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


    public void action_register(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/MemberView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_dashboard(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/DashboardView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getMemcount();
        getstaffcount();

    }


    public void action_attendance(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/AttendanceView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_instructor(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/InstructorView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_accessories(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/AccessoriesView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_tracker(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/TrackerView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void onaction_Signout(ActionEvent actionEvent) throws Exception {

         Parent parent=FXMLLoader.load(this.getClass().getResource("/GymSystem/view/LoginView.fxml"));
        Scene scene=new Scene(parent);
        Stage stage= (Stage)this.btn_Signout.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }


    public void onaction_ViewMember(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/MemberView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void onaction_Viewattendance(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/AttendanceView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void onaction_Viewinstructor(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1 = FXMLLoader.load(this.getClass().getResource("/GymSystem/view/InstructorView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    private void getstaffcount() {
        try {
            lbl_MemStaff.setText(MemberDAOImpl.getidcountstaff());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getMemcount() {
        try {
            lbl_MemStudent.setText(MemberDAOImpl.getidcountStudent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
