package com.tss.model;

public class Box {
    private double width;
    private double height;
    private double depth;
    private double volume;

    public Box() {
        width = 0;
        height = 0;
        depth = 0;
    }

    public Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getDepth() {
        return depth;
    }

    public void setVolume() {
        this.volume = this.depth * this.height * this.width;
    }

    public double getVolume() {
        return volume;
    }

    public void displayData() {
        System.out.println("Width: " + this.width + "\n Height: " + height + "\n Depth: " + depth + "\n Volume: " + volume);
    }
}
