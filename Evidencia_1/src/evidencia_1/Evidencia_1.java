/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_1;

import java.util.Scanner; //Import utilizado para la clase Scanner para poder leer variables

/**
 *
 * @author ALBERTO
 */
public class Evidencia_1 {

    /**
     * @param args the command line arguments
     */
    //AQUI EL MÉTODO MAIN
    public static void main(String[] args) {
        
        String Nombre; //Variable tipo String para guardar el nombre
        int num1; //Variable tipo entero para guardar un número entero
        double num2; //Variable tipo double para guardar un número decimal
        double suma; //Variable tipo double para guardar la suma de los números
        
        
        
        Scanner leer = new Scanner(System.in);
        
        //Aqui pedimos ingresar un nombre y con "leer" lo guardamos en la variable Nombre
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
