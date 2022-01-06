/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_4;

import java.util.Scanner;//import clase Scanner
import java.util.ArrayList;// import del ArrayList
import java.util.InputMismatchException;

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

        int n = 0, i;//n maneja el numero de empleados a registrar

        //VARIABLES DONDE SE GUARDA INFORMACION DEL EMPLEADO PARA LUEGO
        //AGREGAR AL ARRAYLIST
        String nom = " ";
        int cedula = 0, edad = 0;
        String estado = " ";
        double salario = 0;
        String x;//vairiable auxiliar para (s/n)
        int lineas = 0;
        String lenguaje = " ";

        //Creación de los objetos
        ArrayList<Empleado> personas = new ArrayList<Empleado>();
        Scanner leer = new Scanner(System.in);

        System.out.println("Cuantas personas desea registrar: ");
        n = leer.nextInt();
        leer.nextLine();

        //CICLO FOR DONDE SE PREGUNTA LA INFORMACIÓN DE LOS EMPLEADOS
        for (i = 0; i < n; i++) {

            System.out.println("Empleado " + (i + 1) + " Nombre: ");
            nom = leer.nextLine();
            System.out.println("Cedula: ");
            cedula = leer.nextInt();

            System.out.println("Edad: ");
            try { //USAMOS TRY CATCH PARA INVOCAR UNA EXCEPCIÓN
                edad = leer.nextInt();
                leer.nextLine();
                EdadException oEdadEx = new EdadException();// AQUI CREAMOS EL OBJETO DE LA NUEVA CLASE EdadExcepción PARA VERFIFICAR QUE LA EDAD ES ADECUADA
                oEdadEx.validarEdad(edad);
            }catch (EdadException ex) {// EN ESTE CASO CREAMOS UNA EXCEPCIÓN PERSONALIZADA PARA QUE EL USUARIO INTRODUZCA UNA EDAD DENTRO DE UN RANGO ESPECÍFICO
                System.out.println(ex.getMessage());//IMPRIME EN PANTALLA EL MENSAJE PERSONALIZADO DE ERROR
                edad = leer.nextInt();//SE PIDE QUE EL USUARIO VUELVA A INTRODUCIR LA EDAD
            }catch (InputMismatchException e){//EXCEPCIÓN PARA EL TIPO DE DATO INVALIDO
                System.out.println("Error, tipo de dato no válido ");
            }
            leer.nextLine();
            System.out.println("Estado Civil: ");
            estado = leer.nextLine();
            System.out.println("Salario: ");
            try {//USAMOS TRY CATCH PARA INVOCAR UNA EXCEPCIÓN
                salario = leer.nextDouble();
            } catch (InputMismatchException e) {//EXCEPCIÓN PARA EL TIPO DE DATO INVALIDO
                System.out.println("Error, tipo de dato no válido");
            }
            leer.nextLine();
            System.out.println("Es programador? (s/n): ");
            x = leer.nextLine();
            if (x.equals("s")) {
                System.out.println("Lineas de código por hora: ");
                lineas = leer.nextInt();
                leer.nextLine();
                System.out.println("Lenguaje dominante: ");
                lenguaje = leer.nextLine();

                //Aqui se crea el objeto tipo Programador
                Programador p = new Programador(nom, cedula, edad, estado, salario, lineas, lenguaje);
                personas.add(p); //Metemos la información al ArrayList
            } else {
                Empleado e = new Empleado(nom, cedula, edad, estado, salario);//Aqui se crea el objeto tipo Empleado
                personas.add(e);//Metemos la información al ArrayList
            }

        }

        //CICLO FOR PARA IMPRIMIR LA INFORMACIÓN DE LOS EMPLEADOS
        for (i = 0; i < n; i++) {
            System.out.println("Empleado " + (i + 1) + "\n");
            personas.get(i).imprimir();
            System.out.println("\n");
        }

    }

}
