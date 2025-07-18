package Heap;

import java.util.ArrayList;


public class Heap {

    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data){
        arr.add(data);
        upheapify(arr.size()-1);
    }

    private void upheapify(int ci) {
        int pi = (ci-1)/2;
        if(arr.get(ci)<arr.get(pi)){
            swap(pi,ci);
        }
    }

    private void swap(int i, int j) {
        int ithValue = arr.get(i);
        int jthValue = arr.get(j);
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

    public int delete(){
        swap(0,arr.size()-1);
        int rv = this.arr.remove(this.arr.size()-1);
        downheapify(0);
        return rv;
    }

    private void downheapify(int pi) {
        int lci = 2*pi+1;
        int rci = 2*pi+2;
        int min = pi;
        if(lci<arr.size() && arr.get(lci)<arr.get(min)){
            swap(lci,min);
        }if(rci<arr.size() && arr.get(rci)<arr.get(min)){
            swap(rci,min);
        }
        if(min!=pi){
            swap(min,pi);
            downheapify(min);
        }
        }

    public int get(){
        return this.arr.get(0);
    }
    }

