package com.example.quanlichitieu.model;

public class BaiHat {
    private int id;
    private String ten, caSiHat, album, theLoai;
    private int yeuThich;

    public BaiHat() {
    }

    public BaiHat(int id, String ten, String caSiHat, String album, String theLoai, int yeuThich) {
        this.id = id;
        this.ten = ten;
        this.caSiHat = caSiHat;
        this.album = album;
        this.theLoai = theLoai;
        this.yeuThich = yeuThich;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCaSiHat() {
        return caSiHat;
    }

    public void setCaSiHat(String caSiHat) {
        this.caSiHat = caSiHat;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public int getYeuThich() {
        return yeuThich;
    }

    public void setYeuThich(int yeuThich) {
        this.yeuThich = yeuThich;
    }
}
