/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Categorias;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import vista.BotonFondo;
import vista.VentanaBase;

/**
 *
 * @author David 19/09/2015
 */
public class VentanaAdminCate extends VentanaBase{

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminCate(){
        
        JLabel titulo = new JLabel("Categorías");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(240, 25, 200, 50);
        add(titulo);
        
        crear = new BotonFondo("newType.png", 100, 100, 150, 150);
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiAgregarCategoria().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarCategoria());
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editType.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiModificarCategoria().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarCategoria());
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deleteType.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiEliminarCategoria().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarCategoria());
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchType.png", 400, 300, 150, 150);
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiMostrarCategoria().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarCategoria());
            }
        });
        add(consultar);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
