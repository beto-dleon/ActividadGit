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

//INTERFAZ CREADA E IMPLEMENTADA EN LAS CLASES Piloto, Desarrollador y Cocinero
public interface Interfaz {
    
    //UTILIZAMOS MÉTODOS ABSTRACTOS EN LA INTERFAZ Y SOBREESCRIBIMOS EN LAS CLASES CON @Override
    public String encenderObjeto();
    public String maniobrarObjeto();
    public String apagarObjeto();
    
}
