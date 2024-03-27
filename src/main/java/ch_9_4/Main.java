package main.java.ch_9_4;

import main.java.ParkingUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                        Вітаю в програмі ПАРКІНГ 0.3
                        Введіть:
                        стоп - для виходу з програми
                        список - для виводу всіх номерів та власників
                        авто - для виводу всіх номерів
                        власники - для виводу всіх власників
                        сам номер - для збереження в базі""");

        while(true) {
            System.out.print("Введіть команду: ");
            resolve(ParkingUtil.scan.nextLine().trim().toUpperCase());
        }
    }

    public static void resolve(String s) {
        if (s.matches("^[A-Z]{2}\\d{4}[A-Z]{2}$")) {
            System.out.print("Введіть ім'я власника: ");
            String name = ParkingUtil.scan.nextLine();
            ParkingUtil.numberMap.put(s,name);
        } else {
            switch (s) {
                case "СПИСОК", "LIST" -> ParkingUtil.numberMap.forEach((k, v) -> System.out.println(k + " - " + v) );
                case "АВТО", "AUTOS" -> ParkingUtil.numberMap.keySet().forEach(System.out::println);
                case "ВЛАСНИКИ", "OWNERS" -> ParkingUtil.numberMap.values().forEach(System.out::println);
                case "СТОП", "STOP" -> { ParkingUtil.scan.close(); System.exit(0); }
                default -> System.out.println("Невідома команда. Перевірте ввод");
            }
        }
    }
}
