package ru.stqa.geometry.figures;

import java.util.Objects;

public record Triangle(
        double a,
        double b,
        double c
) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if ((a + b) < c || (a + c) < b || (b + c) < a) {
            throw new IllegalArgumentException("Sum of two sides must not be less than third side");
        }
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double semiPerimeter() {
        return this.perimeter() / 2;
    }

    public double area() {
        double s = this.semiPerimeter();
        return Math.sqrt(s * (s - this.a) * (s - this.b) * (s - this.c));
    }

    public static void printTriangleArea(Triangle t) {
        String text = String.format("Площадь треугольника со сторонами %f и %f и %f = %f", t.a, t.b, t.c, t.area());
        System.out.println(text);
    }

}
