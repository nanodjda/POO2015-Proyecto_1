/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Personas;

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
public class VentanaAdminPersonas extends VentanaBase{

    /************** Variables **************/
    private JButton crear, modificar, borrar, consultar;
    
    /************* Constructor *************/
    public VentanaAdminPersonas(){
        
        JLabel titulo = new JLabel("Personas");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(250, 25, 200, 50);
        add(titulo);
        
        crear = new BotonFondo("newPerson.png", 100, 100, 150, 150);
        crear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiAgregarPersona().limpiar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiAgregarPersona());
            }
        });
        add(crear);
        
        modificar = new BotonFondo("editPerson.png", 400, 100, 150, 150);
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para editar.");
                    }
                    miCoordinador.getMiModificarPersona().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarPersona());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(modificar);
        
        borrar = new BotonFondo("deletePerson.png", 100, 300, 150, 150);
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para eliminar.");
                    }
                    miCoordinador.getMiEliminarPersona().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarPersona());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(borrar);
        
        consultar = new BotonFondo("searchPerson.png", 400, 300, 150, 150);
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
