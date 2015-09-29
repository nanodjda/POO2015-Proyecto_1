/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import java.io.Serializable;

/**
 * Instancia un nuevo Tipo en el sistema.
 * Da facilidad de cambiar el nombre del tipo y 
 * que esta cambie en todos los items.
 * 
 * @author David 24/09/2015
 */
public class Tipo implements Serializable{

    /************** Variables **************/
    private String nombre;

    /************* Constructor *************/
    /**
     * Recibe como parametro el nombre del tipo
     * @param pNombre - Nombre del tipo
     */
    public Tipo(String pNombre){
        this.nombre = pNombre;
    }

    /****************Metodos****************/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /*********** Getters/Setters ***********/

}
