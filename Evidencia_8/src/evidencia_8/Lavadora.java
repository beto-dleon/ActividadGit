/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia_8;

/**
 *
 * @author ALBERTO
 */
public class Lavadora extends Electrodomestico {//CLASE HIJA

    //ATRIBUTOS DE LA CLASE LAVADORA
    private int carga = 5;

    //CONSTRUCTOR POR DEFECTO
    public Lavadora() {

    }

    //CONSTRUCTOR PERSONALIZADO
    public Lavadora(int precioBase, String color, char consumoEnergetico, int peso, int carga) {
        super(precioBase, color, consumoEnergetico, peso);//CON SUPER OBTENEMOS ACCESO A LOS ATRIBUTOS DE LA CLASE PADRE
        this.carga = carga;
    }

    //METODOS DEL ENCAPSULAMIENTO
    /**
     * @return the carga
     */
    public int getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(int carga) {
        this.carga = carga;
    }

    //METODO DONDE SE MODIFICA EL PRECIO BASE DEL OBJETO PARA OBTENER EL PRECIO FINAL
    @Override//SOBREESCRIBIMOS EL METODO
    public void precioFinal() {
        super.precioFinal();

        if (this.carga > 30) {
            this.setPrecioBase(this.getPrecioBase() + 500);
        }

    }

    //METODO PARA IMPRIMIR EN PANTALLA LOS ATRIBUTOS DEL OBJETO
    @Override //SOBREESCRIBIMOS EL METODO
    public void imprimir() {
        System.out.println("LAVADORA");
        super.imprimir();
        System.out.println("Carga: " + this.carga);
    }

}
