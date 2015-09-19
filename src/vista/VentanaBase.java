/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;

/**
 *
 * @author David 19/09/2015
 */
public class VentanaBase extends PanelConFondo{

    /************** Variables **************/
    protected Coordinador miCoordinador;

    public VentanaBase() {
        super("darkblue.png");
    }
    
    /************* Constructor *************/

    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public void setCoordinador(Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }

}
