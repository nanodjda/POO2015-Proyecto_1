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
public class Item {

    /************** Variables **************/
    private String nombre;
    private String codigo;
    private String descripcion;
    private boolean estado = false;
    private String imagenURL;
    
            
    /************* Constructor *************/
    public Item(String pNombre, String pCodigo, String pDescripcion){
        this.nombre = pNombre;
        this.codigo = pCodigo;
        this.descripcion = pDescripcion;
    }

    /****************Metodos****************/
    public void prestar() {
        this.estado = false;
    }

    public void dimitirPrestamo() {
        this.estado = true;
    }
    
    /*********** Getters/Setters ***********/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
  
}
