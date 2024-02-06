package ru.academits.zhurov.matrix.matrix;

import ru.academits.vector.vector.Vector;

public class Matrix {
    //TODO подумать над названием поля.
    //TODO подумать почему не работает класс Vector
   private Vector[] arrayVectors;

    public Matrix(Vector[] arrayVectors) {
        this.arrayVectors = arrayVectors;
    }

    public Vector[] getArrayVectors() {
        return arrayVectors;
    }

    public void setArrayVectors(Vector[] arrayVectors) {
        this.arrayVectors = arrayVectors;
    }
}
