package base;

import java.sql.*;

public class BaseManipul {

    public static String DBDriver = "org.sqlite.JDBC";
    public static String DBUrl = "jdbc:sqlite:.\\src\\baggage\\ATM.db";
    Connection co;

    public void createConnection() {

        try {

            Class.forName(DBDriver);
            co = DriverManager.getConnection(DBUrl);
            System.out.println("Connected1");
            //     co.close();
            //     System.out.println("Close connection");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Pzdc");
        }
    }

    public void createUsers() {

        String query = "CREATE TABLE IF NOT EXISTS Users (userId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR (50), address VARCHAR (255));";

        try (Statement statement = co.createStatement();) {
            statement.executeUpdate(query);
            System.out.println("Table created!");
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Crash!");
        }
    }

    public void createAccounts() {

        String query = "CREATE TABLE IF NOT EXISTS Accounts (acoountId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userId INTEGER(10) NOT NULL, balance INTEGER(15), currency VARCHAR(10), " +
                "FOREIGN KEY (userId) REFERENCES Users (userId));";

        try (Statement statement = co.createStatement();) {
            statement.executeUpdate(query);
            System.out.println("Table created!");
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Crash!");
        }
    }

    public void createTransactions() {

        String query = "CREATE TABLE IF NOT EXISTS Transactions (transactinId INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "accountId INTEGER (10), amount INTEGER (15), FOREIGN KEY (accountId) " +
                "REFERENCES Accounts (accountId));";

        try (Statement statement = co.createStatement();) {
            statement.executeUpdate(query);
            System.out.println("Table created!");
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Crash!");
        }
    }
}
