/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Principal;
import java.awt.Color;
import javax.swing.JRadioButton;

/**
 *
 * @author David 27/09/2015
 */
public class PRadioButton extends JRadioButton {

    /************** Variables **************/

    /************* Constructor *************/
    public PRadioButton(String pTitulo){
        super(pTitulo);
        setFont(Principal.fuente1);
        setForeground(new Color(159, 227, 255));
        setOpaque(false);
    }

    /****************Metodos****************/

    /*********** Getters/Setters ***********/

}
