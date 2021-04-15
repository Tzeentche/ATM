import base.BaseManipul;
import usersInteractive.UsInteract;

public class Main {

    public static void main(String[] args) {

//        BaseManipul baseManipul = new BaseManipul();
//        baseManipul.createConnection();
//        baseManipul.createUsers();
//        baseManipul.createAccounts();
//        baseManipul.createTransactions();

        UsInteract usInteract = new UsInteract();

        System.out.println("Dou you want to pass the registration? [Y / N]");

        usInteract.usersMessage(1);
    }
}
