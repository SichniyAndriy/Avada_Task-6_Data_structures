package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ParkingUtil {
    public final static List<String> numberList = new ArrayList<>();
    public final static Set<String> numberSet = new HashSet<>();
    public final static Scanner scan = new Scanner(System.in);

    static {
        numberList.add("JF8854LK");
        numberList.add("DD3454OK");
        numberList.add("SD5667GG");
        numberList.add("HJ5467FD");
        numberList.add("VB5567JJ");
    }

    static {
        numberSet.add("JF8854LK");
        numberSet.add("DD3454OK");
        numberSet.add("SD5667GG");
        numberSet.add("HJ5467FD");
        numberSet.add("VB5567JJ");
    }
}
