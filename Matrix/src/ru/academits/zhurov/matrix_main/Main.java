package ru.academits.zhurov.matrix_main;

import ru.academits.vector.Vector;
import ru.academits.zhurov.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2, 3);
        System.out.println(matrix.getColumnLength());
        System.out.println("Проверка конструктора " + matrix);

        double[][] array = {{1, 2, 3}, {4, 5, 6}};
        Matrix matrix2 = new Matrix(array);
        System.out.println("Проверка конструктора " + matrix2);

        Vector vector = matrix2.getVectorRow(0);
        System.out.println("Проверка метода getVectorRow " + vector);

        matrix2.setScalarMultiplication(2);
        System.out.println("Проверка метода setScalarMultiplication " + matrix2);

        matrix2.setTransposition();
        System.out.println("Проверка метода setTransposition " + matrix2);

        double[][] array1 = {{1, 2}, {4, 5}};
        Matrix matrix3 = new Matrix(array1);
        System.out.println("Определитель матрицы = " + matrix3.getDeterminant());

        Vector vector4 = new Vector(new double[]{5, 6, 7});
        Vector vector5 = matrix2.getVectorMultiplying(vector4);
        System.out.println("Умножение матрицы на вектор " + vector5);

        double[][] array4 = {{1, 2}, {4, 5}};
        Matrix matrix4 = new Matrix(array4);

        double[][] array5 = {{10, 20}, {40, 50}};
        Matrix matrix5 = new Matrix(array5);

        matrix4.setMatrixSum(matrix5);
        System.out.println("Сложение матриц" + matrix4);

        matrix4.setMatrixSubtraction(matrix5);
        System.out.println("Вычитание матриц" + matrix4);

        double[][] array6 = {{1, 2}, {4, 5}};
        Matrix matrix6 = new Matrix(array6);

        double[][] array7 = {{10, 20, 30}, {40, 50, 60}};
        Matrix matrix7 = new Matrix(array7);

        Matrix matrix8 = Matrix.getMatrixMultiplication(matrix6, matrix7);
        System.out.println("Произведение матриц" + matrix8);
    }
}
