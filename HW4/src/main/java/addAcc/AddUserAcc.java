package addAcc;

import registration.NewUserReg;
import usersInteractive.UsInteract;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import static registration.NewUserReg.DBDriver;
import static registration.NewUserReg.DBUrl;
import static registration.NewUserReg.*;
import static usersInteractive.UsInteract.*;

public class AddUserAcc {

    Connection co;
    String userName;
    String[] currencies = {"BYN", "USD", "RUB", "EUR"};

    public void accRegistration() {

        userName = getName();
        String rsOne = "";
        try {

            Class.forName(DBDriver);
            co = DriverManager.getConnection(DBUrl);
            System.out.println("ConnectedAcc");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Acc registration crashed!");
        }

        try (Statement statement = co.createStatement();) {
            System.out.println("GetName = " + userName);
            String query1 = "SELECT UserId FROM Users WHERE name = '" + userName + "' ";
            System.out.println("Query1 = " + query1);
            ResultSet rs1 = statement.executeQuery(query1);
            while (rs1.next()) {
                rsOne = rs1.getString(1);
            }

            System.out.println("rs1= " + rsOne);

            for (String s : currencies) {

                String query2 = "INSERT INTO Accounts (userId, balance, currency) " +
                        "VALUES ('" + rsOne + "', '" + 0 + "', '" + s + "')";

                int rs2 = statement.executeUpdate(query2);
                System.out.println("rs2= " + s);
//                rs2.close();
            }

            System.out.println("All is correct!");

            rs1.close();

        } catch (Exception e) {

            System.out.println("Mistake:");
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

        questing();
    }

    public static void questing() {
        System.out.println("Do you want fill or withdraw money?");
        System.out.println("Please, enter [F] for Fill, [W] for Withdraw or [E] for Exit.");
        fillOrWithdraw();
    }
}
