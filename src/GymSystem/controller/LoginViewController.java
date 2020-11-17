package GymSystem.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private JFXButton btn_Login;

    @FXML
    private JFXTextField txt_Username;

    @FXML
    private JFXPasswordField txt_Password;

    public void onaction_Login(ActionEvent actionEvent) throws IOException {
        String text = txt_Username.getText();
        String password=txt_Password.getText();



        if(text.equalsIgnoreCase("1") && password.equalsIgnoreCase("1")){
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

    public void onaction_Username(ActionEvent actionEvent) {
        txt_Username.requestFocus();
    }

    public void onaction_Password(ActionEvent actionEvent) {
        txt_Password.requestFocus();
    }
}

