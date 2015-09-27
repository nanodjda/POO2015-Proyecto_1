/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import java.io.Serializable;

/**
 *
 * @author David 24/09/2015
 */
public class Tipo implements Serializable{

    /************** Variables **************/
    private String nombre;

    /************* Constructor *************/
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
