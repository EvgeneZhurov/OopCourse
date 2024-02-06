package ru.academits.vector.vector;

public class Vector {
    private double[] array;

    public Vector(int n) {
        this.array = new double[n];
    }

    public Vector(Vector vector) {
        this.array = new double[vector.array.length];

        for (int i = 0; i < vector.array.length; i++) {
            assert false;
            this.array[i] = vector.array[i];
        }
    }

    public Vector(double[] array) {
        this.array = new double[array.length];
        System.arraycopy(array, 0, this.array, 0, array.length);
    }

    public Vector(int n, double[] array) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
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
        return this.array.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        System.out.println();

        for (double v : this.array) {
            stringBuilder.append(v).append("; ");
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public void doVectorsSum(Vector vector) {
        for (int i = 0; i < Math.min(this.getSize(), vector.getSize()); i++) {
            this.array[i] += vector.array[i];
        }
    }

    public void doVectorsDifference(Vector vector) {
        for (int i = 0; i < Math.min(this.getSize(), vector.getSize()); i++) {
            this.array[i] -= vector.array[i];
        }
    }

    public void getScalarMultiplication(double multiplier) {
        for (int i = 0; i < this.getSize(); i++) {
            this.array[i] *= multiplier;
        }
    }

    public void getRevers() {
        for (int i = 0; i < this.getSize(); i++) {
            this.array[i] *= -1;
        }
    }

    public double getLength() {
        double lengthsSquaresSum = 0;

        for (int i = 0; i < this.getSize(); i++) {
            lengthsSquaresSum += Math.pow(this.array[i], 2);
        }

        return Math.sqrt(lengthsSquaresSum);
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < vector1.getSize(); i++) {
            vector.array[i] += vector1.array[i];
        }

        for (int i = 0; i < vector2.getSize(); i++) {
            vector.array[i] += vector2.array[i];
        }

        return vector;
    }

    public static Vector getVectorsDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < vector1.getSize(); i++) {
            vector.array[i] += vector1.array[i];
        }

        for (int i = 0; i < vector2.getSize(); i++) {
            vector.array[i] -= vector2.array[i];
        }

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