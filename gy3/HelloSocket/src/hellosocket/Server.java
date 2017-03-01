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
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Waiting for client");
        Socket client = server.accept();
        System.out.println("Connected on port: " + server.getLocalSocketAddress());
        
        //Scanner sc = new Scanner(client.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        
        
        //String message = sc.nextLine();
        String message = reader.readLine();
        int repetitions = Integer.parseInt(reader.readLine());
        
        System.out.println(repetitions);
        System.out.println(message);
        
        String newMessage = new String();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < repetitions; i++){
            newMessage += message + " ";
            sb.append(message);
        }
        
        pw.println(newMessage);
        System.out.println("+ concatenated message sent");
        pw.println(sb.toString());
        
        for(int i = 0 ; i < repetitions; i++){
            pw.append(message);
        }
        
        pw.println();
        
        server.close();
    }
}
