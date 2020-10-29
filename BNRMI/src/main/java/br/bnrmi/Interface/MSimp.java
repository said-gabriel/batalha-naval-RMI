/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bnrmi.Interface;

import java.rmi.RemoteException;

/**
 *
 * @author Lucas
 */
public class MSimp extends java.rmi.server.UnicastRemoteObject implements MS {
    public static boolean jogador1 = true;
    public static boolean jogador2 = false;
    
    public MSimp() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public boolean acertou(int[] tiro, int[][] navios) {
        for (int navio = 0; navio < navios.length; navio++) {
            if (tiro[0] == navios[navio] [0] && tiro[1] == navios[navio][1]) {
                System.out.printf("Parabéns! Você acertou o tiro (%d,%d)\n", tiro[0] + 1, tiro[1] + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public int Jogou(String nome) {
        if (nome.equals("Jogador1")) return 1;
        if (nome.equals("Jogador2")) return 2;
        return 0;
    }

    @Override
    public boolean Vez(int codigo) {
        if(codigo == 1) return jogador1;
        if(codigo == 2) return jogador2;
        return false;
        
    } 
}
