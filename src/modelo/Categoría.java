/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

/**
 *
 * @author David 17/09/2015
 */
public class Categoría {

    /************** Variables **************/
    private String nombre;
    private String descripcion;
   
    /************* Constructor *************/
    public Categoría(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    /****************Metodos****************/

    
    
    /*********** Getters/Setters ***********/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
