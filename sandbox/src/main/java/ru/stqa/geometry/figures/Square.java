package ru.stqa.geometry.figures;

public record Square(double side) {

    public Square {
        if (side < 0) {
            throw new IllegalArgumentException("Square side should be non-negative");
        }
    }

    public static void printSquareArea(Square s) {
         String text = String.format("Площадь квадрата со стороной %f = %f", s.side, s.area());
         System.out.println(text);
    }

    public static void printPerimeter(Square s) {
        System.out.printf("Периметр квадрата со стороной %f = %f%n", s.side, s.perimeter());
    }

    public double area() {
        return this.side * this.side;
    }

    public double perimeter() {
        return this.side * 4;
    }
}
