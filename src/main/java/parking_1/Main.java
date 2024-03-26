package main.java.parking_1;

import main.java.ParkingUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                        Вітаю в програмі ПАРКІНГ 0.1
                        Введіть:
                        стоп - для виходу з програми
                        список - для виводу всіх померів
                        сам номер - для збереження в базі""");

        while(true) {
            System.out.print("Введіть команду: ");
            resolver(ParkingUtil.scan.nextLine().trim().toUpperCase());
        }
    }

    public static void resolver(String s) {
        if (s.matches("^[A-Z]{2}\\d{4}[A-Z]{2}$")) {
            ParkingUtil.numberList.add(s);
        } else {
            switch (s) {
                case "СПИСОК", "LIST" -> ParkingUtil.numberList.forEach(System.out::println);
                case "СТОП", "STOP" -> { ParkingUtil.scan.close(); System.exit(0); }
                default -> System.out.println("Невідома команда. Перевірте ввод");
            }
        }
    }
}
