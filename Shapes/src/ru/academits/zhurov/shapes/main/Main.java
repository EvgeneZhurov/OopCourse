package ru.academits.zhurov.shapes.main;

import ru.academits.zhurov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(1);
        Square square2 = new Square(5);

        Triangle triangle1 = new Triangle(0, 3, 0, 0, 0, 4);
        Triangle triangle2 = new Triangle(0, 12, 0, 0, 0, 5);

        System.out.println("Высота треугольника = " + triangle1.getHeight());
        System.out.println("Ширина треугольника = " + triangle1.getWidth());

        Rectangle rectangle1 = new Rectangle(20, 50);
        Rectangle rectangle2 = new Rectangle(3, 4);

        Circle circle1 = new Circle(7);
        Circle circle2 = new Circle(5);

        Shape[] shapes = new Shape[]{square1, square2, triangle1, triangle2, rectangle1, rectangle2, circle1, circle2};

        System.out.println("Максимальная площадь из массива фигур = " + getMaxArea(shapes));
        System.out.println("Периметр второй по величине фигуры = " + getSecondMaxPerimeter(shapes));
        System.out.println(triangle1);
    }

    public static double getMaxArea(Shape[] shapes) {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getArea));
        return shapes[shapes.length - 1].getArea();
    }

    public static double getSecondMaxPerimeter(Shape[] shapes) {
        Arrays.sort(shapes, Comparator.comparingDouble(Shape::getPerimeter));
        return shapes[shapes.length - 2].getArea();
    }
}
