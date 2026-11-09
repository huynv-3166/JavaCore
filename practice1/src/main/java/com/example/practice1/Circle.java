package com.example.practice1;

public class Circle extends Shape {
    public Circle(double diameter) {
        super(diameter, diameter);
    }

    public double getArea() {
        double radius = getWidth() / 2;
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return getWidth() * 3.14;
    }
}