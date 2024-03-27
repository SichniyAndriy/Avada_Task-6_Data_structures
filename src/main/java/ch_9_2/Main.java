package main.java.ch_9_2;

import java.util.concurrent.atomic.AtomicInteger;
import main.java.ParkingUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                        Вітаю в програмі ПАРКІНГ 0.2
                        Введіть:
                        стоп - для виходу з програми
                        список - для виводу всіх померів
                        номер - для збереження в базі
                        номер + цифра - для збереження номера по індексу""");

        while (true) {
            System.out.print("Введіть команду: ");
            String s = ParkingUtil.scan.nextLine().trim().toUpperCase();
            resolve(s);
        }
    }

    public static void resolve(String s) {
        if (s.matches("^[A-Z]{2}\\d{4}[A-Z]{2}$")) {
            System.out.print("Введіть індекс: ");
            int nextInt = ParkingUtil.scan.nextInt();
            ParkingUtil.scan.nextLine();
            if (nextInt > ParkingUtil.numberList.size()) {
                ParkingUtil.numberList.add(s);
            } else {
                ParkingUtil.numberList.add(nextInt - 1, s);
            }
        } else {
            switch (s) {
                case "СПИСОК", "LIST" -> {
                    AtomicInteger i = new AtomicInteger();
                    ParkingUtil.numberList.forEach(el -> System.out.println(i.incrementAndGet() + " " + el));
                }
                case "СТОП", "STOP" -> {
                    ParkingUtil.scan.close();
                    System.exit(0);
                }
                default -> System.out.println("Невідома команда. Перевірте ввод");
            }
        }
    }
}
