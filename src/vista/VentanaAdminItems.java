/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author David 19/09/2015
 */
public class VentanaAdminItems extends VentanaBase{

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminItems(){
        
        consultar = new JButton("Consultar");
        consultar.setBounds(400, 300, 100, 100);
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaItems());
            }
            
        });
        add(consultar);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
