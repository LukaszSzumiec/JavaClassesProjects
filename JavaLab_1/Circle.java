package training;

import java.util.Scanner;

public class Circle extends Figure implements Print{
    static final double PI = 3.14;
    private double radius;
    public Circle(){
        this.radius = 0;
    }
    public boolean makeCircle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input radius of circle: ");
        try {
            this.radius = scanner.nextInt();
            if (radius <= 0) throw new IllegalArgumentException();
        }
        catch (Exception e) {
            System.out.println("You passed illegal argument, try again.");
            return false;
        }
        return true;
    }

    @Override
    public double calculateArea() {
        double Area;
        Area = PI * radius * radius;
        return Area;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public void Print() {
        System.out.println("Radius: " + radius);
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
    }
}
