package Interface.Comparator;

public class Car implements Comparable<Car>{

    int speed;
    int price;
    String color;

    public Car(int speed, int price, String color) {
        this.speed = speed;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Car o) {
//        return this.price - o.price;        //ascending order
//        return o.speed - this.speed;        //descending order
        return this.color.compareTo(o.color);       //ascending order
    }
}
