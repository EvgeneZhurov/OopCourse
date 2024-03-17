package ru.academits.zhurov.csv_main;

import ru.academits.zhurov.csv.Csv1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "output.html";
        String absolutPath = "C:\\Users\\admin\\IdeaProjects\\OopCourse\\Csv\\src\\ru\\academits\\zhurov\\input.csv";
        Csv1.convertScv(absolutPath, fileName);
     }
}
    /*
        10. Не нужно использовать StringBuilder для содержимого файлов, оно может быть большим, и не влезать в память.
        Лучше сделать, чтобы программа читала входной файл построчно и потом проходила по строке посимвольно, и сразу же записывала результат в выходной файл.
                При этом лучше обойтись без функций наподобие indexOf и т.д.
        */