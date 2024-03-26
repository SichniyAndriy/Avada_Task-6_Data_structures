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
            ParkingUtil.resolver(ParkingUtil.scan.nextLine().trim().toUpperCase());
        }
    }
}
