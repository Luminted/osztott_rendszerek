/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author rlevente
 */
public class Client {
    public static void main(String args[]) throws Exception{
        String host = "localhost";
        int port = 1234;
        Socket client = new Socket(host, port);
        
         PrintWriter pw = new PrintWriter(client.getOutputStream(), true);

         pw.println("Csaba:123");
         System.out.println("sent");
         
         client.close();
    }
}
