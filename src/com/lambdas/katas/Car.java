package com.lambdas.katas;

public class Car {
    private final int price;

    public Car(final int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static Car getBetterCar(final Car car1, final Car car2, final TwoArgPredicate<Car> predicate) {
        if (predicate.test(car1, car2)) {
            return car1;
        }
        return car2;
    }

}
