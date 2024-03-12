package ru.academits.zhurov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size)  {
        if (size < 1) {
            throw new IllegalArgumentException("Количество компонент вектора должно быть больше 0. Передано: " + size);
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть = 0.");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int size, double[] components) {
        if (size < 1) {
            throw new IllegalArgumentException("Количество компонент должно быть больше 0. Передано: " + size);
        }

        this.components = Arrays.copyOf(components, size);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (double v : components) {
            stringBuilder.append(v).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return Arrays.equals(vector.components, components);
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplyByScalar(double multiplier) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= multiplier;
        }
    }

    public void revers() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double v : components) {
            squaresSum += v * v;
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("Некорректный индекс. Возможные значения индекса: от 0 до "
                    + (components.length - 1) + " .Передано: " + index);
        }

        return components[index];
    }

    public void setComponent(int index, double value) {
        if (index < 0 || index >= components.length) {
            throw new IllegalArgumentException("Некорректный индекс. Возможные значения индекса: от 0 до "
                    + (components.length - 1) + " .Передано: " + index);
        }

        components[index] = value;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.add(vector2);

        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.subtract(vector2);

        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        int minComponentsSize = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minComponentsSize; i++) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}