package ru.academits.zhurov.shapes;

public class Square implements Shape {
    private double sideLength;
    final static int SIDES_QUANTITY = 4;

    public Square(double length) {
        this.sideLength = length;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double length) {
        this.sideLength = length;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return SIDES_QUANTITY * sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат со стороной: " + sideLength;
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
        return square.sideLength == sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }
}
