package com.example.recyclerview_contact_database.Modal;

import android.net.Uri;

public class Contacts {
    private int id;
    private String name;
    private String surname;
    private String number;
    private String imgUri;

    public Contacts(int id, String name, String surname, String number,String imgUri) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.imgUri=imgUri;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
