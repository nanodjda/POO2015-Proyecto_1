/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Reportes;

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
 * @author David 25/09/2015
 */
public class VentanaAdminReportes extends VentanaBase {

    /************** Variables **************/
    private JButton usuario, item, categoria, tipo;
    
    /************* Constructor *************/
    public VentanaAdminReportes(){
        
        JLabel titulo = new JLabel("Reportes");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 34));
        titulo.setBounds(250, 25, 200, 50);
        add(titulo);
        
        usuario = new BotonFondo("reportPersona.png", 100, 100, 150, 150);
        usuario.addActionListener(new ActionListener() {
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
        add(usuario);
        
        item = new BotonFondo("reportItem.png", 400, 100, 150, 150);
        item.addActionListener(new ActionListener() {
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
        add(item);
        
        categoria = new BotonFondo("deletePrestamo.png", 100, 300, 150, 150);
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPrestamos().isEmpty()){
                        throw new Exception("No hay prestamos para eliminar.");
                    }
                    miCoordinador.getMiEliminarPrestamo().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarPrestamo());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(categoria);
        
        tipo = new BotonFondo("report.png", 400, 300, 150, 150);
        tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPrestamos().isEmpty()){
                        throw new Exception("No hay prestamos para mostrar.");
                    }
                    miCoordinador.getMiMostrarPrestamo().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarPrestamo());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(tipo);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
