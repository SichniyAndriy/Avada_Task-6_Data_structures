package main.java.ch_6_unmutable;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List unmodifiableList = Collections.unmodifiableList(Collections.EMPTY_LIST);
        Set unmodifiabledSet = Collections.unmodifiableSet(Collections.EMPTY_SET);

        List copyOfList = List.copyOf(unmodifiableList);
        Set copyOfSet = Set.copyOf(unmodifiabledSet);
    }
}
