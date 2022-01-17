/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_8;

import java.util.ArrayList;//IMPORT CLASE ARRAYLIST

/**
 *
 * @author ALBERTO
 */
public class Evidencia_8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //CREAMOS UN ARRAYLIST DE OBJETOS TIPO ELECTRODOMESTICO
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<Electrodomestico>(10);

        //EN ESTAS VARIABLES ACUMULADORAS GUARDAMOS EL PRECIO FINAL DE LA SUMA DE CADA TIPO DE ELECTRODOMESTICO
        int precioTotalFinal = 0;//ACUMULADOR PARA ELECTRODOMESTICOS
        int precioTotalLavadora = 0;//ACUMULADOR PARA LAVADORAS
        int precioTotalTeles = 0;//ACUMULADOR PARA TELEVISIONES

        //CREAMOS LOS OBJETOS ASIGNANDOLE VALORES AL CONSTRUCTOR
        //LUEGO GUARDAMOS EN EL ARRAYLIST CON .add
        Electrodomestico e1 = new Electrodomestico(3400, "rojo", 'd', 38);
        electrodomesticos.add(e1);

        Lavadora e2 = new Lavadora(4000, "blanco", 'A', 82, 12);
        electrodomesticos.add(e2);

        Television e3 = new Television(4500, "morado", 'k', 30, 50, true);
        electrodomesticos.add(e3);

        Television e4 = new Television(4200, "negro", 'C', 35, 50, false);
        electrodomesticos.add(e4);

        Electrodomestico e5 = new Electrodomestico(6300, "azul", 'e', 78);
        electrodomesticos.add(e5);

        Lavadora e6 = new Lavadora(3050, "blanco", 'b', 93, 34);
        electrodomesticos.add(e6);

        Electrodomestico e7 = new Electrodomestico(2540, "negro", 'f', 44);
        electrodomesticos.add(e7);

        Electrodomestico e8 = new Electrodomestico(7800, "gris", 'A', 98);
        electrodomesticos.add(e8);

        Television e9 = new Television(8900, "negro", 'B', 50, 60, true);
        electrodomesticos.add(e9);

        Electrodomestico e10 = new Electrodomestico(1990, "negro", 'D', 32);
        electrodomesticos.add(e10);

        //AQUI RECORREMOS EL ARRAYLIST PARA OPERAR CON CADA OBJETO
        for (int i = 0; i < electrodomesticos.size(); i++) {
            System.out.println("ELECTRODOMÉSTICO " + (i + 1) + ": ");
            electrodomesticos.get(i).imprimir();//LLAMAMOS EL METODO IMPRIMIR PARA IMPRIMIR TODOS LOS ATRIBUTOS DEL OBJETO
            electrodomesticos.get(i).precioFinal();//LLAMAMOS AL METODO PRECIOFINAL PARA OBTENER EL PRECIO FINAL DEL ELECTRODOMESTICO RESPECTO A LOS CARGOS APLICADOS
            System.out.println("El precio final es: " + electrodomesticos.get(i).getPrecioBase());//IMPRIMIMOS EN PANTALLA EL PRECIO FINAL (Es el precioBase pero ahora modificado con los cargos del precio final)

            //AQUI ACUMULAMOS EL PRECIO FINAL DE CADA ELECTRODOMESTICO
            precioTotalFinal += electrodomesticos.get(i).getPrecioBase();

            //AQUI COMPROBAMOS SI EL OBJETO ES DE TIPO LAVADORA, SI ES ASI ACUMULA EL PRECIO FINAL EN LA VARIABLE CORRESPONDIENTE
            if (electrodomesticos.get(i) instanceof Lavadora) {
                precioTotalLavadora += electrodomesticos.get(i).getPrecioBase();
            }

            //AQUI COMPROBAMOS SI EL OBJETO ES DE TIPO TELEVISION, SI ES ASI ACUMULA EL PRECIO FINAL EN LA VARIABLE CORRESPONDIENTE
            if (electrodomesticos.get(i) instanceof Television) {
                precioTotalTeles += electrodomesticos.get(i).getPrecioBase();
            }

            System.out.println("\n");
        }

        //IMPRIMIMOS EN PANTALLA EL PRECIO FINAL DE CADA TIPO DE ELECTRODOMESTICO
        System.out.println("El precio total de los Electrodomesticos es: " + precioTotalFinal);
        System.out.println("El precio total de las Lavadoras es: " + precioTotalLavadora);
        System.out.println("El precio total de las Televisiones es: " + precioTotalTeles);
    }

}
