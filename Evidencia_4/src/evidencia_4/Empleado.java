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
public class Empleado {
    
    //ATRIBUTOS
    private String nombre;
    private int cedula;
    private int edad;
    private String estadoCivil;
    private double Salario;
    
    //CONSTRUCTOR
    public Empleado(String nombre, int cedula, int edad, String estadoCivil, double Salario){
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.estadoCivil = estadoCivil;
        this.Salario = Salario;
    }

    //METODOS DEL ENCAPSULAMIENTO
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the Salario
     */
    public double getSalario() {
        return Salario;
    }

    /**
     * @param Salario the Salario to set
     */
    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
    //MÉTODO DONDE SE ASIGNA LA CLASIFICACIÓN DE LA PERSONA
    public String asignarClasificacion(int edad){
        if(edad <= 21){
            return "La persona es Principiante";
        }else if(edad >= 22 && edad<=35){
            return "La persona es Intermedio";
        }else{
           return "La persona es Senior";
        }
    }
    
    //MÉTODO PARA IMPRIMIR LA INFORMACIÓN DEL EMPLEADO
    public void imprimir(){
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Cedula: "+this.cedula);
        System.out.println("Edad: "+this.edad);
        System.out.println("Estado Civil: "+this.estadoCivil);
        System.out.println("Salario: "+this.Salario);
        System.out.println(this.asignarClasificacion(this.edad));
    }
    
}
