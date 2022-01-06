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
public class EdadException extends Exception {//LA NUEVA CLASE HEREDA DE LA CLASE Exception
    
    public static final long serialVersionUID = 700L;
    
    public EdadException(){//CONSTRUCTOR
        
    }
    
    public EdadException(String mensaje){//CONSTRUCTOR PERSONALIZADO PARA MOSTRAR MENSAJE DE LA CLASE PADRE
        super(mensaje);
    }
    
    public EdadException(int edad) throws EdadException{//CONSTRUCTOR PERSONALIZADO DONDE INGRESA UNA EDAD
       this.validarEdad(edad);
    }
    
    public void validarEdad(int edad) throws EdadException{// METODO QUE VALIDA QUE LA EDAD ESTE ENTRE 18 Y 45 AÑOS
        if(edad<18 || edad>45){
            throw new EdadException("EDAD NO VÁLIDA, INGRESAR UNA EDAD ENTRE 18 Y 45 AÑOS");//LA INSTRUCCIÓN THROW AYUDA A ARROJAR EXCEPCIONES PERSONALIZADAS
        }
    }
    
    
}
