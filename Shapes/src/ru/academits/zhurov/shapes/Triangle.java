package ru.academits.zhurov.shape.shapes;

import java.util.Objects;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }


    public void setX1(double x1) {
        this.x1 = x1;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(this.x1, Math.max(this.x2, this.x3) - Math.min(this.x1, Math.min(this.x2, this.x3)));
    }

    @Override
    public double getHeight() {
        return Math.max(this.y1, Math.max(this.y2, this.y3) - Math.min(this.y1, Math.min(this.y2, this.y3)));
    }

    @Override
    public double getArea() {
        double firstSide = getLength(x1, x2, y1, y2);
        double secondSide = getLength(x1, x3, y1, y3);
        double thirdSide = getLength(x2, x3, y2, y3);

        double semiPerimeter = (firstSide + secondSide + thirdSide) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide) * (semiPerimeter - thirdSide));
    }

    @Override
    public double getPerimeter() {
        return getLength(x1, x2, y1, y2) + getLength(x1, x3, y1, y3) + getLength(x2, x3, y2, y3);
    }

    @Override
    public String toString() {
        return "Треугольник";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return this.x1 != triangle.x1 || this.x2 != triangle.x2 || this.x3 != triangle.x3 ||
                this.y1 != triangle.y1 || this.y2 != triangle.y2 || this.y3 != triangle.y3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, x3, y1, y2, y3);
    }


    private static double getLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
