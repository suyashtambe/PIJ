package com.example.assignment8and10;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class DBUtils {
    public static void enter_to_database(Label notif, String employee_Id, String name, String email, String department, String age, ActionEvent event) throws SQLException {

        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExist = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "laksh");
            psCheckUserExist = connection.prepareStatement("SELECT * FROM employee WHERE employee_Id  = ?");
            psCheckUserExist.setString(1, employee_Id);
            resultSet = psCheckUserExist.executeQuery();

            if (resultSet.isBeforeFirst()) {
                notif.setText("It already Exists");
            } else {
                psInsert = connection.prepareStatement("INSERT INTO employee(employee_Id,name,email,department,age) VALUES(?,?,?,?,?)");
                psInsert.setString(1, employee_Id);
                psInsert.setString(2, name);
                psInsert.setString(3, email);
                psInsert.setString(4, department);
                psInsert.setString(5, age);
                psInsert.executeUpdate();

                DBUtils.details_changeScene(event, "viewdetails.fxml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void details_changeScene(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = null;

        FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
        root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Details");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void update(ActionEvent event ,String id, String name, String age, String dept, String email) {
        String sql = "UPDATE employee SET  name = ?, email = ?, department = ?,age = ? WHERE employee_Id = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB", "root", "laksh");
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, dept);
            stmt.setString(4, age);
            stmt.setString(5, id);

            stmt.executeUpdate();

            DBUtils.details_changeScene(event,"viewdetails.fxml");

        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
