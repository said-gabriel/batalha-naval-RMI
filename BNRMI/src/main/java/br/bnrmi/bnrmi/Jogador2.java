/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bnrmi.bnrmi;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 55289
 */
public class Jogador2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Jogador j2 = new Jogador(2);
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
