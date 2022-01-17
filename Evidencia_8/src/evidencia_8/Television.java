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
public class Television extends Electrodomestico {//CLASE HIJA

    //ATRIBUTOS DE LA CLASE TELEVISION
    private int resolucion = 20;
    private boolean sintonizadorTDT = false;

    //CONSTRUCTOR POR DEFECTO
    public Television() {

    }

    //CONSTRUCTOR PERSONALIZADO
    public Television(int precioBase, String color, char consumoEnergetico, int peso, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso);//CON SUPER OBTENEMOS ACCESO A LOS ATRIBUTOS DE LA CLASE PADRE
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //METODOS DEL ENCAPSULAMIENTO
    /**
     * @return the resolucion
     */
    public int getResolucion() {
        return resolucion;
    }

    /**
     * @param resolucion the resolucion to set
     */
    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    /**
     * @return the sintonizadorTDT
     */
    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }

    /**
     * @param sintonizadorTDT the sintonizadorTDT to set
     */
    public void setSintonizadorTDT(boolean sintonizadorTDT) {
        this.sintonizadorTDT = sintonizadorTDT;
    }

    //METODO DONDE SE MODIFICA EL PRECIO BASE DEL OBJETO PARA OBTENER EL PRECIO FINAL
    @Override//SOBREESCRIBIMOS EL METODO
    public void precioFinal() {

        if (this.resolucion > 40) {
            int aux;
            aux = (30 * this.getPrecioBase()) / 100;
            this.setPrecioBase(this.getPrecioBase() + aux);
        }
        super.precioFinal();

        if (this.sintonizadorTDT) {
            this.setPrecioBase(this.getPrecioBase() + 500);
        }

    }

    //METODO PARA IMPRIMIR EN PANTALLA LOS ATRIBUTOS DEL OBJETO
    @Override//SOBREESCRIBIMOS EL METODO
    public void imprimir() {
        System.out.println("TELEVISIÓN");
        super.imprimir();
        System.out.println("Resolución: " + this.resolucion);
        if (this.sintonizadorTDT) {
            System.out.println("Sintonizador TDT: Si");
        } else {
            System.out.println("Sintonizador TDT: No");
        }
    }

}
