/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Prestamos;

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
 * @author David 22/09/2015
 */
public class VentanaAdminPrestamos extends VentanaBase {

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminPrestamos(){
        
        JLabel titulo = new JLabel("Prestamos");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(250, 25, 200, 50);
        add(titulo);
        
        crear = new BotonFondo("newPrestamo.png", 100, 100, 150, 150);
        crear.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para dar prestamos.");
                    } else if(Principal.getItems().isEmpty()){
                        throw new Exception("No hay items para dar prestamos.");
                    }
                    miCoordinador.getMiAgregarPrestamo().limpiar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarPrestamo());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editPrestamo.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPrestamos().isEmpty()){
                        throw new Exception("No hay prestamos para editar.");
                    }
                    miCoordinador.getMiModificarPrestamo().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarPrestamo());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deletePrestamo.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para eliminar.");
                    }
                    miCoordinador.getMiEliminarPrestamo().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarPrestamo());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchPrestamo.png", 400, 300, 150, 150);
        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para eliminar.");
                    }
                    miCoordinador.getMiMostrarPersona().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarPersona());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(consultar);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
