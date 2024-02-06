package ru.academits.zhurov.csv.csv_main;

public class Main {
    public static void main(String[] args) {

        //TODO сделать статический метод в классе CSV, который нужно вызвать в Main.
    /*
        3. При чтении строк из файла вместо Scanner лучше использовать BufferedReader от FileReader.
        Это работает быстрее

        4. stringBuilder, sb - неинформативная пара имен, по этим именам не понятно чем отличаются переменные

        7. isAllString - неинформативное имя

        8. deleteCharacters - неинформативное имя, по имени непонятно какие именно символы удаляются

        10. Не нужно использовать StringBuilder для содержимого файлов, оно может быть большим, и не влезать в память.
        Лучше сделать, чтобы программа читала входной файл построчно и потом проходила по строке посимвольно, и сразу же записывала результат в выходной файл.
                При этом лучше обойтись без функций наподобие indexOf и т.д.

        11. Должен создаваться корректный html-документ, содержащий doctype, head, body, meta с кодировкой
        */
    }
}
