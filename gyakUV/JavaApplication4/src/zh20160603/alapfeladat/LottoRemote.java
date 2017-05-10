/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zh20160603.alapfeladat;

import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author rlevente
 */
public class LottoRemote extends UnicastRemoteObject implements LottoInterface{
    private int money;
    private Random rnd;
    private int[] numbers;

    public LottoRemote(int money) throws Exception{
        this.money = money;
        rnd = new Random(123456);
    }

    @Override
    public synchronized void sorsol() {
        if(money <= 0){
            throw new UnsupportedOperationException("Csődbe menta lottózó ter szívtelen állat!");
        }
        int[] numbers = new int[5];
        for(int i = 0; i < 5; i++){
            numbers[i] = rnd.nextInt(90) + 1;
        }
        System.out.println("L > [" + numbers.toString() + "]");
    }

    @Override
    public synchronized int jatszik(Set<Integer> szamok) {
        if(money <= 0){
            throw new UnsupportedOperationException("Csődbe menta lottózó ter szívtelen állat!");
        }
        
        int correct = 0;
        int winnings = -2;
        
        for(int i=0; i < 5; i++){
            if(szamok.contains(numbers[i])){
                correct++;
            }
        }
        if(correct > 1){
            winnings += (5 * correct);
        }
        money -= winnings;
        System.out.println("L > tipp: " + szamok.toString() + "; kifizetes: " + winnings + "; uj kassza: " + money);
        return winnings;
    }
    
    
    
}
