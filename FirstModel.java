package com.example.demo19;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.PublicKey;

public class FirstModel {
    private ObservableList<People> names;

    public FirstModel(){
        this.names = FXCollections.observableArrayList();
        //names.add("Angel");
        //names.add("Sandra");
    }

    public ObservableList<People> getNames() {
        return names;
    }

    public void setNames(ObservableList<People> names) {
        this.names = names;
    }
}
