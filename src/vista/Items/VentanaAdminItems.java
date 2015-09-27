/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Items;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import vista.BotonFondo;
import vista.VentanaBase;

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
                try {
                    if(Principal.getTipos().size() == 1){ throw new Exception("No hay tipos agregados.");}
                    if(Principal.getCategorias().isEmpty()){ throw new Exception("No hay categorías agregadas.");}
                    miCoordinador.getMiAgregarItem().limpiarComponentes();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarItem()); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), ex.getMessage());
                }
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editItem.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getItems().isEmpty()){ throw new Exception("No hay items agregados.");}
                    miCoordinador.getMiEditarItems().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEditarItems());
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), c.getMessage());
                }
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deleteItem.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getItems().isEmpty()){ throw new Exception("No hay items agregados.");}
                    miCoordinador.getMiEliminarItem().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarItem());
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), c.getMessage());
                }
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchItem.png", 400, 300, 150, 150);
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getItems().isEmpty()){ throw new Exception("No hay items agregados.");}
                    miCoordinador.getMiMostrarItem().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarItem());
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), c.getMessage());
                }
            }
        });
        add(consultar);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
