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
public class Desarrollador implements Interfaz {//IMPLEMENTAMOS LA INTERFAZ CREADA
    
    //ATRIBUTOS
    private String nombre;
    private String lineasDeCodigo;
    
    
    //CONSTRUCTOR
    public Desarrollador (String nombre, String lineasDeCodigo){
        this.nombre = nombre;
        this.lineasDeCodigo = lineasDeCodigo;
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
     * @return the lineasDeCodigo
     */
    public String getLineasDeCodigo() {
        return lineasDeCodigo;
    }

    /**
     * @param lineasDeCodigo the lineasDeCodigo to set
     */
    public void setLineasDeCodigo(String lineasDeCodigo) {
        this.lineasDeCodigo = lineasDeCodigo;
    }

    //MÉTODOS IMPLEMENTADOS DE LA INTERFAZ
    @Override
    public String encenderObjeto() {
        return "Soy el Desarrollador "+this.nombre+", encendí mi computadora";
    }

    @Override
    public String maniobrarObjeto() {
        return "Soy el Desarrollador "+this.nombre+", y llevo más de "+this.lineasDeCodigo+" líneas codificadas";
    }

    @Override
    public String apagarObjeto() {
        return "Soy el Desarrollador "+this.nombre+", apagué mi computadora";
    }
    
    
    
}
