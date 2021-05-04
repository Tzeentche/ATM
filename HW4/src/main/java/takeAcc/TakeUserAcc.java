package takeAcc;

import addAcc.AddUserAcc;
import registration.NewUserReg;

import java.sql.*;

import static addAcc.AddUserAcc.*;
import static registration.NewUserReg.*;
import static usersInteractive.UsInteract.*;
import static transactions.Transactions.*;

public class TakeUserAcc {

//    NewUserReg newUserReg = new NewUserReg();
    String userName;
    Connection co;
    String rsOne = "", rsTwo = "", rsThree = "", rsFour = "";

    public void substractor() {

        userName = getName();

        try {

            Class.forName(DBDriver);
            co = DriverManager.getConnection(DBUrl);
            System.out.println("ConnectedWithdrawing");
//            co.close();
//            System.out.println("Close connection");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Withdraw registration crashed!");
        }

        try {
            Class.forName("org.sqlite.JDBC");
            Connection co = DriverManager.getConnection("jdbc:sqlite:atm.db");
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Which currency do you want withdraw?");
        System.out.println("Please, enter [1] for BYN, [2] for USD, [3] for RUB and [4] for EUR.");
        curreciesExtract();
    }


    public void withdraw(int entrance, int summ) {

        String curr = "";

        if (entrance == 1) {

            curr = "BYN";
        } else if (entrance == 2) {

            curr = "USD";
        } else if (entrance == 3) {

            curr = "RUB";
        } else if (entrance == 4) {

            curr = "EUR";
        }

        try (Statement statement = co.createStatement();) {

            String query1 = "SELECT UserId FROM Users WHERE name = '" + userName + "' ";
            System.out.println("Query1 = " + query1);
            ResultSet rs1 = statement.executeQuery(query1);
            while (rs1.next()) {
                rsOne = rs1.getString(1);
            }

            System.out.println("rs1 = " + rsOne);

            String query2 = "SELECT acoountId FROM Accounts WHERE userId = '" + rsOne + "' AND currency = '" + curr +"'";
            System.out.println("Query2= " + query2);

            ResultSet rs2 = statement.executeQuery(query2);
            while (rs2.next()) {
                rsTwo = rs2.getString(1);
            }

            System.out.println("rs2 = " + rsTwo);

            String query3 = "SELECT balance FROM Accounts WHERE userId = '" + rsOne + "' AND currency = '" + curr + "'";
            System.out.println("Query3= " + query3);
            ResultSet rs3 = statement.executeQuery(query3);
            while (rs3.next()) {
                rsThree = rs3.getString(1);
            }
            System.out.println("rs3 = " + rsThree);
            int pars = Integer.parseInt(String.valueOf(rsThree));
            pars -= summ;

            if(pars > 0) {
                String query4 = "UPDATE Accounts SET balance = ('" + pars + "') WHERE acoountId = '" + rsTwo + "'";
                statement.executeUpdate(query4);

                String q4 = "SELECT balance FROM Accounts WHERE acoountId = '" + rsTwo + "'";
                ResultSet rs5 = statement.executeQuery(q4);

                while (rs5.next()) {
                    rsFour = rs5.getString(1);
                }
                System.out.println("rs5 = " + rsFour);

                insertTransaction(Integer.parseInt(rsTwo), -summ);
//                rs4.close();
                rs5.close();

            } else {
                System.out.println("Your haven't enough money. Please, keep calm and carry on!");
                questing();
            }

            rs1.close();
            rs2.close();
            rs3.close();

        } catch(Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Withdrawing crashed!");
        }

        questing();
    }
}
