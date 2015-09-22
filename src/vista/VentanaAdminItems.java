/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author David 19/09/2015
 */
public class VentanaAdminItems extends VentanaBase{

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminItems(){
        
        JLabel titulo = new JLabel("Items");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(280, 25, 100, 50);
        add(titulo);
        
        crear = new BotonFondo("newItem.png", 100, 100, 150, 150);
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiAgregarItem().limpiarComponentes();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarItem());
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editItem.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaItems());
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deleteItem.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaItems());
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchItem.png", 400, 300, 150, 150);
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
