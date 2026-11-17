package cz.vsb.fei.batteries;

import java.util.HashSet;
import java.util.Set;

public class UniqueHeap<T>{
    private Set<T> items = new HashSet<>();
    private int count;

    public void add(T item){
        count++;
        items.add(item);
    }

    public int getCount(){
        return count;
    }

    public Set<T> grabAll(){
        Set<T> returnSet = new HashSet<>(items);
        count = 0;
        items.clear();
        return returnSet;
    }
}