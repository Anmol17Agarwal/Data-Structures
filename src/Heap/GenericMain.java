package Heap;

import Interface.Compareable.Car;

public class GenericMain {
    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car(1100, 100840, "Red");
        cars[1] = new Car(500, 20580, "Blue");
        cars[2] = new Car(300, 3000, "Black");
        cars[3] = new Car(40, 5486400, "White");
        cars[4] = new Car(150, 554000, "Yellow");

        GenericHeap<Car> heap = new GenericHeap<Car>();
        heap.add(cars[0]);
        heap.display();
        heap.add(cars[1]);
        heap.display();
        heap.add(cars[2]);
        heap.display();
        heap.add(cars[3]);
        heap.display();
        heap.add(cars[4]);
        heap.display();

    }
}
