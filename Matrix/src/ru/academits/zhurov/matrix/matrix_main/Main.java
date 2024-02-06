package ru.academits.zhurov.matrix.matrix_main;

import ru.academits.zhurov.matrix.matrix.Matrix;

import java.util.Collections;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(Collections.singleton(new double[]{1, 2}));
        Vector vector2 = new Vector(Collections.singleton(new double[]{1, 2}));

        Vector[] vectors = new Vector[]{vector1,vector2};

        Matrix matrix = new Matrix(vectors);
    }
}
