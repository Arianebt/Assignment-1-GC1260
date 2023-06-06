package com.example.demo19;

public class People {
    private String name;

    public People(){

    }

    public People(String name) {
        this.name = name;
    }

    public People(String studentName, String lastName, String score) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
