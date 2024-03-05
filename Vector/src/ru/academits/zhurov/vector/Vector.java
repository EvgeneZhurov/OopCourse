package ru.academits.zhurov.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;

    public Vector(int dimension) {
        if (dimension < 1) {
            throw new IllegalArgumentException("Номер компоненты вектора - натуральное число. Введено: " + dimension);
        }

        vectorComponents = new double[dimension];
    }

    public Vector(Vector vector) {
        vectorComponents = Arrays.copyOf(vector.vectorComponents, vector.vectorComponents.length);
    }

    public Vector(double[] vectorComponents) {
        if (vectorComponents.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть = 0.");
        }

        this.vectorComponents = Arrays.copyOf(vectorComponents, vectorComponents.length);
    }

    public Vector(int dimension, double[] vectorComponents) {
        if (dimension < 1) {
            throw new IllegalArgumentException("Номер компоненты вектора - натуральное число. Введено: " + dimension);
        }

        if (vectorComponents.length == 0) {
            throw new IllegalArgumentException("Размерность вектора не может быть = 0.");
        }

        this.vectorComponents = new double[dimension];

        System.arraycopy(vectorComponents, 0, this.vectorComponents, 0, dimension);
    }

    public int getSize() {
        return vectorComponents.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (double v : vectorComponents) {
            stringBuilder.append(v).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vectorComponents);
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

        if (vector.vectorComponents.length != vectorComponents.length) {
            return false;
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            if (vectorComponents[i] != vector.vectorComponents[i]) {
                return false;
            }
        }

        return true;
    }

    public void addSum(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] += vector.vectorComponents[i];
        }
    }

    public void subtractDifference(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] -= vector.vectorComponents[i];
        }
    }

    public void multiplyByScalar(double multiplier) {
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] *= multiplier;
        }
    }

    public void unwrap() {
        this.multiplyByScalar(-1);
    }

    public double getLength() {
        double squaresSum = 0;

        for (double v : vectorComponents) {
            squaresSum += v * v;
        }

        return Math.sqrt(squaresSum);
    }

    public double getComponent(int index) {
        if (index < 1 || index >= vectorComponents.length) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс. Размерность: " + vectorComponents.length + " Введено: " + index);
        }

        return vectorComponents[index];
    }

    public void setComponent(int index, double value) {
        if (index < 1 || index >= vectorComponents.length) {
            throw new ArrayIndexOutOfBoundsException("Некорректный индекс. Размерность: " + vectorComponents.length + " Введено: " + index);
        }

        vectorComponents[index] = value;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.addSum(vector2);

        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        vector.subtractDifference(vector2);

        return vector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        int minVectorsComponentsLength = Math.min(vector1.vectorComponents.length, vector2.vectorComponents.length);

        for (int i = 0; i < minVectorsComponentsLength; i++) {
            scalarProduct += vector1.vectorComponents[i] * vector2.vectorComponents[i];
        }

        return scalarProduct;
    }
}