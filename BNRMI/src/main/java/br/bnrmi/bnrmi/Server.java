/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bnrmi.bnrmi;

import br.bnrmi.Interface.MS;
import br.bnrmi.Interface.MSimp;
import static bnlng.Jogador.iniciaNavios;
import java.rmi.Naming;

/**
 *
 * @author Lucas
 */
public class Server {

    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(6666);
            MS k = new MSimp();
            Naming.rebind("//127.0.0.1:6666/BatalhaNaval");
        } catch (Exception e) {
            System.out.printf("Trouble: " + e);
        }

    }
}
