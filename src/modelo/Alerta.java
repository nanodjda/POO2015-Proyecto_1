/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import java.io.Serializable;

/**
 *
 * @author David 17/09/2015
 */
public class Alerta implements Serializable {

    /************** Variables **************/
    private String tipo;
    
    /************* Constructor *************/
    public Alerta(String pTipo){
        this.tipo = pTipo;
    }

    /****************Metodos****************/

    
    /*********** Getters/Setters ***********/
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
