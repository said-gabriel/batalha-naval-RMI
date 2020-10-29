/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.bnrmi.Interface;

/**
 *
 * @author Lucas
 */
public interface MS extends java.rmi.Remote {
    public boolean acertou(int[] tiro, int [][] navios) throws java.rmi.RemoteException;
    
    public int Jogou(String nome) throws java.rmi.RemoteException;
    
    public boolean Vez(int codigo) throws java.rmi.RemoteException;
}
