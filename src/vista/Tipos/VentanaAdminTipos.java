/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Tipos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import vista.BotonFondo;
import vista.VentanaBase;

/**
 * Se encarga de mostrar una ventana para administrar los tipos.
 *
 * @author David 19/09/2015
 */
public class VentanaAdminTipos extends VentanaBase{

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminTipos(){
        
        JLabel titulo = new JLabel("Tipos");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(280, 25, 100, 50);
        add(titulo);
        
        crear = new BotonFondo("newType.png", 100, 100, 150, 150);
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiAgregarTipo().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarTipo());
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editType.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiModificarTipo().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarTipo());
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deleteType.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiEliminarTipo().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarTipo());
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchType.png", 400, 300, 150, 150);
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiMostrarTipo().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarTipo());
            }
        });
        add(consultar);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
