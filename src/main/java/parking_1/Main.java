package parking_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public final static List<String> numbers = new ArrayList<>();
    public final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
                        Вітаю в програмі ПАРКІНГ 0.1
                        Введіть:
                        стоп - для виходу з програми
                        список - для виводу всіх померів
                        сам номер - для збереження в базі""");

        while(true) {
            System.out.print("Введіть команду: ");

            resolver(scan.nextLine().toUpperCase());
        }
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
