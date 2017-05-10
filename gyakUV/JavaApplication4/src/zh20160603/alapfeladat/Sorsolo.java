/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zh20160603.alapfeladat;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author rlevente
 */
public class Sorsolo {
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry reg = LocateRegistry.getRegistry(8899);
        String[] names = reg.list();
        
            Remote remote = reg.lookup(names[0]);
            LottoInterface li = (LottoInterface)remote;
        
        try {
            while(true){
                li.sorsol();
                Thread.sleep(1000);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
    }
}
