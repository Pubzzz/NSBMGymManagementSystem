package GymSystem.controller;

import GymSystem.bo.BOFactory;
import GymSystem.bo.custom.InstructorBO;
import GymSystem.dao.custom.impl.InstructorDAOImpl;
import GymSystem.dto.InstructorDTO;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InstructorViewController implements Initializable {

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
    private TableView<InstructorDTO> table_Instructor;


    static InstructorBO bo = (InstructorBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.INSTRUCTOR);

    public static boolean addInstructor(InstructorDTO ref) throws ClassNotFoundException, SQLException {
        return bo.addInstructor(ref);
    }

    public static boolean updateInstructor(InstructorDTO ref) throws SQLException, ClassNotFoundException {
        return bo.updateInstructor(ref);
    }

    public static boolean deleteInstructor(String id) throws SQLException, ClassNotFoundException {
        return bo.deleteInstructor(id);
    }


    public static InstructorDTO searchInstructor(String id) throws SQLException, ClassNotFoundException {
        return bo.searchInstructor(id);
    }



    public void onaction_register(ActionEvent actionEvent) throws Exception {

        String id=txt_InstructorId.getText();
        if (!(ifMemberExists(id))) {
            String name = txt_InstructorName.getText();
            String nic = txt_InstructorNIC.getText();
            String gender;
            if (radio_Male.isSelected()) {
                gender = "Male";
            } else {
                gender = "Female";
            }
            String email = txt_InstructorEmail.getText();
            String tp = txt_InstructorTelNo.getText();


            InstructorDTO cusModel = new InstructorDTO(id, name, nic, gender, email, tp);
            boolean addCustomer = InstructorViewController.addInstructor(cusModel);

            if (addCustomer) {
                Alert a = new Alert(Alert.AlertType.INFORMATION, "ADDED SUCCESSFULLY", ButtonType.OK);
                a.showAndWait();
                setAllClear();
                getAllInstructors();


            } else {
                Alert a = new Alert(Alert.AlertType.WARNING, "FAILED", ButtonType.OK);
                a.showAndWait();
            }
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "INSTRUCTOR ALREADY EXISTS", ButtonType.OK);
            a.showAndWait();
        }

    }

    public void onaction_update(ActionEvent actionEvent) throws Exception {

        String id=txt_InstructorId.getText();
        String name=txt_InstructorName.getText();
        String nic=txt_InstructorNIC.getText();
        String gender;
        if (radio_Male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String email=txt_InstructorEmail.getText();
        String tp=txt_InstructorTelNo.getText();

        InstructorDTO cusModel = new InstructorDTO(id, name, nic, gender, email, tp);
        boolean updateInstructor = InstructorViewController.updateInstructor(cusModel);


        if(updateInstructor){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "UPDATED SUCCESSFULLY", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllInstructors();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_remove(ActionEvent actionEvent) throws Exception {
        String id = txt_InstructorId.getText();

        boolean removeCustomer = deleteInstructor(id);
        if(removeCustomer){
            Alert a = new Alert(Alert.AlertType.INFORMATION, "DELETED SUCCSESSFULLY ", ButtonType.OK);
            a.showAndWait();
            setAllClear();
            getAllInstructors();
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING, "FAILED ", ButtonType.OK);
            a.showAndWait();
        }
    }

    public void onaction_clear(ActionEvent actionEvent) {
        setAllClear();
    }

    public void onaction_search(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        InstructorDTO searchInstructor = bo.searchInstructor(txt_InstructorSearch.getText());

        txt_InstructorId.setText(searchInstructor.getId());
        txt_InstructorName.setText(searchInstructor.getName());
        txt_InstructorNIC.setText(searchInstructor.getNic());
        if(searchInstructor.getGender().contentEquals("Female")){
            radio_Female.setSelected(true);
            radio_Male.setSelected(false);
        }
        else{
            radio_Female.setSelected(false);
            radio_Male.setSelected(true);
        }
        txt_InstructorEmail.setText(searchInstructor.getEmail());
        txt_InstructorTelNo.setText(searchInstructor.getTp());
    }

    public void onaction_clicked(MouseEvent mouseEvent) {
            
        InstructorDTO selectedItem = table_Instructor.getSelectionModel().getSelectedItem();

        txt_InstructorId.setText(selectedItem.getId());
        txt_InstructorName.setText(selectedItem.getName());
        txt_InstructorNIC.setText(selectedItem.getNic());
        if(selectedItem.getGender().contentEquals("Female")){
            radio_Female.setSelected(true);
            radio_Male.setSelected(false);
        }
        else{
            radio_Female.setSelected(false);
            radio_Male.setSelected(true);
        }
        txt_InstructorEmail.setText(selectedItem.getEmail());
        txt_InstructorTelNo.setText(selectedItem.getTp());
    }


    private void setAllClear(){
        txt_InstructorId.clear();
        txt_InstructorName.clear();
        txt_InstructorNIC.clear();
        radio_Female.setSelected(false);
        radio_Male.setSelected(false);
        txt_InstructorEmail.clear();
        txt_InstructorTelNo.clear();
        txt_InstructorSearch.clear();



    }

    private void getAllInstructors() throws Exception {
        ArrayList<InstructorDTO> instructorList;
        try {
            instructorList = bo.getAllInstructor();
            ObservableList<InstructorDTO> Instructor = FXCollections.observableArrayList(instructorList);
            table_Instructor.setItems(Instructor);
            table_Instructor.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
            table_Instructor.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            table_Instructor.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("nic"));
            table_Instructor.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
            table_Instructor.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
            table_Instructor.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("tp"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllInstructors();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private boolean ifMemberExists(String mid) {
        try {
            return InstructorDAOImpl.checkIfMemberExist(mid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}