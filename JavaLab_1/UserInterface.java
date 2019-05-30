package training;

import java.util.Scanner;


public class UserInterface {

    public static void start() {


        while (true) {
            try {
                System.out.println("Set figure type: \n 1 - Triangle \n 2 - Square \n 3 - Circle \n 4 - Quit");

                Scanner scanner = new Scanner(System.in);

                String set = scanner.nextLine();

                int setFunction;
                setFunction = Integer.parseInt(set);

                if(setFunction < 0 || setFunction > 4) {
                    throw new IllegalArgumentException();
                }
                switch (setFunction) {
                    case 1:
                        Triangle t = new Triangle();
                        boolean check = t.makeTriangle();
                        if(check == true) t.Print();
                        break;
                    case 2:
                        Square s = new Square();
                        check = s.makeSquare();
                        if(check == true) s.Print();
                        break;
                    case 3:
                        Circle c = new Circle();
                        check = c.makeCircle();
                        if(check == true) c.Print();
                        break;
                    case 4:
                        System.out.println("Calculator is closing...");
                        return;
                }

            }
            catch (IllegalArgumentException il){
                System.out.println("You passed illegal argument, try again.");
            }
        }

    }
}