package com.example.intent_startactivityforresult.model;

import java.io.Serializable;

public class Account implements Serializable {
    private String username, pass;

    public Account() {
    }

    public Account(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}