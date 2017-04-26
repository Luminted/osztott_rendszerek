/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rlevente
 */
public class DataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
       Class.forName("org.hsqldb.jdbc.JDBCDriver");
       Connection conn = DriverManager.getConnection("jdbc:hsqldb:gyak9db");
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS people");
        
        String createTable = "CREATE TABLE people(id INT, password VARCHAR(20), name VARCHAR(20))";
        stmt.executeUpdate(createTable);
        
        String insertInto1 = "INSERT INTO people VALUES(1,'12', 'Csaba')";
        stmt.executeUpdate(insertInto1);
        
        String insertInto2 = "INSERT INTO people VALUES(2, '23', 'István')";
        stmt.executeUpdate(insertInto2);
        
        PreparedStatement ps = conn.prepareStatement("INSERT INTO people VALUES (?, ?, ?)");
        ps.setInt(1,3);
        ps.setString(3, "Csenge");
        ps.setString(2, "34");
        ps.addBatch();
        
        ps.setInt(1, 4);
        ps.setString(3, "Nacsa");
        ps.setString(2, "34");
        ps.addBatch();
        
        ps.executeBatch();
        

        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client");
        Socket client = server.accept();
        System.out.println("Connected on port: " + server.getLocalSocketAddress());
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String line = reader.readLine();
        String[] split = line.split(":");
        String name = split[0];
        String pw = split[1];
        
        PreparedStatement lookUp = conn.prepareStatement("SELECT * FROM people WHERE name=? AND password=?");
        lookUp.setString(1, name);
        lookUp.setString(2, pw);
        
        ResultSet resSet = lookUp.executeQuery();
       if(resSet.next()){
           System.out.println("YEP");
       }else{
           System.out.println("NOPE");
       }
        
        stmt.close();
        conn.close();
        server.close();
        
    }
    
}
