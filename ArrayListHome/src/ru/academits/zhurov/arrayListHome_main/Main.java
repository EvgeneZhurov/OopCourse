package ru.academits.zhurov.arrayListHome_main;

import java.util.ArrayList;
import java.util.List;

import static ru.academits.zhurov.arrayListHome.ArrayListHome.*;

public class Main {
    public static void main(String[] args) {
        List<String> fileStringsList = splitFileStringsList("ArrayListHome/src/ru/academits/zhurov/arrayListHome/input.html");
        System.out.println("Список строк, прочитанный из файла: " + fileStringsList);

        List<Integer> randomNumbersList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            randomNumbersList.add((int) (Math.random() * 100) + 1);
        }

        System.out.println("Заполненный список: " + randomNumbersList);
        getListWithoutEvenNumbers(randomNumbersList);
        System.out.println("Список без четных чисел: " + randomNumbersList);

        List<Integer> integerList = new ArrayList<>(5);
        integerList.add(1);
        integerList.add(5);
        integerList.add(2);
        integerList.add(3);
        integerList.add(5);

        List<Integer> listWithoutDuplicates = getListWithoutDuplicates(integerList);
        System.out.println("Список без дублей: " + listWithoutDuplicates);
    }
}