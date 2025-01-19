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
}
