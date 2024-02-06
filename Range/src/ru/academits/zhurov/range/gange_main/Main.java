package ru.academits.zhurov.range.gange_main;

import ru.academits.zhurov.range.range.Range;

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

        System.out.println("Длина диапазона = " + range1.length());

        range1.setFrom(5);
        range1.setTo(9);

        System.out.println("Длина диапазона после изменения = " + range1.length());

        Range range2 = new Range(6, 20);

        try {
            double from = range1.getIntersection(range2).getFrom();
            double to = range1.getIntersection(range2).getTo();
            System.out.println("Пересечение интервалов: от " + from + " до " + to);
        } catch (NullPointerException e) {
            System.out.println("Пересечений нет");
        }

        Range[] ranges = range1.getUnification(range2);

        if (ranges.length == 0) {
            System.out.println("Объединений нет");
        } else if (ranges.length == 1) {
            System.out.println("Объединение интервалов: от " + ranges[0].getFrom() + " до " + ranges[0].getTo());
        } else {
            System.out.println("Объединение интервалов: от " + ranges[0].getFrom() + " до " + ranges[0].getTo() +
                    " и от " + ranges[1].getFrom() + " до " + ranges[1].getTo());
        }


    }
}