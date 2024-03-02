package ru.academits.zhurov;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> fileReader = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("ArrayListHome/src/ru/academits/zhurov/input.html"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileReader.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Чтение из файла: " + fileReader);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println("Заполненный список: " + list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        System.out.println("Список без четных чисел: " + list);

        list.clear();
        list = Arrays.asList(1, 5, 1, 2, 3, 5);
        List<Integer> listWithoutDuplicates = new ArrayList<>();

        for (Integer integer : list) {
            if (!listWithoutDuplicates.contains(integer)) {
                listWithoutDuplicates.add(integer);
            }
        }

        System.out.println("Список без дублей: " + listWithoutDuplicates);
    }
}
