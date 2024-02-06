package ru.academits.zhurov.csv.csv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Csv {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\admin\\IdeaProjects\\OopCourse\\Csv\\src\\ru\\academits\\zhurov\\csv\\input.csv"));
             PrintWriter writer = new PrintWriter("output.html")) {

            writer.println("<!DOCTYPE html>");
            writer.println("<html lang = \"ru\" >");
            writer.println("    <head>");
            writer.println("        <meta charset = \"UTF-8\" >");
            writer.println("    </head>");
            writer.println("    <body>");
            writer.println("        <table>");

            while (scanner.hasNextLine()) {
                StringBuilder sb = new StringBuilder();
                StringBuilder stringBuilder = new StringBuilder();

                replaceSpecialCharacters(stringBuilder.append(scanner.nextLine()));
                sb.append(stringBuilder);

                stringBuilder.delete(0, stringBuilder.length());

                while (!isAllString(sb)) {
                    sb.append("<br/>");

                    replaceSpecialCharacters(stringBuilder.append(scanner.nextLine()));
                    sb.append(stringBuilder);
                }

                formatRow(sb, writer);
            }

            writer.println("        </table>");
            writer.println("    </body>");
            writer.println("</html>");
        }
    }

    public static void formatRow(StringBuilder sb, PrintWriter writer) {
        writer.println("          <tr>");

        while (sb.length() > 0) {
            int subStringLength = getLength(sb);

            StringBuilder stringBuilder = new StringBuilder(sb.substring(0, subStringLength));
            sb.delete(0, subStringLength);

            if (subStringLength > 0 && stringBuilder.charAt(0) == '"') {
                deleteCharacters(stringBuilder);
            }

            writer.println("        <td>" + stringBuilder + "</td>");

            if (sb.length() == 1 && sb.charAt(0) == ',') {
                writer.println("        <td></td>");
                sb.delete(0, 1);
                break;
            }

            if (sb.length() > 0) {
                sb.delete(0, 1);
            }
        }

        writer.println("           </tr>");
    }

    public static int getLength(StringBuilder sb) {
        if (sb.charAt(0) != '"') {
            int length = sb.indexOf(",");
            return length == -1 ? sb.length() : length;
        }

        int quotationMarksQuantity = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '"') {
                quotationMarksQuantity++;
                continue;
            }

            if (quotationMarksQuantity % 2 == 0 && sb.charAt(i) == ',') {
                return i;
            }
        }

        return sb.length();
    }

    public static boolean isAllString(StringBuilder sb) {
        int counter = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '"') {
                counter += 1;
            }
        }

        return counter % 2 == 0;
    }

    public static void deleteCharacters(StringBuilder sb) {
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '"') {
                sb.delete(i, i + 1);
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
