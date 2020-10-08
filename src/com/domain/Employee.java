package com.domain;

public class Employee {
    private int id;
    private String name;
    private int grade;
    private String address, mobileNo, bankAccount;

    public Employee() {
    }

    public Employee(int id, String name, int grade, String address, String mobileNo, String bankAccount) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.mobileNo = mobileNo;
        this.bankAccount = bankAccount;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
