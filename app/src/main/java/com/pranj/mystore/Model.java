package com.pranj.mystore;

public class Model {
    private String name;
    private String Phone;
    private String Email;
    private String Amount;
    private String Date;

    public Model(String name, String phone, String email, String amount, String date) {
        this.name = name;
        Phone = phone;
        Email = email;
        Amount = amount;
        Date = date;
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Amount='" + Amount + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
