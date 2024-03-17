package ru.academits.zhurov.arrayList_main;

import ru.academits.zhurov.arrayList.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(0);
        integerArrayList.add(2);
        integerArrayList.add(0);
        integerArrayList.add(3);
        integerArrayList.add(4);
        integerArrayList.add(5);
        integerArrayList.add(6);
        integerArrayList.add(7);
        integerArrayList.add(8);
        integerArrayList.add(1);
        integerArrayList.add(10);

        ArrayList<Integer> integerArrayList1 = new ArrayList<>();

        integerArrayList1.add(0);
        integerArrayList1.add(10);
        integerArrayList1.add(2);

        System.out.println("Проверка корректности работы метода containsAll: " + integerArrayList.containsAll(integerArrayList1));

        System.out.println("Проверка корректности работы метода removeAll: " + integerArrayList.removeAll(integerArrayList1));
        System.out.println("Список: " + integerArrayList);

        integerArrayList.add(0);
        integerArrayList.add(10);
        integerArrayList.add(2);

        System.out.println("Проверка корректности работы метода retainAll: " + integerArrayList.retainAll(integerArrayList1));
        System.out.println("Список: " + integerArrayList);

        integerArrayList.add(2, 1);
        System.out.println("Проверка корректности работы метода removeAll: " + integerArrayList);

        System.out.println(integerArrayList.iterator());
    }
}
