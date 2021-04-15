package addAcc;

import registration.NewUserReg;
import usersInteractive.UsInteract;

import java.sql.Connection;
import java.sql.DriverManager;

import static registration.NewUserReg.*;
import static usersInteractive.UsInteract.fillOrWithdraw;

public class AddUserAcc {

    Connection co;
    String account = "";
    UsInteract ui = new UsInteract();
    String valute = "";

    public void accRegistration() {

        String query1 = "SELECT UserId FROM Users WHERE name = ";
        String userName = "";

        String query2 = "INSERT INTO Account (userId, balance, currency) " +
                "VALUES ('" + userId + "', '" + address + "')";

        try {

            Class.forName(DBDriver);
            co = DriverManager.getConnection(DBUrl);
            System.out.println("Connected1");
            co.close();
            System.out.println("Close connection");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Acc registration crashed!");
        }






        System.out.println("Your account was registered.");
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
