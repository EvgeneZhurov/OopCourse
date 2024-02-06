package ru.academits.vector.vector_main;

import ru.academits.vector.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(new double[]{1, 2, 3, 4, 5});

        Vector[] vectors = new Vector[]{vector1, vector2};

        System.out.println(Arrays.toString(vectors));

/*
        vector1.doVectorsSum(vector2);
        System.out.println(vector1.toString());

        vector2.doVectorsDifference(vector1);
        System.out.println(vector2.toString());

        vector1.getScalarMultiplication(5);
        System.out.println(vector1.toString());

        vector1.getRevers();
        System.out.println(vector1.toString());

        System.out.println(vector1.getLength());
*/

        Vector vector3 = Vector.getVectorsSum(vector1, vector2);
        System.out.println(vector1.toString());
        System.out.println(vector2.toString());
        System.out.println(vector3.toString());
    }
}
