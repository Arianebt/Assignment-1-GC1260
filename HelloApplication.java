package com.example.demo19;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Assignment 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
        try{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcrecord","root","Q8iqQ74q@10");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student") ;
        while(resultSet.next()){
            System.out.println(resultSet.getString("StudentName"));
        }
        } catch (Exception e){
            System.out.println(e);
        }

  }
}