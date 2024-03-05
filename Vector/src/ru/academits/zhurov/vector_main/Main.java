package ru.academits.zhurov.vector_main;

import ru.academits.zhurov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{10, 2, 3, 4});
        Vector vector2 = new Vector(new double[]{1, 2, 7});

        vector1.addSum(vector2);
        System.out.println("Сумма векторов: " + vector1);

        vector2.subtractDifference(vector1);
        System.out.println("Разность векторов: " + vector2);

        vector1.multiplyByScalar(5);
        System.out.println("Умножение на скаляр: " + vector1);

        vector1.unwrap();
        System.out.println("Разворот вектора: " + vector1);

        System.out.println("Длина вектора = " + vector1.getLength());
    }
}