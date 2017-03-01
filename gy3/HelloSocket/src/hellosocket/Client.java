/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellosocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rlevente
 */
public class Client {
        public static void main(String[] args) throws IOException {
            
            String host = "localhost";
            int port = 1234;
            Socket client = new Socket(host, port);
            
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            String message = "Hello";
            int repetitions = 5;
            pw.println(message);
            pw.println(repetitions);
            
            message = reader.readLine();
            System.out.println("+ concatenated message: " + message);
            
            message = reader.readLine();
            System.out.println("StringBuilder concatenated message: " + message);
            
            String otherMessage = reader.readLine();
            System.out.println("pw concatenated message: " + otherMessage);
            
            
            client.close();
    }   
}
