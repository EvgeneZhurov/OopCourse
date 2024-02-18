package ru.academits.vector.main;

import ru.academits.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(new double[]{1, 2, 3});

        vector1.getSum(vector2);
        System.out.println("Сумма векторов: " + vector1);

        vector2.getDifference(vector1);
        System.out.println("Разность векторов: " + vector2);

        vector1.getScalarMultiplication(5);
        System.out.println("Умножение на скаляр: " + vector1);

        vector1.getRevers();
        System.out.println("Разворот вектора: " + vector1);

        System.out.println("Длина вектора = " + vector1.getLength());

        Vector vector3 = Vector.getVectorsSum(vector1, vector2);
        System.out.println(vector1);
        System.out.println(vector2);
        System.out.println(vector3);

        vector3.setComponent(0, 1);
        System.out.println(vector3);
    }
}
