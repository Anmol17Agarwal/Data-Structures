package Heap;

import java.util.ArrayList;

public class GenericHeap<T extends Comparable<T>> {
    ArrayList<T> arr = new ArrayList<>();

    public void add(T data){
        arr.add(data);
        upheapify(arr.size()-1);
    }

    private void upheapify(int ci) {
        int pi = (ci-1)/2;
        if(isLarger(arr.get(ci),arr.get(pi))>0){
            swap(pi,ci);
        }
    }

    private void swap(int i, int j) {
        T ithValue = arr.get(i);
        T jthValue = arr.get(j);
        arr.set(i,jthValue);
        arr.set(j,ithValue);
    }

    private int size(){
        return this.arr.size();
    }

    public boolean isEmpty(){
        return size()==0;
    }
    public void display(){
        System.out.println(arr);
    }

    public T delete(){
        swap(0,arr.size()-1);
        T rv = this.arr.remove(this.arr.size()-1);
        downheapify(0);
        return rv;
    }

    private void downheapify(int pi) {
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        int min = pi;
        if(lci<arr.size() && isLarger(arr.get(lci),arr.get(min))>0){
            swap(lci,min);
        }if(rci<arr.size() && isLarger(arr.get(rci),arr.get(min))>0){
            swap(rci,min);
        }
        if(min!=pi){
            swap(min,pi);
            downheapify(min);
        }
    }

    public T get(){
        return this.arr.get(0);
    }

    //it will return -1 if t is smaller than o and 1 if t is larger than o
    public int isLarger(T t, T o){
        return t.compareTo(o);
    }
}
