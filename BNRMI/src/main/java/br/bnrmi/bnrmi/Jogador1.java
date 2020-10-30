package br.bnrmi.bnrmi;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alcebiades
 */
public class Jogador1 {
    public static void main(String[] args) {
        try {
            Jogador j1 = new Jogador(1);
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
