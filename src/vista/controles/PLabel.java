/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.controles;

import controlador.Principal;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author David 21/09/2015
 */
public class PLabel extends JLabel{


    /************** Variables **************/

    /************* Constructor *************/
    public PLabel(String text) {
        super(text);
        setFont(Principal.fuente1);
        setForeground(new Color(159, 227, 255));
    }
    
    /****************Metodos****************/
    
    /*********** Getters/Setters ***********/

}
