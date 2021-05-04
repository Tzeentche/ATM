package usersInteractive;

import addAcc.AddUserAcc;
import fillAcc.FillUserAcc;
import registration.NewUserReg;
import takeAcc.TakeUserAcc;

import java.util.Scanner;

import static addAcc.AddUserAcc.questing;

public class UsInteract {

    static NewUserReg newUserReg = new NewUserReg();
    static AddUserAcc addUserAcc = new AddUserAcc();
    static FillUserAcc fillUserAcc = new FillUserAcc();
    static TakeUserAcc takeUserAcc = new TakeUserAcc();
    static String result;

    public static String usersInput() {

        Scanner scanner = new Scanner(System.in);

        String incoming;
        if (scanner.hasNextLine()){
            incoming = scanner.nextLine();
        } else {
            System.out.println("You entered wrong STR symbol. Please, try again.");

            incoming = usersInput();
        }
        System.out.println("STR Value is= " + incoming);
        scanner.reset();
//        scanner.close();

        return incoming;
    }

    public static int usersInt() {

        Scanner scanner = new Scanner(System.in);

        int variable;
        if (scanner.hasNextInt()){
            variable = scanner.nextInt();

        } else {
            System.out.println("You entered wrong INT symbol. Please, try again.");

            variable = usersInt();
        }
        System.out.println("INT Value is= " + variable);
        scanner.reset();
//        scanner.close();
        return variable;
    }

    public static double usersDoub() {

        Scanner scanner = new Scanner(System.in);

        double variable;
        if (scanner.hasNextDouble()){
            variable = scanner.nextDouble();

        } else {
            System.out.println("You entered wrong DOUBLE symbol. Please, try again.");

            variable = usersDoub();
        }
        System.out.println("Double Value is= " + variable);
        scanner.reset();
//        scanner.close();
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
                    System.out.println("It's seems like unknown symbole! Please, try again next time.");
                    usersInput();
            }
    }

    public static String usersAdress() {

        String result = usersInput();
        String address = "";

        if ("Y".equals(result) || "y".equals(result)) {
            System.out.println("You choose was Y");
            System.out.println("Please, enter your address:");
            address = usersInput();

        } else if ("N".equals(result) || "n".equals(result)) {
            System.out.println("It's OK!");

        } else {
            System.out.println("It's seems like unknown symbolss. Please, try again next time.");
        }

        System.out.println("Address  UsInteract=" + address);
        return address;
    }

    public static void fillOrWithdraw() {

        result = usersInput();

        if ("F".equals(result) || "f".equals(result)) {
            System.out.println("You choose was Fill.");
            fillUserAcc.fillTheBill();

        } else if ("W".equals(result) || "w".equals(result)) {
            System.out.println("Your choose was Withdraw.");
            takeUserAcc.substractor();

        } else if ("E".equals(result) || "e".equals(result)) {

            System.exit(0);

        } else {
            System.out.println("It's seems like unknown symblom. Please, try again next time.");
            questing();
        }
    }

    public static void curreciesFilling() {

        int inResult = usersInt();
        int inSumm;

        if (inResult > 4 || inResult < 1) {

            System.out.println("You entered wrong value! Try again!");
            inResult = usersInt();

        } else {

            System.out.println("Please, enter your summ, biggest then 0 and less then 100.000.000: ");
            inSumm = usersInt();

            if (inSumm < 1 || inSumm > 100000000) {
                System.out.println("You entered wrong value. Let's try again! ");
                inSumm = usersInt();

            }

            fillUserAcc.filler(inResult, inSumm);
        }
    }

        public static void curreciesExtract() {

            int exResult = usersInt();
            int exSumm;

            if (exResult > 4 || exResult < 1) {

                System.out.println("You entered wrong value! Try again!");
                exResult = usersInt();

            } else {

                System.out.println("Please, enter your summ, biggest then 0 and less then 100.000.000: ");
                exSumm = usersInt();

                if (exSumm < 1 || exSumm > 100000000) {
                    System.out.println("You entered wrong value. Let's try again! ");
                    exSumm = usersInt();

                }

                takeUserAcc.withdraw(exResult, exSumm);
            }
    }
}
