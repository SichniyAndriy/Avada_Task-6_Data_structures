package main.java.parking_3;

import main.java.ParkingUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                        Вітаю в програмі ПАРКІНГ 0.3
                        Введіть:
                        стоп - для виходу з програми
                        список - для виводу всіх померів
                        сам номер - для збереження в базі""");

        while(true) {
            System.out.print("Введіть команду: ");
            resolveSet(ParkingUtil.scan.nextLine().trim().toUpperCase());
        }
    }

    public static void resolveSet(String s) {
        if (s.matches("^[A-Z]{2}\\d{4}[A-Z]{2}$")) {
            ParkingUtil.numberSet.add(s);
        } else {
            switch (s) {
                case "СПИСОК", "LIST" -> ParkingUtil.numberSet.forEach(System.out::println);
                case "СТОП", "STOP" -> { ParkingUtil.scan.close(); System.exit(0); }
                default -> System.out.println("Невідома команда. Перевірте ввод");
            }
        }
    }
}
