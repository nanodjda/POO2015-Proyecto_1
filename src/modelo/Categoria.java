/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

/**
 *
 * @author David 24/09/2015
 */
public class Categoria {

    /************** Variables **************/
    private String nombre;

    /************* Constructor *************/
    public Categoria(String pNombre){
        this.nombre = pNombre;
    }

    /****************Metodos****************/

    /*********** Getters/Setters ***********/

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
