package com.tss.test;

import com.tss.model.Box;

public class BoxTest {
    public static void main(String[] args) {
        Box box1 = new Box(1, 2, 3);
        Box box2 = new Box(3, 5, 6);
        Box box3 = new Box(7, 8 ,9);
        box1.setVolume();
        box1.displayData();
        box2.displayData();
        box2.setVolume();
        box2.setHeight(30);
        box2.displayData();
        System.out.println(box3.getHeight());
    }
}
