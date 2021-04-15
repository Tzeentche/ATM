package usersInteractive;

import addAcc.AddUserAcc;
import fillAcc.FillUserAcc;
import registration.NewUserReg;
import takeAcc.TakeUserAcc;

import java.util.Scanner;

public class UsInteract {

    static Scanner scanner = new Scanner(System.in);
    static NewUserReg newUserReg = new NewUserReg();
    static AddUserAcc addUserAcc = new AddUserAcc();
    static FillUserAcc fillUserAcc = new FillUserAcc();
    static TakeUserAcc takeUserAcc = new TakeUserAcc();

    public static String usersInput() {

        String incoming;
        if (scanner.hasNext()){
            incoming = scanner.next();
        } else {
            System.out.println("You entered wrong symbol. Please, try again.");
            scanner.next();
            incoming = usersInput();
        }
        return incoming;
    }

    public static int usersInt() {

        int variable;
        if (scanner.hasNextInt()){
            variable = scanner.nextInt();
        } else {
            System.out.println("You entered wrong symbol. Please, try again.");
            scanner.next();
            variable = usersInt();
        }
        return variable;
    }

    public static void usersMessage(int income) {

        String result = usersInput();

            if ("Y".equals(result) || "y".equals(result)) {
                System.out.println("You choose was Y");

                switch(income) {
                    case (1):
                        newUserReg.usersRegistration();
                        break;

                    case (2):
                        addUserAcc.accRegistration();
                        break;
                }

            } else if ("N".equals(result) || "n".equals(result)) {
                System.out.println("Good Bye! See you!");

            } else {
                System.out.println("It's seems like unknown symbol. Please, try again next time.");
            }
    }

    public static String usersAdress() {

        String result = usersInput();
        String address = "";

        if ("Y".equals(result) || "y".equals(result)) {
            System.out.println("You choose was Y");
            System.out.println("Please, enter your address:");
            address = usersInput().toString();


        } else if ("N".equals(result) || "n".equals(result)) {
            System.out.println("It's OK!");

        } else {
            System.out.println("It's seems like unknown symbol. Please, try again next time.");
        }

        return address;
    }

    public static void fillOrWithdraw() {

        String result = usersInput();

        if ("F".equals(result) || "f".equals(result)) {
            System.out.println("You choose was Fill.");
            fillUserAcc.fillTheBill();

        } else if ("W".equals(result) || "w".equals(result)) {
            System.out.println("Your choose was Withdraw.");
            takeUserAcc.withdraw();

        } else if ("E".equals(result) || "e".equals(result)) {

            System.exit(0);

        } else {
            System.out.println("It's seems like unknown symbol. Please, try again next time.");
        }
    }


}
