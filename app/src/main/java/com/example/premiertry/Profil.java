package com.example.premiertry;

import android.widget.EditText;

public class Profil {
    private int profilID;
    private String adress;
    private String email;
    private String number;
    private int age;
    private int weight;
    private int height;
    private String sex;
    private String smoking;
    private String contactName;
    private String contactNumber;

    public Profil(int profilID, String adress, String email, String number, int age, int weight, int height, String sex, String smoking, String contactName, String contactNumber) {
        this.profilID = profilID;
        this.adress = adress;
        this.email = email;
        this.number = number;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.smoking = smoking;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "profilID=" + profilID +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                ", smoking='" + smoking + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    public int getProfilID() {
        return profilID;
    }

    public void setProfilID(int profilID) {
        this.profilID = profilID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
