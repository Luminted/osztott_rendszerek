/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zh20160603.alapfeladat;

import java.rmi.RemoteException;
import java.util.Set;

/**
 *
 * @author rlevente
 */
public interface LottoInterface {
    void sorsol() throws RemoteException;
    int jatszik(Set<Integer> szamok) throws RemoteException;
}
