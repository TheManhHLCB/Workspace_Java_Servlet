package com.codegym;

public class Customer {
    private String name;
    private String birthDate;
    private String address;
    private String photo;

    public Customer() {
    }

    public Customer(String name, String birthDate, String address, String photo) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
