package ru.stqa.geometry.figures;

public record Triangle(
        double a,
        double b,
        double c
) {

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
