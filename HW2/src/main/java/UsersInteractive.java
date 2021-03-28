import java.util.Scanner;

public class UsersInteractive {

    static Scanner scanner = new Scanner(System.in);
    Operator operator = new Operator();

    public double usersInter() {
        double variable1 = inputVariable();
        double variable2 = inputVariable();
        char operation = chooseOperation();
        double result = operations(variable1, variable2, operation);
        return result;
    }

    public void userOutput() {

        System.out.println("Result is: "+ usersInter());
    }

    public static double inputVariable(){
        System.out.println("Please, enter some variable:");
        double variable;
        if (scanner.hasNextDouble()){
            variable = scanner.nextDouble();
        } else {
            System.out.println("You entered wrong variable. Please, try again.");
            scanner.next();
            variable = inputVariable();
        }
        return variable;
    }

    public static char chooseOperation(){
        System.out.println("Please, enter \"-\", \"+\", \"*\", \"/\" for choosing operation:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("You entered wrong operation. Please, try again.");
            scanner.next();
            operation = chooseOperation();
        }
        return operation;
    }

    public double operations(double variable1, double variable2, char operation) {
        double result;
        switch (operation) {
            case '+':
                result = operator.summ(variable1, variable2);
                break;
            case '-':
                result = operator.minus(variable1, variable2);
                break;
            case '*':
                result = operator.multiply(variable1, variable2);
                break;
            case '/':
                result = operator.divide(variable1, variable2);
                break;
            default:
                System.out.println("It's seems like unknown operation. Please, try again.");
                result = operations(variable1, variable2, operation);
        }
        return result;
    }

}
