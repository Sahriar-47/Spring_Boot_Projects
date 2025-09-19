package com.example;

public class City {
    private int id;
    private String name;

    public State getS() {
        return s;
    }

    public void setS(State s) {
        this.s = s;
    }

    private State s;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showCityDetails() {
        System.out.println(id);
        System.out.println(name);
        System.out.println(s.getName());
    }
}
