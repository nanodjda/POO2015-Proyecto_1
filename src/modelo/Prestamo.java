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
public class Prestamo {

    /************** Variables **************/
    private String idPrestamo;

    /************* Constructor *************/
    public Prestamo(String pIDPrestamo){
        this.idPrestamo = pIDPrestamo;
    }

    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }
    
}
