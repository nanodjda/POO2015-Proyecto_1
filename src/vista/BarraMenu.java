/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author David 17/09/2015
 */
public class BarraMenu extends JMenuBar{

    /************** Variables **************/
    private JMenu archivo = new JMenu("Archivo");
    private JMenuItem mSalir = new JMenuItem("Salir");
    
    /************* Constructor *************/
    public BarraMenu(){
        this.add(archivo);
        mSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        archivo.add(mSalir);
        
    }
    
    /****************Metodos****************/

    /*********** Getters/Setters ***********/

}
