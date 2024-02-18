package ru.academits.zhurov.range_main;

import ru.academits.zhurov.range.Range;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Range range1 = new Range(1, 10);

        System.out.println("Начало диапазона: " + range1.getFrom());
        System.out.println("Конец диапазона: " + range1.getTo());

        double coordinate = 13.0;

        if (range1.isInside(coordinate)) {
            System.out.println("Координата " + coordinate + " принадлежит диапазону от " + range1.getFrom() + " до " + range1.getTo());
        } else {
            System.out.println("Координата " + coordinate + " не принадлежит диапазону от " + range1.getFrom() + " до " + range1.getTo());
        }

        System.out.println("Длина диапазона = " + range1.getLength());

        range1.setFrom(5);
        range1.setTo(9);

        System.out.println("Длина диапазона после изменения = " + range1.getLength());

        Range range2 = new Range(9, 10);
        System.out.println("Пересечение интервалов: " + range1.getIntersection(range2));

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединение интервалов: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность интервалов: " + Arrays.toString(difference));
    }
}