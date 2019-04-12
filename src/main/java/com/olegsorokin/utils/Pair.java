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
    
    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;

        if (!(other instanceof Pair<?, ?>)) return false;

        Pair<?, ?> pair = (Pair<?, ?>) other;
        
        return first == pair.first && second == pair.second;
    }
}
