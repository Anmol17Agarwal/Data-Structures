package Interface.Compareable;

public class Main {

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car(1100, 100840, "Red");
        cars[1] = new Car(500, 20580, "Blue");
        cars[2] = new Car(300, 3000, "Black");
        cars[3] = new Car(40, 5486400, "White");
        cars[4] = new Car(150, 554000, "Yellow");
        display(cars);
        bubbleSort(cars);
        display(cars);
    }

    public static <T> void display(T[] arr){
        for(T t : arr){
            System.out.println(t+" ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
