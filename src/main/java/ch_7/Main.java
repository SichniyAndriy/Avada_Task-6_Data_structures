package main.java.ch_7;

import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    <T> void meth(T t) {

    }

    <W extends CharSequence&Comparable<String>> void  meth2(W word) {
        System.out.println(word);
    }
}

class User <T1 extends Comparable<T1>, T2 extends Number, V> {
    T1 x;
    T2 y;
    V v;

    public User(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    void meth3(List<? extends T1> prod, List<? super T2> cons) {
        cons.add((T2) prod.getFirst());
    }
}


class A<U extends User<T1, T2, V>, T2 extends Number, T1 extends Comparable<T1>, V> {
    U u;
}
