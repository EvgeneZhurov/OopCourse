package ru.academits.vector;

import java.util.Arrays;

public class Vector {
    private double[] array;

    public Vector(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть отрицательной");
        }

        array = new double[n];
    }

    public Vector(Vector vector) {
        array = new double[vector.array.length];

        for (int i = 0; i < vector.array.length; i++) {
            assert false;
            array[i] = vector.array[i];
        }
    }

    public Vector(double[] array) {
        this.array = new double[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public Vector(int n, double[] array) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть отрицательной");
        }

        this.array = new double[array.length];

        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public int getSize() {
        return array.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (double v : array) {
            stringBuilder.append(v).append("; ");
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
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

        if (vector.array.length != array.length) {
            return false;
        }

        for (int i = 0; i < vector.array.length; i++) {
            if (array[i] != vector.array[i]) {
                return false;
            }
        }

        return true;
    }

    public void getSum(Vector vector) {
        for (int i = 0; i < Math.min(array.length, vector.getSize()); i++) {
            this.array[i] += vector.array[i];
        }
    }

    public void getDifference(Vector vector) {
        for (int i = 0; i < Math.min(array.length, vector.getSize()); i++) {
            array[i] -= vector.array[i];
        }
    }

    public void getScalarMultiplication(double multiplier) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= multiplier;
        }
    }

    public void getRevers() {
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
    }

    public double getLength() {
        double lengthsSquaresSum = 0;

        for (double v : array) {
            lengthsSquaresSum += v * v;
        }

        return Math.sqrt(lengthsSquaresSum);
    }

    public double getComponent(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Номер компоненты вектора не может быть отрицательным");
        }

        if (n >= array.length) {
            throw new IllegalArgumentException("Номер компоненты вектора не может превышать размерность вектора");
        }

        return array[n];
    }

    public void setComponent(int n, double value) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Номер компоненты вектора не может быть отрицательным");
        }

        if (n >= array.length) {
            throw new IllegalArgumentException("Номер компоненты вектора не может превышать размерность вектора");
        }

        array[n] = value;
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        vector.getSum(vector1);
        vector.getSum(vector2);

        return vector;
    }

    public static Vector getVectorsDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        vector.getSum(vector1);
        vector.getDifference(vector2);

        return vector;
    }

    public static double getScalarComposition(Vector vector1, Vector vector2) {
        double scalarComposition = 0;

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); i++) {
            scalarComposition += vector1.array[i] * vector2.array[i];
        }

        return scalarComposition;
    }
}