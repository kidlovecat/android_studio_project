package com.example.quanlibaihat.model;

import java.io.Serializable;

public class CaSi implements Serializable {
    private String ten, moTa;

    public CaSi(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
