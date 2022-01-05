/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_4;

/**
 *
 * @author ALBERTO
 */
public class Programador extends Empleado{ //HEREDA DE LA CLASE PADRE EMPLEADO
    
    //ATRIBUTOS
    private int lineasDeCodigoPorHora;
    private String lenguajeDominante;

     //CONSTRUCTOR
    public Programador(String nombre, int cedula, int edad, String estadoCivil, double Salario, int lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, cedula, edad, estadoCivil, Salario);//Con super accedemos a los atributos y metodos de la clase padre
        this.lenguajeDominante = lenguajeDominante;
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    //METODOS DEL ENCAPSULAMIENTO
    /**
     * @return the lineasDeCodigoPorHora
     */
    public int getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    /**
     * @param lineasDeCodigoPorHora the lineasDeCodigoPorHora to set
     */
    public void setLineasDeCodigoPorHora(int lineasDeCodigoPorHora) {
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
    }

    /**
     * @return the lenguajeDominante
     */
    public String getLenguajeDominante() {
        return lenguajeDominante;
    }

    /**
     * @param lenguajeDominante the lenguajeDominante to set
     */
    public void setLenguajeDominante(String lenguajeDominante) {
        this.lenguajeDominante = lenguajeDominante;
    }
    
    //MÉTODO PARA IMPRIMIR LA INFORMACIÓN DEL PROGRAMADOR
    public void imprimir(){
        super.imprimir();//Con super accedemos a los atributos y metodos de la clase padre
        System.out.println("Lineas de Código por hora: "+this.lineasDeCodigoPorHora);
        System.out.println("Lenguaje dominante: "+this.lenguajeDominante);
    }
    
    
}
