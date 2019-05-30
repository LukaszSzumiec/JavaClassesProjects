package training;

import java.util.Scanner;

public class Square extends Figure implements Print {
    double side;

    public boolean makeSquare() {
        try {
            System.out.print("Input length of the side of Square: ");
            Scanner scanner = new Scanner(System.in);
            side = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("You passed illegal argument, try again.");
            return false;
        }
        return true;
    }

    @Override
    public double calculateArea() {
        double Area;
        Area = side * side;
        return Area;
    }

    @Override
    public double calculatePerimeter() {
        return side*4;
    }



    @Override
    public void Print() {
        System.out.println("Figure type: Square");
        System.out.println("Length of side: " + side);
        System.out.println("Area of figure: " + calculateArea());
        System.out.println("Perimeter of figure " + calculatePerimeter());
    }
}
