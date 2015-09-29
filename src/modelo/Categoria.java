/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import java.io.Serializable;

/**
 * Se encarga de instanciar una categoria con un nombre
 * Da facilidad de cambiar el nombre de la categoría y 
 * que esta cambie en todos los items.
 * 
 * @author David 24/09/2015
 */
public class Categoria implements Serializable {

    /************** Variables **************/
    private String nombre;

    /************* Constructor *************/
    /**
     * Recibe como parametro el nombre de la categoria.
     * @param pNombre - Nombre de la categoria.
     */
    public Categoria(String pNombre){
        this.nombre = pNombre;
    }

    /*********** Getters/Setters ***********/

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
