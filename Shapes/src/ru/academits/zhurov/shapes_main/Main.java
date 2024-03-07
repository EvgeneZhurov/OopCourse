package ru.academits.zhurov.shapes_main;

import ru.academits.zhurov.shapes.*;
import ru.academits.zhurov.shapes.comparators.ShapeAreaComparator;
import ru.academits.zhurov.shapes.comparators.ShapePerimeterComparator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(1);
        Square square2 = new Square(500);

        Triangle triangle1 = new Triangle(3000, 0, 0, 0, 0, 4000);
        Triangle triangle2 = new Triangle(0, 12, 0, 0, 0, 5);
        System.out.println(triangle2.getPerimeter());

        System.out.println("Проверка работы компаратора площади: " + triangle1);

        System.out.println("Высота треугольника = " + triangle1.getHeight());
        System.out.println("Ширина треугольника = " + triangle1.getWidth());

        Rectangle rectangle1 = new Rectangle(20, 50);
        Rectangle rectangle2 = new Rectangle(3, 4);

        Circle circle1 = new Circle(7);
        Circle circle2 = new Circle(5);

        Shape[] shapes = {square1, square2, triangle1, triangle2, rectangle1, rectangle2, circle1, circle2};

        System.out.println("Фигура с максимальной площадью: " + getMaxAreaShape(shapes));

        System.out.println(Arrays.toString(shapes));

        System.out.println("Фигура со вторым по максимуму периметром:  " + getSecondMaxPerimeterShape(shapes));
    }

    public static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length == 0) {
            throw new IllegalArgumentException("Передан пустой массив");
        }

        Arrays.sort(shapes, new ShapeAreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes.length < 2) {
            throw new IllegalArgumentException("В массиве меньше двух фигур");
        }

        Arrays.sort(shapes, new ShapePerimeterComparator());

        return shapes[shapes.length - 2];
    }
}