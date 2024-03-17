package ru.academits.zhurov.matrix;

import ru.academits.zhurov.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] strings;

    public Matrix(int stringsQuantity, int rowsQuantity) {
        if (rowsQuantity < 1) {
            throw new IndexOutOfBoundsException("Некорректное значение строки. Всего "
                    + getRowsQuantity() + " строк. Введено: " + rowsQuantity);
        }

        if (stringsQuantity < 1) {
            throw new IndexOutOfBoundsException("Некорректное значение столбца. Всего "
                    + getStringsQuantity() + " столбцов. Введено: " + stringsQuantity);
        }

        Vector vector = new Vector(new double[rowsQuantity]);
        Vector[] vectors = new Vector[stringsQuantity];

        for (int i = 0; i < stringsQuantity; i++) {
            vectors[i] = vector;
        }

        strings = vectors;
    }

    public Matrix(Matrix matrix) {
        strings = matrix.strings;
    }

    //TODO метод работает некорректно
    // протестировать
    public Matrix(double[][] array) {
        if (array[0].length < 1) {
            throw new IndexOutOfBoundsException("Некорректное значение строки. Введено: " + array[0].length);
        }

        int stringsQuantity = array.length;
        int rowsQuantity = array[0].length;

        for (double[] row : array) {
            rowsQuantity = Math.max(rowsQuantity, row.length);
        }

        Matrix matrix = new Matrix(rowsQuantity, stringsQuantity);
        this.strings = matrix.strings;

        for (int i = 0; i < array.length; i++) {
            Vector vector = new Vector(rowsQuantity);

            for (int j = 0; j < array[i].length; j++) {
                vector.setComponent(j, array[i][j]);
            }

            setRow(i, vector);
        }
    }

    public Matrix(Vector[] strings) {
        this.strings = strings;
    }

    public Vector[] getStrings() {
        return strings;
    }

    public int getStringsQuantity() {
        return strings.length;
    }

    public int getRowsQuantity() {
        return strings[0].getSize();
    }

    public void setRow(int stringNumber, Vector vector) {
        if (stringNumber < 0 || stringNumber > getStringsQuantity()) {
            throw new IndexOutOfBoundsException("Некорректное значение столбца. Всего "
                    + getStringsQuantity() + " столбцов. Введено: " + stringNumber);
        }

        strings[stringNumber] = vector;
    }

    public Vector getRow(int stringNumber) {
        if (stringNumber < 0 || stringNumber > getStringsQuantity()) {
            throw new IndexOutOfBoundsException("Некорректное значение столбца. Всего "
                    + getStringsQuantity() + " столбцов. Введено: " + stringNumber);
        }

        return new Vector(strings[stringNumber]);
    }

    public Vector getString(int stringNumber) {
        if (stringNumber < 0 || stringNumber > getStringsQuantity()) {
            throw new IndexOutOfBoundsException("Некорректное значение столбца. Всего "
                    + getStringsQuantity() + " столбцов. Введено: " + stringNumber);
        }

        Vector vector = new Vector(strings.length);

        for (int i = 0; i < strings.length; i++) {
            vector.setComponent(i, strings[i].getComponent(stringNumber));
        }

        return vector;
    }

    public void setTransposition() {
        Matrix transposition = new Matrix(strings.length, getRowsQuantity());

        for (int i = 0; i < transposition.strings.length; i++) {
            transposition.setRow(i, getString(i));
        }

        strings = transposition.strings;
    }

    @Override
    //TODO доделать
       /*15. toString:
            - по заданию список элементов матрицы нужно печатать в фигурных скобках
        - нужно сделать полностью самим через StringBuilder*/
    public String toString() {
    /*    StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append('{');

        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append('{');

            for (int j = 0; j < strings[0].getSize(); j++) {
                stringBuilder.append(strings[i].getComponent(j));
            }

            stringBuilder.append('{');
        }

        stringBuilder.append('}');

        return String.valueOf(stringBuilder);
*/
        return Arrays.toString(strings);
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

        if (matrix.strings.length != strings.length) {
            return false;
        }

        for (int i = 0; i < matrix.strings.length; i++) {
            if (!strings[i].equals(matrix.strings[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(strings);
    }

    public void setScalarMultiplication(double multiplier) {
        for (Vector vector : strings) {
            vector.multiplyByScalar(multiplier);
        }
    }

    public double getDeterminant() {
        if (!isSquare()) {
            throw new IndexOutOfBoundsException(" Определитель считается только у квадратных матриц при наличии чисел");
        }

        if (strings.length == 1) {
            return getString(0).getComponent(0);
        }

        double[][] matrix1 = new double[strings.length][strings.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[j][i] = getRow(j).getComponent(i);
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

    public Vector getVectorMultiplying(Vector vector) {
        if (vector.getSize() != getStringsQuantity()) {
            throw new IndexOutOfBoundsException(" При умножении матрицы на вектор-столбец число столбцов в матрице"
                    + " должно совпадать с числом строк в векторе-столбце. Количество столбцов в марице: "
                    + getStringsQuantity() + " .Количество строк в векторе-столбце: " + vector.getSize());
        }

        Vector vectorMultiplying = new Vector(getRowsQuantity());

        for (int i = 0; i < getRowsQuantity(); i++) {
            for (int j = 0; j < vector.getSize(); j++) {
                vectorMultiplying.setComponent(i, vectorMultiplying.getComponent(i)
                        + vector.getComponent(j) * getString(i).getComponent(j));
            }
        }

        return vectorMultiplying;
    }

    public void addSum(Matrix matrix) {
        if (strings.length != matrix.getStringsQuantity() || getRowsQuantity() != matrix.getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Складывать можно только матрицы с одинаковыми длинами строк или столбцов. Количество строк в матрице: "
                    + strings.length + " .Количество строк в матрице, вводимой в метод в качестве аргумента :");
        }

        for (int i = 0; i < strings.length; i++) {
            Vector row = getRow(i);
            Vector matrixRow = matrix.getRow(i);

            row.add(matrixRow);
            setRow(i, row);
        }
    }

    public void setMatrixSubtraction(Matrix matrix) {
        if (strings.length != matrix.getStringsQuantity() || getRowsQuantity() != matrix.getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Вычитать можно только тогда, когда матрицы совпадают по длинам строк или столбцов");
        }

        for (int i = 0; i < matrix.getStringsQuantity(); i++) {
            Vector row = getRow(i);
            Vector matrixRow = matrix.getRow(i);

            matrixRow.reverse();

            row.add(matrixRow);
            setRow(i, row);
        }
    }

    public static Matrix getMatrixSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getStringsQuantity() != matrix2.getStringsQuantity() || matrix1.getRowsQuantity() != matrix2.getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Складывать можно только матрицы с одинаковыми длинами строк или столбцов");
        }

        Matrix matrixSubtraction = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getStringsQuantity(); i++) {
            Vector rowMatrixSubtraction = matrixSubtraction.getRow(i);
            Vector matrix2Row = matrix2.getRow(i);

            rowMatrixSubtraction.add(matrix2Row);
            matrixSubtraction.setRow(i, rowMatrixSubtraction);
        }

        return matrixSubtraction;
    }

    public static Matrix getMatrixSubtraction(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getStringsQuantity() != matrix2.getStringsQuantity() || matrix1.getRowsQuantity() != matrix2.getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Вычитать можно только тогда, когда матрицы совпадают по длинам строк или столбцов. Введено строк 1 матрицы: "
                    + matrix1.getStringsQuantity() + "Введено строк 2 матрицы: " + matrix2.getStringsQuantity()
                    + "Введено столбцов 1 матрицы:" + matrix1.getRowsQuantity() + "Введено столбцов 2 матрицы:" + matrix2.getRowsQuantity());
        }

        Matrix subtraction = new Matrix(matrix1);

        for (int i = 0; i < matrix1.getStringsQuantity(); i++) {
            Vector subtractionRow = subtraction.getRow(i);
            Vector matrix2Row = matrix2.getRow(i);

            matrix2Row.reverse();

            subtractionRow.add(matrix2Row);
            subtraction.setRow(i, subtractionRow);
        }

        return subtraction;
    }

    public static Matrix getComposition(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getStringsQuantity() != matrix2.getStringsQuantity() || matrix1.getRowsQuantity() != matrix2.getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Вычитать можно только тогда, когда матрицы совпадают по длинам строк или столбцов. Введено строк 1 матрицы: "
                    + matrix1.getStringsQuantity() + "Введено строк 2 матрицы: " + matrix2.getStringsQuantity()
                    + "Введено столбцов 1 матрицы:" + matrix1.getRowsQuantity() + "Введено столбцов 2 матрицы:" + matrix2.getRowsQuantity());
        }

        Matrix composition = new Matrix(matrix2.getRowsQuantity(), matrix1.getStringsQuantity());

        for (int i = 0; i < matrix1.getStringsQuantity(); i++) {
            Vector compositionVector = composition.getRow(i);

            for (int j = 0; j < matrix2.getRowsQuantity(); j++) {
                compositionVector.setComponent(j, Vector.getScalarProduct(matrix1.getRow(i), matrix2.getString(j)));
            }

            composition.setRow(i, compositionVector);
        }

        return composition;
    }

    public boolean isSquare() {
        return getStringsQuantity() == getRowsQuantity();
    }
}