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
public class InterfacesADLS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //CREACIÓN DE LOS OBJETOS
        Piloto pilot = new Piloto("Brandon Rodríguez", "19");
        Desarrollador des = new Desarrollador("André Cruz", "355");
        Cocinero coci = new Cocinero("Daniel Romero", "7");
        
        //IMPRIMIMOS EN CONSOLA LOS MÉTODOS PARA CADA OBJETO
        System.out.println(pilot.encenderObjeto());
        System.out.println(pilot.maniobrarObjeto());
        System.out.println(pilot.apagarObjeto());
        
        System.out.println("\n");
        
        System.out.println(des.encenderObjeto());
        System.out.println(des.maniobrarObjeto());
        System.out.println(des.apagarObjeto());
        
        System.out.println("\n");
        
        System.out.println(coci.encenderObjeto());
        System.out.println(coci.maniobrarObjeto());
        System.out.println(coci.apagarObjeto());
        
    }
    
}
