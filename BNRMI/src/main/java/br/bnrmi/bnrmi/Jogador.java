package br.bnrmi.bnrmi;

import br.bnrmi.Interface.MS;
import br.bnrmi.Interface.MSimp;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alcebiades
 */
public class Jogador {

    public Jogador(int cod) throws RemoteException {
        int[][] tabuleiro = new int[5][5];
        int[][] navios = new int[3][2];
        int[] tiro = new int[2];
        boolean vez = false;
        int tentativas = 0, acertos = 0;
        MSimp ms = new MSimp();
        //if(cod == 1) {
        //vez = true;
        //}
        //if(cod == 2){
        //vez = false;
        //}
        try {
            MS c = (MS) Naming.lookup("rmi://127.0.0.1:6666/BatalhaNaval");
            System.out.println();
            iniciaNavios(navios);
            inicializarTabuleiro(tabuleiro);
            System.out.println();
            //if(ms.Vez(cod){
            //if(cod == 1) ms.j2 = true;
            //if(cod == 2) ms.j1 = false;
            do {
                imprimirTabuleiro(tabuleiro);
                atirar(tiro);
                tentativas++;
                if (ms.acertou(tiro, navios)) {
                    dica(tiro, navios, tentativas);
                    acertos++;
                } else {
                    dica(tiro, navios, tentativas);
                }
                mudarTabuleiro(tiro, tabuleiro, navios);
            } while (acertos != 3);
        //}
        if(acertos == 3) {
            imprimirTabuleiro(tabuleiro);
            System.out.print("O Vencedor é o jogador: " + ms.Vez(cod));
        }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void inicializarTabuleiro(int[][] tabuleiro) {
        //i e j são linhas e colunas respectivamente do tabuleiro.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tabuleiro[i][j] = -1;
            }
        }
    }

    public static void imprimirTabuleiro(int[][] tabuleiro) {
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "");
            for (int j = 0; j < 5; j++) {
                if (tabuleiro[i][j] == -1) {
                    System.out.println("\t" + "~");
                } else if (tabuleiro[i][j] == 0) {
                    System.out.println("\t" + "-");
                } else if (tabuleiro[i][j] == 1) {
                    System.out.println("\t" + "X");
                }
            }
            System.out.println();
        }
    }

    public static void iniciaNavios(int[][] navios) {
        Random sorte = new Random();
        for (int n = 0; n < 3; n++) {
            navios[n][0] = sorte.nextInt(5);
            navios[n][1] = sorte.nextInt(5);
            for (int anterior = 0; anterior < n; anterior++) {
                if (navios[n][0] == navios[anterior][0] && (navios[n][1] == navios[anterior][1])) {
                    do {
                        navios[n][0] = sorte.nextInt(5);
                        navios[n][1] = sorte.nextInt(5);
                    } while (navios[n][0] == navios[anterior][0] && navios[n][1] == navios[anterior][1]);
                }
            }
        }
    }

    public static void atirar(int[] tiro) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Linha: ");
        tiro[0] = sc.nextInt();
        tiro[0]--;

        System.out.print("Coluna: ");
        tiro[1] = sc.nextInt();
        tiro[1]--;
    }

    public static void dica(int tiro[], int navios[][], int tentativa) {
        int i = 0, j = 0;
        for (int fila = 0; fila < navios.length; fila++) {
            if (navios[fila][0] == tiro[0]) {
                i++;
            }
            if (navios[fila][1] == tiro[1]) {
                j++;
            }
        }
        System.out.printf("\nDica %d: \nlinha %d navios\n" + "coluna %d -> %d navios\n", tentativa, tiro[0] + 1, i, tiro[1] + 1, j);
    }

    public static void mudarTabuleiro(int tiro[], int[][] tabuleiro, int[][] navios) throws RemoteException {
        MSimp ms = new MSimp();
        if (ms.acertou(tiro, navios)) {
            tabuleiro[tiro[0]][tiro[1]] = 1;
        } else {
            tabuleiro[tiro[0]][tiro[1]] = 0;
        }
    }
}
