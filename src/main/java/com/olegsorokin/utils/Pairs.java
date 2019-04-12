package main.java.com.olegsorokin.utils;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    public static <A, B> ArrayList<B> getSecondForFirst(A first, List<Pair<A, B>> pairs) {
        ArrayList<B> result = new ArrayList<>();
        for (final Pair<A, B> pair : pairs) {
            if (pair.getFirst() == first) {
                result.add(pair.getSecond());
            }
        }
        return result;
    }

    public static <A, B> ArrayList<A> getFirstForSecond(B second, List<Pair<A, B>> pairs) {
        ArrayList<A> result = new ArrayList<>();
        for (final Pair<A, B> pair : pairs) {
            if (pair.getSecond() == second) {
                result.add(pair.getFirst());
            }
        }
        return result;
    }
    
    public static <A> Integer indexOfInBoth(A element, List<Pair<A, A>> pairs) {
    	for (int i = 0; i < pairs.size(); i++) {
    		if (pairs.get(i).getFirst().equals(element) || pairs.get(i).getSecond().equals(element)) {
    			return i;
    		}
    	}
    	return -1;
    }
}
