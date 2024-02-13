package ru.academits.zhurov.shapes;

public class Triangle implements Shape {
    private double xA;
    private double yA;
    private double xB;
    private double yB;
    private double xC;
    private double yC;

    public Triangle(double xA, double xB, double xC, double yA, double yB, double yC) {
        this.xA = xA;
        this.xB = xB;
        this.xC = xC;
        this.yA = yA;
        this.yB = yB;
        this.yC = yC;
    }

    public double getXA() {
        return xA;
    }

    public void setXA(double xA) {
        this.xA = xA;
    }

    public double getXB() {
        return xB;
    }

    public void setXB(double xB) {
        this.xB = xB;
    }

    public double getXC() {
        return xC;
    }

    public void setXC(double xC) {
        this.xC = xC;
    }

    public double getYA() {
        return yA;
    }

    public void setYA(double yA) {
        this.yA = yA;
    }

    public double getYB() {
        return yB;
    }

    public void setYB(double yB) {
        this.yB = yB;
    }

    public double getYC() {
        return yC;
    }

    public void setYC(double yC) {
        this.yC = yC;
    }

    @Override
    public double getWidth() {
        return Math.max(xA, Math.max(xB, xC) - Math.min(xA, Math.min(xB, xC)));
    }

    @Override
    public double getHeight() {
        return Math.max(yA, Math.max(yB, yC) - Math.min(yA, Math.min(yB, yC)));
    }

    @Override
    public double getArea() {
        double side1Length = getLength(xA, xB, yA, yB);
        double side2Length = getLength(xA, xC, yA, yC);
        double side3Length = getLength(xB, xC, yB, yC);

        double semiPerimeter = (side1Length + side2Length + side3Length) / 2;

        return Math.sqrt(semiPerimeter * (semiPerimeter - side1Length) * (semiPerimeter - side2Length) * (semiPerimeter - side3Length));
    }

    @Override
    public double getPerimeter() {
        return getLength(xA, xB, yA, yB) + getLength(xA, xC, yA, yC) + getLength(xB, xC, yB, yC);
    }

    @Override
    public String toString() {
        return "Треугольник c координатами: (" + xA + ", " + yA + "), (" + xB + ", " + yB + "), (" + xC + ", " + yC + ")";
    }

    private static double getLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) o;
        return triangle.xA == xA && triangle.xB == xB && triangle.xC == xC
                && triangle.yA == yA && triangle.yB == yB && triangle.yC == yC;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + Double.hashCode(xA);
        hash = prime * hash + Double.hashCode(xB);
        hash = prime * hash + Double.hashCode(xC);
        hash = prime * hash + Double.hashCode(yA);
        hash = prime * hash + Double.hashCode(yB);
        hash = prime * hash + Double.hashCode(yC);

        return hash;
    }
}
