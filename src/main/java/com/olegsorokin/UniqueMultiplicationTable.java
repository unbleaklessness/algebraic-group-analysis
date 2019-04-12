package main.java.com.olegsorokin;

import java.util.ArrayList;
import java.util.List;

import main.java.com.olegsorokin.interfaces.IMultiplicator;
import main.java.com.olegsorokin.utils.Pair;
import main.java.com.olegsorokin.utils.Pairs;

public class UniqueMultiplicationTable {
	private int[][] table;
    private int size;

    public <T> UniqueMultiplicationTable(final List<T> elements, final IMultiplicator<T> multiplicator, final T identity2) {
        ArrayList<Pair<T, T>> equivalentMatrices = new ArrayList<>();
        
        ArrayList<T> banned = new ArrayList<>();
        for (T element : elements) {
        	T equivalent = multiplicator.multiply(element, identity2);
            
            if (banned.contains(element) || banned.contains(equivalent)) {
            	continue;
            }
            banned.add(element);
            banned.add(equivalent);
            
            equivalentMatrices.add(new Pair<>(element, equivalent));
        }
        
        size = equivalentMatrices.size();
        table = new int[size][size];
        
        
	    for (int i = 0; i < equivalentMatrices.size(); i++) {
		    for (int j = 0; j < equivalentMatrices.size(); j++) {
		    	T result = multiplicator.multiply(equivalentMatrices.get(i).getFirst(), equivalentMatrices.get(j).getFirst());
		    	table[i][j] = Pairs.indexOfInBoth(result, equivalentMatrices);
		    }
		}
    }
    
    public ArrayList<Pair<Integer, Integer>> getCommutative() {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == table[j][i]) {
                    result.add(new Pair<>(i, j));
                }
            }
        }
        return result;
    }
    
    public ArrayList<Integer> getCenter() {
        ArrayList<Integer> result = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	if (!(table[i][j] == table[j][i])) {
                    flag = false;
                }
            }
            if (flag) {
                result.add(i);
            }
            flag = true;
        }
        return result;
    }
}
