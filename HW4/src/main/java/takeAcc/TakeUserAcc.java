package takeAcc;

import java.sql.Connection;
import java.sql.DriverManager;

import static usersInteractive.UsInteract.fillOrWithdraw;
import static usersInteractive.UsInteract.usersMessage;

public class TakeUserAcc {

    public void withdraw() {

        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:atm.db");
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Do you want fill or withdraw money?");
        System.out.println("Please, enter [F] for Fill, [W] for Withdraw or [E] for Exit.");
        fillOrWithdraw();
    }
}
