package parking_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public final static List<String> numbers = new ArrayList<>();
    public final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void resolver(String s) {
        if (s.matches("^[A-Z]{2}\\d{4}[A-Z]{2}$")) {
            numbers.add(s);
        } else {
            switch (s) {
                case "СПИСОК", "LIST" -> numbers.forEach(System.out::println);
                case "СТОП", "STOP" -> { scan.close(); System.exit(0); }
                default -> System.out.println("Невідома команда. Перевірте ввод");
            }
        }
    }
}
