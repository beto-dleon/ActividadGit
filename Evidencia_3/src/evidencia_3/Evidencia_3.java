/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_3;

import java.util.Scanner; //Libreria Scanner para leer variables

/**
 *
 * @author ALBERTO
 */
public class Evidencia_3 {

    /**
     * @param args the command line arguments
     */
    
    //METODO MAIN
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        String[][] personas = new String[1000][4];//Arreglo bidimensional donde se guarda información de las personas
        
        int i, j=0, n=1000, personasTotal=0;//Variables enteras para manejo del for y Guardar el total de personas
        int x;// Variable auxiliar
        double h=0, m=0, cas=0, sol=0;//Variables tipo double acumuladoras para conocer el numero de
                                        //hombres, mujeres, casados y solteros
                                        
        double iEdad=0;//Variable para acumular las edades
        
        //Ciclo for para el registro de personas
        for(i=0;i<n;i++){
            
            System.out.println("PERSONA "+(i+1));
            
            System.out.println("Nombre: ");
            personas[i][j] = leer.nextLine();
            j++;
            
            System.out.println("Edad: ");
            personas[i][j] = leer.nextLine();
            iEdad = Double.parseDouble(personas[i][j]) + iEdad;//Aqui se convierte el String a double
            j++;
            
            System.out.println("Estado civil (s para soltero ó c para casado): ");
            personas[i][j] = leer.nextLine();
            if(personas[i][j].equals("s")){//Funcion equals para comparar Strings
                sol++;
            }else{
                cas++;
            }
            j++;
            
            System.out.println("Sexo (h para hombre ó m para mujer): ");
            personas[i][j] = leer.nextLine();
            if(personas[i][j].equals("h")){//Funcion equals para comparar Strings
                h++;
            }else{
                m++;
            }
            j=0;
            
            System.out.println("Deseas capturar otra persona (1:si  2:no): ");
            x = leer.nextInt();
            leer.nextLine();
            if(x==2){
                personasTotal = i;
                i=n;
            }
        }
        
        System.out.println("Total de peronas capturadas: "+(personasTotal+1));
        
        //Calculamos promedio de las edades
        double prom;
        prom = iEdad/(personasTotal+1);
        System.out.println("Promedio de edad de las personas capturadas: "+prom);
        
        //Calculamos el porcentaje de hombres
        double pHombres;
        pHombres = (h/(personasTotal+1))*100;
        System.out.println("Porcentaje de Hombres: "+pHombres);
        
        //Calculamos el porcentaje de mujeres
        double pMujeres;
        pMujeres = (m/(personasTotal+1))*100;
        System.out.println("Porcentaje de Mujeres: "+pMujeres);
        
        //Calculamos el porcentaje de solteros
        double pSolteros;
        pSolteros = (sol/(personasTotal+1))*100;
        System.out.println("Porcentaje de Hombres y Mujeres Soltero(a)s: "+pSolteros);
        
        //Calculamos el porcentaje de casados
        double pCasados;
        pCasados = (cas/(personasTotal+1))*100;
        System.out.println("Porcentaje de Hombres y Mujeres Casado(a)s: "+pCasados);
        
    }
    
}
