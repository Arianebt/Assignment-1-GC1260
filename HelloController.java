package com.example.demo19;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.sql.*;

public class HelloController {
    @FXML
    private Label message;
    @FXML
    private ListView<People>  candidateList;

    private FirstModel example = new FirstModel();

    private ObservableList<People> peopleList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        candidateList.setItems(peopleList);
    }


    @FXML
    protected void onHelloButtonClick() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrecord", "root", "Q8iqQ74q@10");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            // Clear the existing data in the list
            peopleList.clear();

            // Iterate over the result set and add People objects to the list
            while (resultSet.next()) {
                String studentName = resultSet.getString("StudentName");
                String lastName = resultSet.getString("LastName");
                String score = resultSet.getString("score");

                People person = new People(studentName, lastName, score);
                peopleList.add(person);
            }

            resultSet.close();
            statement.close();
            connection.close();
            candidateList.setStyle("-fx-text-fill: black;");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}