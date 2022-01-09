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
public class Piloto implements Interfaz{//IMPLEMENTAMOS LA INTERFAZ CREADA
    
    //ATRIBUTOS
    private String nombre;
    private String aniosVolando;

    //CONSTRUCTOR
    public Piloto(String nombre, String aniosVolando) {
        this.nombre = nombre;
        this.aniosVolando = aniosVolando;
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
     * @return the aniosVolando
     */
    public String getAniosVolando() {
        return aniosVolando;
    }

    /**
     * @param aniosVolando the aniosVolando to set
     */
    public void setAniosVolando(String aniosVolando) {
        this.aniosVolando = aniosVolando;
    }

    //MÉTODOS IMPLEMENTADOS DE LA INTERFAZ
    //SOBREESCRIBIMOS CON @Override
    @Override
    public String encenderObjeto() {
        return  "Soy el Piloto " + this.nombre + ", encendí mi nave";
    }

    @Override
    public String maniobrarObjeto() {
        return "Soy el Piloto " + this.nombre +", y llevo más de "+ this.aniosVolando +" años volando";
    }

    @Override
    public String apagarObjeto() {
        return "Soy el Piloto " +this.nombre +", apagué mi nave";
    }
    
}
