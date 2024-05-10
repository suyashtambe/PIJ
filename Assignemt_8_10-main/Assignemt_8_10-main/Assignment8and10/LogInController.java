package com.example.assignment8and10;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label notif;

    @FXML
    private Label label_id;

    @FXML
    private Label label_name;

    @FXML
    private Label label_age;

    @FXML
    private Label label_email;

    @FXML
    private Label label_dept;

    @FXML
    private TextField textField_employee_id;

    @FXML
    private TextField textField_name;

    @FXML
    private TextField textField_age;

    @FXML
    private TextField textField_email;

    @FXML
    private TextField textField_dept;

    @FXML
    private Button register;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String employee_Id = textField_employee_id.getText();
        String name = textField_name.getText();
        String email = textField_email.getText();
        String department = textField_dept.getText();
        String age = textField_age.getText();

        register.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    DBUtils.enter_to_database( notif,textField_employee_id.getText(),textField_name.getText(),textField_email.getText(),textField_dept.getText(),textField_age.getText(),event);

                } catch (SQLException e) {
                   e.printStackTrace();
                }
            }
        });

    }
}