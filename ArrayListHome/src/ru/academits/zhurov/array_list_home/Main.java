package ru.academits.zhurov.array_list_home;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> fileLines = getFileLines("ArrayListHome/src/ru/academits/zhurov/array_list_home/input.html");
            System.out.println("Список строк, прочитанный из файла: " + fileLines);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println(e + "Ошибка при чтении файла");
        }

        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            randomNumbers.add(new Random().nextInt(101));
        }

        System.out.println("Заполненный список: " + randomNumbers);
        removeEvenNumbers(randomNumbers);
        System.out.println("Список без четных чисел: " + randomNumbers);

        List<Integer> integers = new ArrayList<>(5);
        integers.add(1);
        integers.add(5);
        integers.add(2);
        integers.add(3);
        integers.add(5);

        System.out.println("Список: " + integers);
        List<Integer> integersWithoutDuplicates = getListWithoutDuplicates(integers);
        System.out.println("Список без дублей: " + integersWithoutDuplicates);
    }

    public static List<String> getFileLines(String fileName) throws IOException {
        List<String> fileLinesList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String fileLine;

        while ((fileLine = bufferedReader.readLine()) != null) {
            fileLinesList.add(fileLine);
        }

        bufferedReader.close();

        return fileLinesList;
    }

    public static void removeEvenNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
    }

    public static <E> List<E> getListWithoutDuplicates(List<E> list) {
        List<E> listWithoutDuplicates = new ArrayList<>(list.size());

        for (E item : list) {
            if (!listWithoutDuplicates.contains(item)) {
                listWithoutDuplicates.add(item);
            }
        }

        return listWithoutDuplicates;
    }
}

/*
        5. При работе с файлами нужно использовать try with resources.
        Сейчас bufferedReader не закроется в случае ошибки

        8. Сейчас в репозитории не хватает файла .iml, который должен быть в корне проекта.
        Из-за этого проект в IDEA отображается неправильно
*/

