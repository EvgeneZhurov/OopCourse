package ru.academits.zhurov.matrix;

import ru.academits.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] array;

    public Matrix(int row, int column) {
        Vector vector = new Vector(new double[row]);
        Vector[] vectors = new Vector[column];

        for (int i = 0; i < column; i++) {
            vectors[i] = vector;
        }

        array = vectors;
    }

    public Matrix(Matrix matrix) {
        array = matrix.array;
    }

    public Matrix(double[][] array) {
        int column = array.length;
        int row = array[0].length;

        for (double[] doubles : array) {
            row = Math.max(row, doubles.length);
        }

        Matrix matrix = new Matrix(row, column);
        this.array = matrix.array;

        for (int i = 0; i < array.length; i++) {
            Vector vector = new Vector(row);

            for (int j = 0; j < array[i].length; j++) {
                vector.setComponent(j, array[i][j]);
            }

            setVectorRow(i, vector);
        }
    }

    public Matrix(Vector[] array) {
        this.array = array;
    }

    public Vector[] getArray() {
        return array;
    }

    //TODO нужно подумать, что делать с векторами большей длины
    public void setArray(Vector[] array) {
        this.array = array;
    }

    public int getColumnLength() {
        return array.length;
    }

    public int getRowLength() {
        return array[0].getSize();
    }

    public void setVectorRow(int column, Vector vector) throws IllegalArgumentException {
        if (column < 0) {
            throw new IllegalArgumentException("Столбец должен быть неотрицательной величиной");
        }

        if (column > getRowLength()) {
            throw new IllegalArgumentException("Введенное значение превышает количество столбцов");
        }

        array[column] = vector;
    }

    public Vector getVectorRow(int column) throws IllegalArgumentException {
        if (column < 0) {
            throw new IllegalArgumentException("Столбец должен быть неотрицательной величиной");
        }

        if (column > getRowLength()) {
            throw new IllegalArgumentException("Введенное значение превышает количество столбцов");
        }

        return new Vector(array[column]);
    }

    public Vector getVectorColumn(int column) throws IllegalArgumentException {
        if (column < 0) {
            throw new IllegalArgumentException("Столбец должен быть неотрицательной величиной");
        }

        if (column > getRowLength()) {
            throw new IllegalArgumentException("Введенное значение превышает количество столбцов");
        }

        Vector vector = new Vector(array.length);

        for (int i = 0; i < array.length; i++) {
            vector.setComponent(i, array[i].getComponent(column));
        }

        return vector;
    }

    public void setTransposition() {
        Matrix transposition = new Matrix(array.length, getRowLength());

        for (int i = 0; i < transposition.array.length; i++) {
            transposition.setVectorRow(i, getVectorColumn(i));
        }

        array = transposition.array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) o;

        if (matrix.array.length != array.length) {
            return false;
        }

        for (int i = 0; i < matrix.array.length; i++) {
            if (!array[i].equals(matrix.array[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    public void setScalarMultiplication(double multiplier) {
        for (Vector vector : array) {
            vector.setScalarMultiplication(multiplier);
        }
    }

    public double getDeterminant() throws IllegalArgumentException {
        if (!isSquareMatrix()) {
            throw new IllegalArgumentException(" Определитель считается только у квадратных матриц при наличии чисел.");
        }

        if (array.length == 1) {
            return getVectorColumn(0).getComponent(0);
        }

        double[][] matrix1 = new double[array.length][array.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[j][i] = getVectorRow(j).getComponent(i);
            }
        }

        return getMatrixDeterminant(matrix1);
    }

    private static double getMatrixDeterminant(double[][] matrix) {
        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
        }

        double determinant = 0;

        for (int i = 0; i < matrix.length; i++) {
            double[][] subMatrix = new double[matrix.length - 1][matrix.length - 1];

            for (int j = 0; j < matrix.length - 1; j++) {
                for (int k = 1; k < matrix.length; k++) {
                    if (j >= i) {
                        subMatrix[k - 1][j] = matrix[k][j + 1];
                        continue;
                    }

                    subMatrix[k - 1][j] = matrix[k][j];
                }
            }

            determinant += Math.pow(-1, i) * matrix[0][i] * getMatrixDeterminant(subMatrix);
        }

        return determinant;
    }

    //TODO нужна валидация
    public Vector getVectorMultiplying(Vector vector) {
        Vector vectorMultiplying = new Vector(array[0].getSize());

        for (int i = 0; i < array[0].getSize(); i++) {
            for (int j = 0; j < vector.getSize(); j++) {
                vectorMultiplying.setComponent(i, vectorMultiplying.getComponent(i)
                        + vector.getComponent(j) * getVectorColumn(i).getComponent(j));
            }
        }

        return vectorMultiplying;
    }

    public void setMatrixSum(Matrix matrix) throws IllegalArgumentException {
        if (array.length != matrix.getColumnLength() || getRowLength() != matrix.getRowLength()) {
            throw new IllegalArgumentException("Складывать можно только матрицы с одинаковыми длинами строк или столбцов");
        }

        for (int i = 0; i < matrix.getColumnLength(); i++) {
            Vector row = getVectorRow(i);
            Vector matrixRow = matrix.getVectorRow(i);
            row.setSum(matrixRow);
            setVectorRow(i, row);
        }
    }

    public void setMatrixSubtraction(Matrix matrix) throws IllegalArgumentException {
        if (array.length != matrix.getColumnLength() || getRowLength() != matrix.getRowLength()) {
            throw new IllegalArgumentException("Вычитать можно только тогда, когда матрицы совпадают по длинам строк или столбцов");
        }

        for (int i = 0; i < matrix.getColumnLength(); i++) {
            Vector row = getVectorRow(i);
            Vector matrixRow = matrix.getVectorRow(i);

            matrixRow.setRevers();

            row.setSum(matrixRow);
            setVectorRow(i, row);
        }
    }

    public static Matrix getMatrixSum(Matrix matrix1, Matrix matrix2) throws IllegalArgumentException {
        if (matrix1.getColumnLength() != matrix2.getColumnLength() || matrix1.getRowLength() != matrix2.getRowLength()) {
            throw new IllegalArgumentException("Складывать можно только матрицы с одинаковыми длинами строк или столбцов");
        }

        Matrix matrixSubtraction = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getColumnLength(); i++) {
            Vector rowMatrixSubtraction = matrixSubtraction.getVectorRow(i);
            Vector matrix2Row = matrix2.getVectorRow(i);

            rowMatrixSubtraction.setSum(matrix2Row);
            matrixSubtraction.setVectorRow(i, rowMatrixSubtraction);
        }

        return matrixSubtraction;
    }

    public static Matrix getMatrixSubtraction(Matrix matrix1, Matrix matrix2) throws IllegalArgumentException {
        if (matrix1.getColumnLength() != matrix2.getColumnLength() || matrix1.getRowLength() != matrix2.getRowLength()) {
            throw new IllegalArgumentException("Вычитать можно только тогда, когда матрицы совпадают по длинам строк или столбцов");
        }

        Matrix subtraction = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getColumnLength(); i++) {
            Vector subtractionRow = subtraction.getVectorRow(i);
            Vector matrix2Row = matrix2.getVectorRow(i);

            matrix2Row.setRevers();

            subtractionRow.setSum(matrix2Row);
            subtraction.setVectorRow(i, subtractionRow);
        }

        return subtraction;
    }

    public static Matrix getMatrixMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowLength() != matrix2.getColumnLength()) {
            throw new IllegalArgumentException("Количество столбцов 1-й матрицы должно быть равно количеству строк 2-й матрицы");
        }

        Matrix multiplication = new Matrix(matrix2.getRowLength(), matrix1.array.length);

        for (int i = 0; i < matrix1.getColumnLength(); i++) {
            for (int j = 0; j < matrix2.getRowLength(); j++) {
                Vector matrix1Row = matrix1.getVectorRow(i);
                Vector matrix2Column = matrix2.getVectorColumn(j);

                Vector multiplicationVector = multiplication.getVectorRow(i);
                multiplicationVector.setComponent(j, Vector.getScalarComposition(matrix1Row, matrix2Column));

                multiplication.setVectorRow(i, multiplicationVector);
            }
        }

        return multiplication;
    }

    public boolean isSquareMatrix() {
        return getColumnLength() == getRowLength();
    }
}