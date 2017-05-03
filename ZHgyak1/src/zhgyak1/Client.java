/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhgyak1;

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
    public static void main(String[] args) throws IOException{
        //String name = args[0];
        String name = "Balu";
        String message;
        boolean isOver = false;
        
        String host = "localhost";
        int port = 2000;
        Socket client = new Socket(host, port);
        
        PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

        writer.println(name);
        int number;
            
        while(!isOver){
            message = reader.readLine();
            number = Integer.parseInt(message);
            System.out.println(name + " GOT NUMBER: " + number);
            number--;
            writer.println(number);
            if(number < 0){
                isOver = true;
            }
            message = reader.readLine();
            if(message.equals("Nyertes")){
                isOver = true;
            }
            System.out.println(message);
        }
        
        
        reader.close();
        writer.close();
        client.close();
    }
}
