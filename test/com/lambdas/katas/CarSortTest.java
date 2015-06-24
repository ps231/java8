package com.lambdas.katas;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarSortTest {

    private static TwoArgPredicate<Car> CHEAPER_PRICE_PREDICATE = (c1, c2) -> c1.getPrice() < c2.getPrice();

    private Car car1;
    private Car car2;

    @Before
    public void setup() {
        car1 = new Car(1000);
        car2 = new Car(2000);
    }

    @Test
    public void shouldReturnTheCheaperCar() {
        final Car actualCar = Car.getBetterCar(car1, car2, CHEAPER_PRICE_PREDICATE);
        assertCars(actualCar, car1);
    }

    @Test
    public void shouldReturnTheExpensiveCar() {
        final Car actualCar = Car.getBetterCar(car1, car2, (c1, c2) -> c1.getPrice() > c2.getPrice());
        assertCars(actualCar, car2);
    }

    private void assertCars(final Car actual, final Car expected) {
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }
}
