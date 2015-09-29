/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package vista;

import controlador.Coordinador;

/**
 * Crea una Panel con fondo y se le da un controlador o coordinador.
 *
 * @author Esteban 19/09/2015
 */
public class VentanaBase extends PanelConFondo{

    /************** Variables **************/
    protected Coordinador miCoordinador;

    /************* Constructor *************/
    public VentanaBase() {
        super("darkblue.png");
    }
    
    /*********** Getters/Setters ***********/
    public void setCoordinador(Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }

}
