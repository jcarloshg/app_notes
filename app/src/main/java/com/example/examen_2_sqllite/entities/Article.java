package com.example.examen_2_sqllite.entities;

public class Article {

    private int id;
    private String name;
    private String brand;
    private float cost;
    private int amount;

    public Article(){}

    public Article(int id, String name, String brand, float cost, int amount) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.amount = amount;
    }

    // public DBArticle(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public float getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }


}
