/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

import java.util.Random;

/**
 *
 * @author aleja
 */
public class Matriz {

    private static Random rd = new Random();

    private int[][] matriz;

    //al crear la matriz vamos a pedir un valor n para que sea cuadrada de orden n
    public Matriz(int n) {

        this.matriz = new int[n][n];
        llenarMatriz();
    }

    private void llenarMatriz() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j] = rd.nextInt(2);
            }
        }
    }

    public void mostrarMatriz() {

        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {

                System.out.print(matriz[i][j] + "\t");
            }

            System.out.println();
        }
    }

    public String ceroRodeado() {

        boolean candidato = false;

        int i, j = 0;

        for (i = 0; i < matriz.length; i++) {

            for (j = 0; j < matriz[i].length; j++) {

                //filramos si es 0, ya que son los numeros que realmente nos interesan
                if (matriz[i][j] == 0) {
                    
                    candidato = mirarAlrededores(i, j);
                    if (candidato) {
                        break;
                    }
                }
            }
        }
        
        //si es el candidato mostramos la posicion del numero que nos interesa
        //y sino pues nos dira que no
        if (candidato) {

            return "El numero esta en la posicion (" + i + ", " + j + ")";
        } else {
            
            return "No existe el numero que buscamos";
        }
    }

    private boolean mirarAlrededores(int i, int j) {

        boolean candidato = false, esquina1 = true, esquina2 = true, esquina3 = true, esquina4 = true, arriba = true, abajo = true, izquierda = true, derecha = true;
        //una vez recibimos la posicion del 0, miramos su alrededores

        //para que podamos mirar en su parte izquierda, tenemos que contraolar que nos e salga de la matriz y para que podamos comprobar la posicio de su izquierda, tiene que ser mayor a 0
        if (i > 0 && j > 0) {

            izquierda = matriz[i - 1][j] == 1; //izquierda

            esquina1 = matriz[i - 1][j - 1] == 1; //esquina arriba izquierda

            arriba = matriz[i][j - 1] == 1; //arriba
            
        }
        
        if (i < matriz.length - 1 && j < matriz.length - 1) {

            abajo = matriz[i][j + 1] == 1; //abajo

            esquina2 = matriz[i + 1][j + 1] == 1; // esquina abajo derecha

            derecha = matriz[i + 1][j] == 1; //derecha
        }

        if (i > 0 && j < matriz.length - 1) {

            esquina3 = matriz[i - 1][j + 1] == 1; //esquina abajo izquierda
        }

        if (i > matriz.length - 1 && j < 0) {

            esquina4 = matriz[i + 1][j - 1] == 1; //esquina arriba derecha
        }

        if (esquina4 && esquina3 && esquina2 && esquina1 && abajo && arriba && derecha && izquierda) {
            candidato = true;
        }

        return candidato;
    }
}
