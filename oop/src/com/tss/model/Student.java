package com.tss.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private double feesPaid;
    private double totalFees;

    public Student(int id, String name, String course, double feesPaid, double totalFees) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.feesPaid = feesPaid;
        this.totalFees = totalFees;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void payFees(double amount) {
        this.feesPaid = this.feesPaid + amount;
    }

    public double getPenddingFees() {
        return this.totalFees - this.feesPaid;
    }

    @Override
    public String toString() {
        return "Student ID: " + this.id + "\nStudent name: " + this.name + "\nStudent Course: " + this.course + "\nFees Paid: " + this.feesPaid + "\nTotal Fees: " + this.totalFees;
    }
}
