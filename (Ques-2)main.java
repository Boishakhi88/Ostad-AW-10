// Base class
abstract class Shape {
    abstract void draw();
    abstract double calculateArea();
}

// Subclass Circle
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Subclass Square
class Square extends Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }

    @Override
    double calculateArea() {
        return side * side;
    }
}

// Subclass Triangle
class Triangle extends Shape {
    private double base;
    private double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

// Main class to test the shapes
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 6);

        circle.draw();
        System.out.println("Area of Circle: " + circle.calculateArea());

        square.draw();
        System.out.println("Area of Square: " + square.calculateArea());

        triangle.draw();
        System.out.println("Area of Triangle: " + triangle.calculateArea());
   }
}
