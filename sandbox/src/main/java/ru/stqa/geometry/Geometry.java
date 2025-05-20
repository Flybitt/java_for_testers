package ru.stqa.geometry;

import ru.stqa.geometry.figures.Rectangle;
import ru.stqa.geometry.figures.Square;
import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
//        Square.printSquareArea(new Square(7.0));
//        Square.printSquareArea(new Square(5.0));
//        Square.printSquareArea(new Square(3.0));
//
//        Rectangle.printRectangleArea(3.0, 5.0);
//        Rectangle.printRectangleArea(5.0, 6.0);
//        Rectangle.printRectangleArea(7.0, 8.0);
//
//        Triangle.printTriangleArea(new Triangle(3.0, 4.0, 5.0));
//        Triangle.printTriangleArea(new Triangle(3.0, 3.0, 4.0));
//        Triangle.printTriangleArea(new Triangle(12.0, 56.0, 53.0));

        var squares = List.of(new Square(7.0), new Square(5.0), new Square(3.0));
        Consumer<Square> print = Square::printSquareArea;
        squares.forEach(print);
    }

}
