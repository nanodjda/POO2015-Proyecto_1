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
public class Tipo {

    /************** Variables **************/
    private String nombre;
    private String Descripcion;

    /************* Constructor *************/
    public Tipo(String nombre, String Descripcion) {
        this.nombre = nombre;
        this.Descripcion = Descripcion;
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
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
}
