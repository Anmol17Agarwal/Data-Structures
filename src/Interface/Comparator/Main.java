package Interface.Comparator;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car(1100, 100840, "Red");
        cars[1] = new Car(500, 20580, "Blue");
        cars[2] = new Car(300, 3000, "Black");
        cars[3] = new Car(40, 5486400, "White");
        cars[4] = new Car(150, 554000, "Yellow");
        display(cars);
        bubbleSort(cars, new CarPriceComparator());
        display(cars);
        bubbleSort(cars, new CarSpeedComparator());
        display(cars);
        bubbleSort(cars, new CarColorComparator());
        display(cars);
    }

    public static <T> void display(T[] arr){
        for(T t : arr){
            System.out.println(t+" ");
        }
        System.out.println();
    }

    public static <T> void bubbleSort(T[] arr, Comparator<T> c){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(c.compare(arr[j],arr[j+1])>0){
                    T temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
