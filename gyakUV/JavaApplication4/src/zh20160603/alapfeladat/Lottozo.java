/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zh20160603.alapfeladat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author rlevente
 */
public class Lottozo {
    public static void main(String[] args) throws RemoteException, Exception {
        System.out.println(args[0]);
        int startMoney = Integer.parseInt(args[0]);
        Registry reg = LocateRegistry.createRegistry(8899);
        LottoRemote lottozo = new LottoRemote(startMoney);
        reg.rebind("lottozo", (Remote) lottozo);
    }
}
