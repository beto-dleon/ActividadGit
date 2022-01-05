/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_4;

import java.util.Scanner;//import clase Scanner
import java.util.ArrayList;// import del ArrayList

/**
 *
 * @author ALBERTO
 */
public class Evidencia_4 {

    /**
     * @param args the command line arguments
     */
    //CLASE MAIN
    public static void main(String[] args) {
        
        int n=0, i;//n maneja el numero de empleados a registrar
        
        //VARIABLES DONDE SE GUARDA INFORMACION DEL EMPLEADO PARA LUEGO
        //AGREGAR AL ARRAYLIST
        String nom=" ";
        int cedula=0, edad=0;
        String estado=" ";
        double salario=0;
        String x;//vairiable auxiliar para (s/n)
        int lineas=0;
        String lenguaje=" ";
        
        //Creación de los objetos
        ArrayList<Empleado> personas = new ArrayList<Empleado>();
        Scanner leer = new Scanner(System.in);
        
        
        System.out.println("Cuantas personas desea registrar: ");
        n = leer.nextInt();
        leer.nextLine();
        
        //CICLO FOR DONDE SE PREGUNTA LA INFORMACIÓN DE LOS EMPLEADOS
        for(i = 0;i<n;i++){
            
            System.out.println("Empleado "+(i+1)+" Nombre: ");
            nom = leer.nextLine();
            System.out.println("Cedula: ");
            cedula = leer.nextInt();
            do{
                System.out.println("Edad: ");
                edad = leer.nextInt();
                leer.nextLine();
                if(edad<18 || edad>45){
                   System.out.println("EDAD NO VÁLIDA, INGRESAR UNA EDAD ENTRE 18 Y 45 AÑOS");
                }
            }while(edad<18 || edad>45);//Validación para saber si esta en el rango de edad aceptable
            
            System.out.println("Estado Civil: ");
            estado = leer.nextLine();
            System.out.println("Salario: ");
            salario = leer.nextDouble();
            leer.nextLine();
            System.out.println("Es programador? (s/n): ");
            x = leer.nextLine();
            if(x.equals("s")){
                System.out.println("Lineas de código por hora: ");
                lineas = leer.nextInt();
                leer.nextLine();
                System.out.println("Lenguaje dominante: ");
                lenguaje = leer.nextLine();
                
                //Aqui se crea el objeto tipo Programador
                Programador p = new Programador(nom,cedula,edad,estado,salario,lineas,lenguaje);
                personas.add(p); //Metemos la información al ArrayList
            }else{
                Empleado e = new Empleado(nom,cedula,edad,estado,salario);//Aqui se crea el objeto tipo Empleado
                personas.add(e);//Metemos la información al ArrayList
            }
            
        }
        
        //CICLO FOR PARA IMPRIMIR LA INFORMACIÓN DE LOS EMPLEADOS
        for(i=0;i<n;i++){
            System.out.println("Empleado "+(i+1)+"\n");
            personas.get(i).imprimir();
            System.out.println("\n");
        }
        
    }
    
}
