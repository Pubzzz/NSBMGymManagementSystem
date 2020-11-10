package GymSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_password;

    @FXML
    private Button btn_Login;



    public void login_action(ActionEvent actionEvent) throws IOException {


        String text = txt_username.getText();
        String password=txt_password.getText();



        if(text.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
            Parent parent= FXMLLoader.load(this.getClass().getResource("/GymSystem/view/DashboardMainView.fxml"));
            Scene scene=new Scene(parent);
            Stage stage = (Stage) this.btn_Login.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

        }else
            {
            Alert a = new Alert(Alert.AlertType.WARNING, "Invalid Login ", ButtonType.OK);
            a.showAndWait();
        }
    }
    }

