package addAcc;

import registration.NewUserReg;
import usersInteractive.UsInteract;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import static registration.NewUserReg.*;
import static usersInteractive.UsInteract.fillOrWithdraw;

public class AddUserAcc {

    enum Currencies { BYN, USD, RUB, EUR};

    Connection co;
    String account = "";
    UsInteract ui = new UsInteract();
    String valute = "";
    String usersId = "";
    NewUserReg newUserReg = new NewUserReg();
    String userName = newUserReg.getName();
    Currencies[] currencies = Currencies.values();

    public void accRegistration() {

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

        try (Statement statement = co.createStatement();) {
            String query1 = "SELECT UserId FROM Users WHERE name = '"+ userName +"' ";
            ResultSet rs1 = statement.executeQuery(query1);

            for(Currencies s : currencies) {
                String query2 = "INSERT INTO Account (userId, balance, currency) " +
                        "VALUES ('" + rs1 + "', '" + 0 + "', '" + currencies + "')";

                ResultSet rs2 = statement.executeQuery(query2);
                rs2.close();
            }

            System.out.println("All is correct!");

            rs1.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
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
