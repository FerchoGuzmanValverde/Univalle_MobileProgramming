/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion.java;

import java.util.Scanner;

/**
 *
 * @author Fernando Guzman
 */
public class IntroduccionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Suma de 2 numeros
        int num1, num2;
        Scanner teclado = new Scanner(System.in);
        System.out.println("SUMA DE 2 NUMEROS");
        System.out.println("Ingrese primer numero: ");
        num1 = teclado.nextInt();
        System.out.println("Ingrese segundo numero: ");
        num2 = teclado.nextInt();
        System.out.println("El resultado es: " + (num1 + num2));
        
        //Juego adivina el numero del 1 al 6
        int ramdon, numIngresado, contador = 0;
        System.out.println("ADIVINA EL NUMERO");
        ramdon = (int)((Math.random()*6)+1);
        while(contador < 2){
            System.out.println("Ingrese un numero: ");
            numIngresado = teclado.nextInt();
            if(numIngresado < ramdon){
                System.out.println("Tu numero es muy bajo");
                contador++;
            }
            else if(numIngresado > ramdon){
                System.out.println("Tu numero es muy alto");
                contador++;
            }
            else{
                System.out.println("Acertaste!!");
            }
        }
        System.out.println("El juego termino");
        
        
    }
    
}
