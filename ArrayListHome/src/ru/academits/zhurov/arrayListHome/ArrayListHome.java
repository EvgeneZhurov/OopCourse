package ru.academits.zhurov.arrayListHome;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArrayListHome {
    public static List<String> splitFileStringsList(String pathName) {
        List<String> fileStringsList = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
            String fileString;

            while ((fileString = bufferedReader.readLine()) != null) {
                fileStringsList.add(fileString);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }

        return fileStringsList;
    }

    public static List<Integer> getListWithoutEvenNumbers(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }

    public static List<Integer> getListWithoutDuplicates(List<Integer> list) {
        List<Integer> listWithoutDuplicates = new ArrayList<>();

        for (Integer integer : list) {
            if (!listWithoutDuplicates.contains(integer)) {
                listWithoutDuplicates.add(integer);
            }
        }
        return listWithoutDuplicates;
    }
}
