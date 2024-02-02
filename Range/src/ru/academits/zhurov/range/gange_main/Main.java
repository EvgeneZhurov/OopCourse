package ru.academits.zhurov.range.gange_main;

import ru.academits.zhurov.range.range.Range;

public class Main {
    public static void main(String[] args) {
        Range range = new Range(1, 10);

        System.out.println("Начало диапазона: " + range.getFrom());
        System.out.println("Конец диапазона: " + range.getTo());

        double coordinate = 13.0;

        if (range.isInside(coordinate)) {
            System.out.println("Координата " + coordinate + " принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        } else {
            System.out.println("Координата " + coordinate + " не принадлежит диапазону от " + range.getFrom() + " до " + range.getTo());
        }

        System.out.println("Длина диапазона = " + range.length());

        range.setFrom(5);
        range.setTo(20);

        System.out.println("Длина диапазона после изменения = " + range.length());
    }
}