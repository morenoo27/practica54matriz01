/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

/**
 *
 * @author aleja
 */
public class Prueba {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            
            Matriz prueba = new Matriz(6);

            prueba.mostrarMatriz();

            System.out.println(prueba.ceroRodeado());
        }
    }
}
