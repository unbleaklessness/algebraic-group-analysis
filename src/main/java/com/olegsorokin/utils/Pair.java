package main.java.com.olegsorokin.utils;

public class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public void print() {
        System.out.print("(");
        System.out.print(first);
        System.out.print(" ");
        System.out.print(second);
        System.out.print(")");
    }

    public void println() {
        print();
        System.out.println();
    }
}
