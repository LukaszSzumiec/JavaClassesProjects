package training;

import java.util.Scanner;
import static java.lang.Math.*;
public class Triangle extends Figure implements Print {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(){
        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
    }


    public boolean makeTriangle(){

        Scanner scanner = new Scanner(System.in);
      /*
        System.out.println("Input 3 sides: ");
        String _set = scanner.nextLine();
        int set = Integer.parseInt(_set);

        if(set < 0 || set > 2) {
            throw new IllegalArgumentException();
        }

        switch(set) {
            case 1:
                System.out.print("Input first side: ");
                this.sideA = scanner.nextInt();
                System.out.print("Input first high parpaticular to first side: ");
                this.highA = scanner.nextInt();
                break;

            case 2:
                */
        try {
            System.out.print("Input first side: ");
            this.sideA = scanner.nextInt();
            System.out.print("Input second side: ");
            this.sideB = scanner.nextInt();
            System.out.print("Input third side: ");
            this.sideC = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("You passed illegal argument, try again.");
            return false;
        }

        this.sortSides();

        if(!this.checkIfTriangle()) return false;

            return true;
        //}
    }

    private boolean checkIfTriangle() {
        try {
            double sum;
            sum = sideB + sideC;
            if(sum < sideA){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException il) {
            System.out.println("Sum of two sides is smaller than longest side, that is not a triangle.");
            return false;
        }
        return true;
    }

    private void sortSides() {
        if(sideB > sideA) {
            double temp = sideA;
            sideA = sideB;
            sideB = temp;
        }
        if(sideC > sideA){
            double temp = sideA;
            sideA = sideC;
            sideC = temp;
        }
    }


    @Override
    public double calculateArea() {
        double Area;
            double p;
            p = sideA + sideB + sideC;
            p = p / 2;
            final double t = p;
            System.out.println(t);
            double temp = t - sideA;
            double temp2 = t - sideB;
            double temp3 = t - sideC;
            Area = temp * temp2 * temp3 * t;
            Area = sqrt(Area);
            return Area;
    }

    @Override
    public double calculatePerimeter() {
        double Perimeter;
        Perimeter = sideA + sideC + sideB;
        return Perimeter;
    }

    @Override
    public void Print() {
                System.out.println("First side: " + sideA);

                System.out.println("Second side: " + sideB);

                System.out.println("Third side: " + sideC);

                System.out.println("Area: " + calculateArea());

                System.out.println("Perimiter: " + calculatePerimeter());
    }
}
