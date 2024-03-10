package ru.academits.zhurov.list_main;

import ru.academits.zhurov.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> integerList = new SinglyLinkedList<>();

        integerList.add(0);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println("Размер списка: " + integerList.getSize());
        System.out.println("Значение первого элемента списка: " + integerList.getHeadData());

        System.out.println("Получение элемента списка: " + integerList.getData(1));
        System.out.println("Список: " + integerList);

        System.out.println("Удаление элемента списка по индексу, будет напечатано удаляемое значение: " + integerList.remove(0));
        System.out.println("Список: " + integerList);

        System.out.println("Удаление элемента из списка(если элемента нет, то выдаст false, иначе true): " + integerList.removeFirstOccurrence(10));
        System.out.println("Список, после удаления элемента: " + integerList);

        integerList.add(4, 5);
        System.out.println("Список, после добавления элемента по индексу: " + integerList);

        System.out.println("Удаление первого элемента. Значение удаленного элемента: " + integerList.removeFirstElement());
        System.out.println("Список, после удаления первого элемента: " + integerList);

        integerList.unwrap();
        System.out.println("Разворот списка: " + integerList);

        SinglyLinkedList<Integer> integerListCopy = integerList.copy();
        System.out.println("Копирование списка: " + integerListCopy);
    }
}
