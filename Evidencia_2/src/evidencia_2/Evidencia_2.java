/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_2;

import java.lang.Math; //Libreria Math para hacer operaciones matemáticas y utilizar valores como PI
import java.util.Scanner; //Libreria Scanner para poer escanear datos

/**
 *
 * @author ALBERTO
 */
public class Evidencia_2 {

    /**
     * @param args the command line arguments
     */
    
    //METODO MAIN 
    public static void main(String[] args) {
      
      Scanner leer = new Scanner(System.in);  
      System.out.println("Ingrese el valor del radio: ");
      int radio; //Variable tipo entero para guardar el radio del circulo
      radio = leer.nextInt();
      System.out.println("Circunferencia: "+ calcularCircunferencia(radio));
      
      System.out.println("Area: "+ calcularArea(radio));
      
    }
    
    static double calcularCircunferencia(int radio){
        double cir; //Variable double para guardar la circunferencia del circulo
        cir=2*Math.PI*radio; //Aqui realizamos la operación para obtener circunferencia
        return cir;
    }
    
    static double calcularArea(int radio){
        double area;//Variable double para guardar el area del circulo
        area =Math.PI*(Math.pow(radio, 2)); //Aqui realizamos la operación para obtener area
        return area;
    }
    
    
}
