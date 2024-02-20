package ru.academits.zhurov.shapes_main;

import ru.academits.zhurov.shapes.*;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(1);
        Square square2 = new Square(500);

        Triangle triangle1 = new Triangle(0, 3000, 0, 0, 0, 4000);
        Triangle triangle2 = new Triangle(0, 12, 0, 0, 0, 5);

        System.out.println("Высота треугольника = " + triangle1.getHeight());
        System.out.println("Ширина треугольника = " + triangle1.getWidth());

        Rectangle rectangle1 = new Rectangle(20, 50);
        Rectangle rectangle2 = new Rectangle(3, 4);

        Circle circle1 = new Circle(7);
        Circle circle2 = new Circle(5);

        Shape[] shapes = {square1, square2, triangle1, triangle2, rectangle1, rectangle2, circle1, circle2};

        if (shapes.length > 0) {
            System.out.println("Фигура с максимальной площадью: " + getMaxArea(shapes));
        } else {
            System.out.println("Нет фигур внутри массива.");
        }

        if (shapes.length > 1) {
            System.out.println("Фигура со вторым по максимуму по периметром:  " + getSecondMaxPerimeter(shapes));
        } else {
            System.out.println("В массиве меньше двх фигур.");
        }
        System.out.println(triangle1);
    }

    public static Shape getMaxArea(Shape[] shapes) {
        Comparator.comparingArea(shapes);
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondMaxPerimeter(Shape[] shapes) {
        Comparator.comparingPerimeter(shapes);
        return shapes[shapes.length - 2];
    }
}
