package ru.academits.zhurov.shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
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

    @Override
    public String toString() {
        return "Квадрат со стороной: " + length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Square square = (Square) o;
        return square.length == length;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(length);
    }
}
