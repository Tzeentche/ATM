package takeAcc;

import addAcc.AddUserAcc;
import registration.NewUserReg;

import addAcc.AddUserAcc;
import registration.NewUserReg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static registration.NewUserReg.DBDriver;
import static registration.NewUserReg.DBUrl;
import static usersInteractive.UsInteract.*;

public class TakeUserAcc {

    NewUserReg newUserReg = new NewUserReg();
    String userName = newUserReg.getName();
    Connection co;
    AddUserAcc addUserAcc = new AddUserAcc();

    public void substractor() {

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

        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:atm.db");
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Which currency do you want fill?");
        System.out.println("Please, enter [1] for BYN, [2] for USD, [3] for RUB and [4] for EUR.");
        curreciesExtract();
    }


    public void withdraw(int entrance, int summ) {

        int cash = summ;
        String curr = "";

        if (entrance == 1) {

            curr = "BYN";
        } else if (entrance == 2) {

            curr = "USD";
        } else if (entrance == 3) {

            curr = "RUB";
        } else if (entrance == 4) {

            curr = "EUR";
        } else {


        }

        try (Statement statement = co.createStatement();) {

            String query1 = "SELECT UserId FROM Users WHERE name = '" + userName + "' ";
            ResultSet rs1 = statement.executeQuery(query1);
            System.out.println("rs1 = " + rs1);

            String query2 = "SELECT accountId FROM Accounts WHERE userId = '" + rs1 + "' ";
            ResultSet rs2 = statement.executeQuery(query2);
            System.out.println("rs2 = " + rs2);

            String query3 = "SELECT balance FROM Accounts WHERE userId = '" + rs1 + "' AND currency = '" + curr + "'";
            ResultSet rs3 = statement.executeQuery(query3);
            System.out.println("rs3 = " + rs3);
            int pars = Integer.parseInt(String.valueOf(rs3));
            cash = cash - pars;

            if(cash > 0) {
                String query4 = "INSERT INTO Account (balance) VALUES ('" + cash + "') WHERE accountId = '" + rs2 + "' " +
                        "AND currency = '" + curr + "' ";

                ResultSet rs4 = statement.executeQuery(query4);
                System.out.println("rs4 = " + rs4);
                rs4.close();

            } else {
                System.out.println("Your haven't enough money. Please, keep calm and carry on!");
                AddUserAcc addUserAcc = new AddUserAcc();
                addUserAcc.accRegistration();
            }

            rs1.close();
            rs2.close();
            rs3.close();

        } catch(Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Withdrawing crashed!");
        }
    }
}
