package com.example.tablayout_viewpager_crud.model;

public class Cat {
    private int img;
    private String name,des;
    private Double price;

    public Cat(int img, String name, Double price, String des) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
