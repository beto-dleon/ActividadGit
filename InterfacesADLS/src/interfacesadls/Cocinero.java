/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesadls;

/**
 *
 * @author ALBERTO
 */
public class Cocinero implements Interfaz {//IMPLEMENTAMOS LA INTERFAZ CREADA
    
    //ATRIBUTOS
    private String nombre;
    private String horasEnEstufa;

    //CONSTRUCTOR
    public Cocinero(String nombre, String horasEnEstufa){
        this.nombre = nombre;
        this.horasEnEstufa = horasEnEstufa;
    }
    
    //MÉTODOS DEL ENCAPSULAMIENTO
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
     * @return the horasEnEstufa
     */
    public String getHorasEnEstufa() {
        return horasEnEstufa;
    }

    /**
     * @param horasEnEstufa the horasEnEstufa to set
     */
    public void setHorasEnEstufa(String horasEnEstufa) {
        this.horasEnEstufa = horasEnEstufa;
    }

    //MÉTODOS IMPLEMENTADOS DE LA INTERFAZ
    @Override
    public String encenderObjeto() {
        return "Soy el cocinero "+this.nombre+", encendí mi estufa";
    }

    @Override
    public String maniobrarObjeto() {
        return "Soy el cocinero "+this.nombre+", y llevo más de "+this.horasEnEstufa+" horas en la estufa";
    }

    @Override
    public String apagarObjeto() {
        return "Soy el cocinero "+this.nombre+", apagué mi estufa";
    }
    
}
