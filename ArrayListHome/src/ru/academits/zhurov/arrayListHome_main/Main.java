package ru.academits.zhurov.arrayListHome_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> fileReader = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("ArrayListHome/src/ru/academits/zhurov/arrayListHome/input.html"))) {
            while (scanner.hasNextLine()) {
                fileReader.add(scanner.nextLine());
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

        /*
        1. http://joxi.ru/29yZ7P8sjB5gz2 - сейчас модуль ArrayListHome в репозитории не настроен как модуль.
        Возможно, в репозиторий не внесены изменения в файлах из папки .idea
        В текущем варианте файл modules.xml не содержит настройки ArrayListHome.
        Нужно запушить текущие изменения в репозиторий, либо, если не получится, вручную поменять modules.xml и запушить изменения

        2. Пакет ru.academits.zhurov - сейчас имя пакета не содержит название задачи

        3. Лучше каждую подзадачу оформить в виде отдельной функции

        4. list - нужно дать более информативное имя, чтобы было понятно что именно хранит переменная

        5. fileReader - имя неправильное, т.к. это не Reader, а список строк файла

        6. Плохо печатать пользователю стек вызовов в случае ошибки.
        Лучше распечатать информативное сообщение

        7. "Чтение из файла: " - неинформативное сообщение

        8. Для последней подзадачи лучше сделать отдельную переменную для списка

        9. В последней подзадаче новому списку лучше задать подходящую начальную вместимость

        10. Для чтения строк из файла для эффективности лучше использовать BufferedReader от FileReader вместо Scanner
        */