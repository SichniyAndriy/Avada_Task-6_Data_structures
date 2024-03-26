package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ParkingUtil {
    public final static List<String> numberList = new ArrayList<>();
    public final  static Set<String> numberSet = new HashSet<>();
    public final static Scanner scan = new Scanner(System.in);

    static {
        numberList.add("JF8854LK");
        numberList.add("DD3454OK");
        numberList.add("SD5667GG");
        numberList.add("HJ5467FD");
        numberList.add("VB5567JJ");
        numberSet.addAll(numberList);
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
