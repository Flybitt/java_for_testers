package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void calcPerimeter() {
        Assertions.assertEquals(12, new Triangle(3.0,4.0,5.0).perimeter());
    }

    @Test
    void calcArea() {
        Assertions.assertEquals(6, new Triangle(3.0,4.0,5.0).area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-3,4,6);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }

    @Test
    void sumTwoSidesMustNotBeLessThird() {
        try {
            new Triangle(1,3,5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
        try {
            new Triangle(3, 1, 5);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
        try {
            new Triangle(5, 1, 3);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {

        }
    }
}
