package ru.academits.zhurov.shapes;

public class Comparator {

    public static void comparingArea(Shape[] shapes) {
        if (shapes.length == 0) {
            return;
        }

        quickSortArea(shapes, 0, shapes.length - 1);
    }

    public static void comparingPerimeter(Shape[] shapes) {
        if (shapes.length == 0) {
            return;
        }

        quickSortPerimeter(shapes, 0, shapes.length - 1);
    }

    public static void comparingWidth(Shape[] shapes) {
        if (shapes.length == 0) {
            return;
        }

        quickSortWidth(shapes, 0, shapes.length - 1);
    }

    private static void quickSortWidth(Shape[] shapes, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        if (right - left == 1) {
            if (shapes[left].getWidth() > shapes[right].getWidth()) {
                changeArrayElements(shapes, left, right);
            }

            return;
        }

        double supportElement = (shapes[left].getWidth() + shapes[right].getWidth()) / 2;
        int i = left;
        int j = right;

        while (i <= j) {
            while (shapes[i].getWidth() < supportElement) {
                i++;
            }

            while (shapes[j].getWidth() > supportElement) {
                j--;
            }

            if (i <= j) {
                changeArrayElements(shapes, i, j);
                i++;
                j--;
            }
        }

        if (i < right) {
            quickSortWidth(shapes, i, right);
        }

        if (j > left) {
            quickSortWidth(shapes, left, j);
        }
    }

    private static void quickSortArea(Shape[] shapes, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        if (right - left == 1) {
            if (shapes[left].getArea() > shapes[right].getArea()) {
                changeArrayElements(shapes, left, right);
            }

            return;
        }

        double supportElement = (shapes[left].getArea() + shapes[right].getArea()) / 2;
        int i = left;
        int j = right;

        while (i <= j) {
            while (shapes[i].getArea() < supportElement) {
                i++;
            }

            while (shapes[j].getArea() > supportElement) {
                j--;
            }

            if (i <= j) {
                changeArrayElements(shapes, i, j);
                i++;
                j--;
            }
        }

        if (i < right) {
            quickSortArea(shapes, i, right);
        }

        if (j > left) {
            quickSortArea(shapes, left, j);
        }
    }

    private static void quickSortPerimeter(Shape[] shapes, int left, int right) {
        if (right - left <= 0) {
            return;
        }

        if (right - left == 1) {
            if (shapes[left].getPerimeter() > shapes[right].getPerimeter()) {
                changeArrayElements(shapes, left, right);
            }

            return;
        }

        double supportElement = (shapes[left].getPerimeter() + shapes[right].getPerimeter()) / 2;
        int i = left;
        int j = right;

        while (i <= j) {
            while (shapes[i].getPerimeter() < supportElement) {
                i++;
            }

            while (shapes[j].getPerimeter() > supportElement) {
                j--;
            }

            if (i <= j) {
                changeArrayElements(shapes, i, j);
                i++;
                j--;
            }
        }

        if (i < right) {
            quickSortPerimeter(shapes, i, right);
        }

        if (j > left) {
            quickSortPerimeter(shapes, left, j);
        }
    }

    public static void changeArrayElements(Shape[] shapes, int index1, int index2) {
        Shape temp = shapes[index1];
        shapes[index1] = shapes[index2];
        shapes[index2] = temp;
    }
}
