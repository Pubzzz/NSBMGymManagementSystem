package GymSystem.controller;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardMainViewController implements  Initializable {

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



    public void action_register(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/MemberView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_dashboard(ActionEvent actionEvent) throws IOException {

        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/DashboardView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void action_attendance(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/AttendanceView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_instructor(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/InstructorView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_accessories(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/AccessoriesView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void action_tracker(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane1= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/TrackerView.fxml"));
        main_panel.getChildren().clear();
        main_panel.getChildren().add(anchorPane1);
    }

    public void onaction_Signout(ActionEvent actionEvent) throws IOException {
        Parent parent=FXMLLoader.load(this.getClass().getResource("/GymSystem/view/LoginView.fxml"));
        Scene scene=new Scene(parent);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void onaction_ViewMember(ActionEvent actionEvent) {
    }

    public void onaction_ViewInstructor(ActionEvent actionEvent) {
    }

    public void onaction_ViewAccessories(ActionEvent actionEvent) {
    }
}
