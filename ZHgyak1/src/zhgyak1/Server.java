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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/**
 *
 * @author rlevente
 */
public class Server {
    public static void main(String[] args) throws IOException{
         ServerSocket server = new ServerSocket(2000);
        System.out.println("Waiting for client");
        
        
        boolean isGame = false;
        ArrayList<Player> clients = new ArrayList<>();
        String message;
        Random RNG = new Random();
        int nextNumber = RNG.nextInt(10) + 11;
        
        while(true){
            while((clients.size() % 3 != 0 || clients.isEmpty()) && !isGame){
                Player player = new Player();

                player.setSocket(server.accept());
                player.setReader(new BufferedReader(new InputStreamReader(player.getSocket().getInputStream())));
                PrintWriter writer = new PrintWriter(player.getSocket().getOutputStream(), true);
                String name = reader.readLine();
                clients.add(player);

                System.out.println("Connected on port: " + server.getLocalSocketAddress());
                if(clients.size() % 3 == 0 && !clients.isEmpty()){
                    isGame = true;
                }
            }
            
            if(isGame){
                for(int i = 0; i < clients.size(); i++){
                    System.out.println("i: " + i + " size: " + clients.size());
                    clients.get(i).writer.println(nextNumber);
                    message = clients.get(i).reader.readLine();
                    nextNumber = Integer.parseInt(message);
                    System.out.println("nextNumber: " + nextNumber);
                    if(nextNumber < 0){
                        clients.get(i).writer.println("Vesztes");
                        System.out.println(clients.get(i).name + " kiesett!");
                        clients.remove(i);
                        nextNumber = RNG.nextInt(10) + 11;
                    }
                }
            }
            if(clients.size() == 1){
                clients.get(0).writer.println("Nyertes");
                isGame = false;
            }
        }
    }
}
