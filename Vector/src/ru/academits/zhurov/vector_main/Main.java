package ru.academits.zhurov.vector_main;

import ru.academits.zhurov.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{10, 2, 3, 4});
        Vector vector2 = new Vector(new double[]{1, 2, 7});
        Vector vector3 = new Vector(5, new double[]{1, 2, 7});

        System.out.println("Проверка корректности работы конструктора : " + vector3);
        System.out.println("Проверка корректности работы метода equals: " + vector3.equals(vector2));

        vector1.add(vector2);
        System.out.println("Сумма векторов: " + vector1);

        vector2.subtract(vector1);
        System.out.println("Разность векторов: " + vector2);

        vector1.multiplyByScalar(5);
        System.out.println("Умножение на скаляр: " + vector1);

        vector1.reverse();
        System.out.println("Разворот вектора: " + vector1);

        System.out.println("Длина вектора = " + vector1.getLength());

        System.out.println(vector1.getComponent(-1));
    }
}

