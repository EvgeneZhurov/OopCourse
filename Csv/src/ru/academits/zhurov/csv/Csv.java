package ru.academits.zhurov.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Csv {
    public static void convertScv(String absolutPath, String fileName) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutPath));

        try (PrintStream writer = new PrintStream("output.html")) {
            writer.println("<!DOCTYPE html>");
            writer.println("<html lang = \"ru\" >");
            writer.println("    <head>");
            writer.println("        <meta charset = \"UTF-8\" >");
            writer.println("    </head>");
            writer.println("    <body>");
            writer.println("        <table>");

            String inputString;

            while ((inputString = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(inputString);

                replaceSpecialCharacters(stringBuilder);

                writer.println("          <tr>");

                if (!isLinefeed(stringBuilder)) {
                    //TODO нужно написать корректный код соединяющий переносящиеся строки
                    //TODO Проблемы с  </tr> b обрезает последнюю букву слова "строки"

                    formatRow(stringBuilder, writer, false);
                    writer.println("<br/>");

                    continue;
                }

                formatRow(stringBuilder, writer, true);

                writer.println("          </tr>");
            }

            writer.println("        </table>");
            writer.println("    </body>");
            writer.println("</html>");
        }
    }

    public static void formatRow(StringBuilder stringBuilder, PrintStream writer, boolean isLinefeed) {
        while (stringBuilder.length() > 0) {
            int subStringLength = getLength(stringBuilder);

            StringBuilder builder = new StringBuilder(stringBuilder.substring(0, subStringLength));
            stringBuilder.delete(0, subStringLength);

            if (subStringLength > 0 && builder.charAt(0) == '"') {
                deleteUnnecessaryQuotes(builder);
            }

            writer.println("               <td>" + builder + "</td>");

            if (stringBuilder.length() == 1 && stringBuilder.charAt(0) == ',') {
                writer.println("           <td></td>");
                stringBuilder.delete(0, 1);

                break;
            }

            if (stringBuilder.length() > 0) {
                stringBuilder.delete(0, 1);
            }

            if (subStringLength == 0 && isLinefeed) {
                writer.println("          </tr>");
            }
        }
    }

    public static int getLength(StringBuilder stringBuilder) {
        if (stringBuilder.charAt(0) != '"') {
            int length = stringBuilder.indexOf(",");
            return length == -1 ? stringBuilder.length() : length;
        }

        int quotationMarksQuantity = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '"') {
                quotationMarksQuantity++;
                continue;
            }

            if (quotationMarksQuantity % 2 == 0 && stringBuilder.charAt(i) == ',') {
                return i;
            }
        }

        return stringBuilder.length();
    }

    public static boolean isLinefeed(StringBuilder stringBuilder) {
        int counter = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '"') {
                counter += 1;
            }
        }

        return counter % 2 == 0;
    }

    public static void deleteUnnecessaryQuotes(StringBuilder stringBuilder) {
        stringBuilder.delete(0, 1);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '"') {
                stringBuilder.delete(i, i + 1);
            }
        }
    }

    public static void replaceSpecialCharacters(StringBuilder stringBuilder) {
        for (int i = 0; i < stringBuilder.length(); i++) {
            char symbol = stringBuilder.charAt(i);

            if (symbol == '<') {
                stringBuilder.delete(i, i + 1);
                stringBuilder.insert(i, "&lt;");
            }

            if (symbol == '>') {
                stringBuilder.delete(i, i + 1);
                stringBuilder.insert(i, "&gt;");
            }

            if (symbol == '&') {
                stringBuilder.delete(i, i + 1);
                stringBuilder.insert(i, "&amp;");
            }
        }
    }
}
