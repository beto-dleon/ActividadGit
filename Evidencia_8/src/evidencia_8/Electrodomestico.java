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
public class Electrodomestico {//CLASE PADRE

    //ATRIBUTOS DE LA CLASE ELECTRODOMESTICO
    private int precioBase = 1000;
    private String color = "blanco";
    private char consumoEnergetico = 'F';
    private int peso = 5;

    //CONSTRUCTOR POR DEFECTO
    public Electrodomestico() {

    }

    //CONSTRUCTOR PERSONALIZADO
    public Electrodomestico(int precioBase, String color, char consumoEnergetico, int peso) {

        this.precioBase = precioBase;
        this.color = color;
        comprobarColor(this.color);
        this.consumoEnergetico = consumoEnergetico;
        comprobarConsumoEnergetico(this.consumoEnergetico);
        this.peso = peso;

    }

    //METODO QUE COMPRUEBA QUE EL CONSUMO ENERGETICO SE ENCUENTRA EN EL RANGO CORRECTO
    //DE NO SER ASI, TOMA EL VALOR POR DEFECTO ESTABLECIDO
    public char comprobarConsumoEnergetico(char letra) {
        if ((letra != 'A') && (letra != 'a') && (letra != 'B') && (letra != 'b') && (letra != 'C') && (letra != 'c') && (letra != 'D') && (letra != 'd') && (letra != 'E') && (letra != 'e') && (letra != 'F') && (letra != 'f')) {
            this.consumoEnergetico = 'F';
            return this.consumoEnergetico;
        } else {
            return letra;
        }
    }

    //METODO QUE COMPRUEBA QUE EL COLOR SEA UN COLOR ACEPTABLE DENTRO DE LA LISTA DADA
    //DE NO SER ASI, TOMA EL VALOR POR DEFECTO ESTABLECIDO
    public String comprobarColor(String color) {
        if ((color.equalsIgnoreCase("blanco")) || (color.equalsIgnoreCase("negro")) || (color.equalsIgnoreCase("rojo")) || (color.equalsIgnoreCase("azul")) || (color.equalsIgnoreCase("gris"))) {
            return color;
        } else {
            this.color = "blanco";
            return this.color;
        }
    }

    //METODO DONDE SE MODIFICA EL PRECIO BASE DEL OBJETO PARA OBTENER EL PRECIO FINAL
    public void precioFinal() {
        switch (this.consumoEnergetico) {
            case 'A':
                this.precioBase += 1000;
                break;
            case 'a':
                this.precioBase += 1000;
                break;
            case 'B':
                this.precioBase += 800;
                break;
            case 'b':
                this.precioBase += 800;
                break;
            case 'C':
                this.precioBase += 600;
                break;
            case 'c':
                this.precioBase += 600;
                break;
            case 'D':
                this.precioBase += 500;
                break;
            case 'd':
                this.precioBase += 500;
                break;
            case 'E':
                this.precioBase += 300;
                break;
            case 'e':
                this.precioBase += 300;
                break;
            case 'F':
                this.precioBase += 100;
                break;
            case 'f':
                this.precioBase += 100;
                break;
        }

        if (this.peso >= 0 && this.peso <= 19) {
            this.precioBase += 100;
        }

        if (this.peso >= 20 && this.peso <= 49) {
            this.precioBase += 500;
        }

        if (this.peso >= 50 && this.peso <= 79) {
            this.precioBase += 800;
        }

        if (this.peso > 80) {
            this.precioBase += 1000;
        }

    }

    //METODOS DEL ENCAPSULAMIENTO
    /**
     * @return the precioBase
     */
    public int getPrecioBase() {
        return precioBase;
    }

    /**
     * @param precioBase the precioBase to set
     */
    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the consumoEnergetico
     */
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    /**
     * @param consumoEnergetico the consumoEnergetico to set
     */
    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    //METODO PARA IMPRIMIR EN PANTALLA LOS ATRIBUTOS DEL OBJETO
    public void imprimir() {
        System.out.println("Precio base: " + this.precioBase);
        System.out.println("Color: " + this.color);
        System.out.println("Consumo energético: " + this.consumoEnergetico);
        System.out.println("Peso: " + this.peso);
    }

}
