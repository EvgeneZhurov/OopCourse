package ru.academits.zhurov.shapes_main;

import ru.academits.zhurov.comparator.AreaComparator;
import ru.academits.zhurov.comparator.PerimeterComparator;
import ru.academits.zhurov.shapes.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        Square square1 = new Square(1);
        System.out.println(square1.getPerimeter());
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

        Comparator<Shape> comparator = new PerimeterComparator();
        Arrays.sort(shapes, comparator);
        System.out.println(Arrays.toString(shapes));
    }

    public static Shape getMaxAreaShape(Shape[] shapes) throws IOException {
        if (shapes.length == 0) {
            throw new IOException("Передан пустой массив");
        }

        Comparator<Shape> areaComparator = new AreaComparator();
        Arrays.sort(shapes, areaComparator);
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeterShape(Shape[] shapes) throws IOException {
        if (shapes.length < 2) {
            throw new IOException("В массиве меньше двх фигур.");
        }

        Comparator<Shape> perimeterComparator = new PerimeterComparator();
        Arrays.sort(shapes, perimeterComparator);

        return shapes[shapes.length - 2];
    }
}