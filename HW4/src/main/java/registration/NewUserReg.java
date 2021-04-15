package registration;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import static usersInteractive.UsInteract.*;

public class NewUserReg {

    public static String DBDriver = "org.sqlite.JDBC";
    public static String DBUrl = "jdbc:sqlite:.\\src\\baggage\\ATM.db";
    String name;
    String address;
    Connection co;

    public void usersRegistration() {

        System.out.println("Now you can pass the registration.");
        System.out.println("Enter your name, please!");
        name = usersInput();

        System.out.println("Do you want to register your address?");
        usersAdress();

        NewUserReg newUserReg = new NewUserReg();
        newUserReg.open();
        newUserReg.insert();
        newUserReg.select();
        newUserReg.close();

        System.out.println("Do you want to register your Account?");
        usersMessage(2);
    }

        void open() {

         try {

            Class.forName(DBDriver);
            co = DriverManager.getConnection(DBUrl);
            System.out.println("Connected1");
            co.close();
             System.out.println("Close connection");

        } catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("Open crashed!");
        }
    }

    void insert() {

        String query = "INSERT INTO Users (name, address) " +
                "VALUES ('" + name + "', '" + address + "')";

        try (Statement statement = co.createStatement();) {
            statement.executeUpdate(query);
            System.out.println("Rows added!");
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Insert crashed!");
        }
    }

    void select() {

        try (Statement statement = co.createStatement();) {
            String query = "SELECT userId, name, address FROM Users";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("userId");
                String name = rs.getString("name");
                String address = rs.getString("address");
                System.out.println(id + "\t|" + name + "\t|" + address);
            }

            rs.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
    void close() {

        try {
            co.close();

        } catch (Exception e) {
        System.out.println(e.getMessage());
        System.out.println("Close crashed!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
