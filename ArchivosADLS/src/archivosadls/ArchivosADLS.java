/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivosadls;

//Imports utilizados
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ALBERTO
 */
public class ArchivosADLS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
            FileWriter archivo = null;//CREA EL ARCHIVO
            FileReader archivoOpen = null;//ABRE EL ARCHIVO EN MODO LECTURA
            BufferedReader lector = null;//COMIENZA LECTURA DEL ARCHIVO
            PrintWriter escribir = null;//SOBREESCRIBE EN EL ARCHIVO Y SE ABRE EN MODO ESCRITURA
            String linea;// VARIABLE STRING QUE SE IMPRIME DENTRO DEL ARCHIVO
            
            //PROCESO DE CREACION DEL ARCHIVO
            try{
                archivo = new FileWriter("ADLS.txt");
                escribir = new PrintWriter(archivo);
                linea = "Alberto De León Salinas";
                escribir.println(linea);
            }catch(Exception e){
                System.out.println(e.toString());
            }finally{
                escribir.close();//CERRAMOS EL ARCHIVO EN MODO ESCRITURA
            }
            
            //PROCESO DE LECTURA DEL ARCHIVO
            try{
                // IMPORTANTE VERIFICAR LA RUTA DE ACCESO AL ARCHIVO SEGÚN DONDE SE ENCUENTRE EN TU ALMACENAMIENTO DE LA PC
                archivoOpen = new FileReader("C:\\Users\\ALBERTO\\Documents\\ActividadGit\\ArchivosADLS\\ADLS.txt");
                lector = new BufferedReader(archivoOpen);
                while((linea = lector.readLine())!= null){
                    System.out.println(linea);
                }
            }catch(Exception e){
                System.out.println(e.toString());
            }finally{
                try{
                    archivoOpen.close();//CERRAMOS EL ARCHIVO EN MODO LECTURA
                }catch(IOException ex){
                    System.out.println(ex.toString());
                }
            }
            
    }
    
}
