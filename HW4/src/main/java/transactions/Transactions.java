package transactions;

import java.sql.*;

import static registration.NewUserReg.*;
import static usersInteractive.UsInteract.*;

public class Transactions {

    static Connection co;

    public static void insertTransaction(int accountId, int amount) {

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
            String query1 = "INSERT INTO Transactions (accountId, amount) " +
                    "VALUES ('" + accountId + "', '" + amount + "')";

            System.out.println("Query1 = " + query1);
            ResultSet rs1 = statement.executeQuery(query1);
            while (rs1.next()) {
                rsOne = rs1.getString(1);
            }

            System.out.println("rs1= " + rsOne);

            String query2 = "SELECT * FROM Transactions";

            System.out.println("Query1 = " + query1);
            ResultSet rs2 = statement.executeQuery(query2);
            while (rs2.next()) {
                String rsTwo = rs2.getString(1);
            }

            System.out.println("rs2= " + rs2);
//                rs2.close();

            System.out.println("All is correct!");

            rs1.close();

        } catch (Exception e) {

            System.out.println("Mistake:");
            System.out.println(e.getMessage());
        }

        System.out.println("Your transaction was added!");
    }
}
