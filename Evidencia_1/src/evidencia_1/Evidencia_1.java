/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_1;

import java.util.Scanner;

/**
 *
 * @author ALBERTO
 */
public class Evidencia_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String Nombre;
        int num1;
        double num2;
        double suma;
        
        
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingresa tu nombre:");
        Nombre = leer.nextLine();
        
        System.out.println("Ingresa un número entero:");
        num1 = leer.nextInt();
        
        System.out.println("Ingresa un número decimal:");
        num2 = leer.nextDouble();
        
        suma = num1+num2;
        
        System.out.println("Hola "+Nombre +", el resultado de la suma entre "+num1 +" y "+num2
        +" es "+suma);
        
    }
    
}
