package com.example.examen_2_sqllite.entities;

public class User {

    private int id;
    private String nick_name;
    private String password;
    private String name;

    public User(int id, String nick_name, String password, String name) {
        this.id = id;
        this.nick_name = nick_name;
        this.password = password;
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
