package com.example.assignment8and10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ViewDetailsController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<ViewTable> table;

    @FXML
    private TableColumn<ViewTable, String> emp_id;

    @FXML
    private TableColumn<ViewTable, String> name;

    @FXML
    private TableColumn<ViewTable, String> email;

    @FXML
    private TableColumn<ViewTable, String> dept;

    @FXML
    private TableColumn<ViewTable, String> age;

    @FXML
    private javafx.scene.text.Text label_name;

    @FXML
    private javafx.scene.text.Text label_dept;

    @FXML
    private javafx.scene.text.Text label_Id;

    @FXML
    private javafx.scene.text.Text label_email;

    @FXML
    private javafx.scene.text.Text label_age;

    @FXML
    private VBox vbox;

    @FXML
    private Button update;

    @FXML
    private TextField field_id;

    @FXML
    private TextField field_name;

    @FXML
    private TextField field_dept;

    @FXML
    private TextField field_age;

    @FXML
    private TextField field_email;

    @FXML
    void rowClicked(MouseEvent event)
    {
        ViewTable clickedData = table.getSelectionModel().getSelectedItem();
        field_name.setText(String.valueOf((clickedData.getName())));
        field_email.setText(String.valueOf((clickedData.getEmail())));
        field_dept.setText(String.valueOf((clickedData.getDept())));
        field_age.setText(String.valueOf((clickedData.getAge())));
        field_id.setText(String.valueOf((clickedData.getEmp_id())));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "laksh");

            PreparedStatement stmt = null;
            ResultSet resultSet = null;

            stmt = connection.prepareStatement("SELECT * FROM employee");

            resultSet = stmt.executeQuery();


            table.setEditable(true);

            emp_id.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            age.setCellValueFactory(new PropertyValueFactory<>("age"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            dept.setCellValueFactory(new PropertyValueFactory<>("dept"));

            ObservableList<ViewTable> employee_List = FXCollections.observableArrayList();
            while (resultSet.next()) {

                ViewTable employees = new ViewTable(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                );

                employee_List.add(employees);

            }
            table.setItems(employee_List);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.update(event,field_id.getText(),field_name.getText(),field_age.getText(),field_dept.getText(),field_email.getText());

            }
        });
    }



}
