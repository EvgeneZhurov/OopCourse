package ru.academits.zhurov.shape.shape;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getWidth() {
        return this.length;
    }

    @Override
    public double getHeight() {
        return this.length;
    }

    @Override
    public double getArea() {
        return Math.pow(this.length, 2);
    }

    @Override
    public double getPerimeter() {
        final int sidesQuantity = 4;
        return sidesQuantity * this.length;
    }
}
