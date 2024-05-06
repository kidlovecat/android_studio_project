package com.example.kiem_tra_1.model;

public class Phone {
    private int img;
    private String name,xuatxu;
    private Double price;

    public  Phone(){}


    public Phone(int img, String name, String xuatxu, Double price) {
        this.img = img;
        this.name = name;
        this.xuatxu = xuatxu;
        this.price = price;
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

    public String getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(String xuatxu) {
        this.xuatxu = xuatxu;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
