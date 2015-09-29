/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
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
import vista.PLabel;
import vista.VentanaBase;

/**
 * Se encarga de mostrar un panel que administra los reportes
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
        
        JLabel lblPersona = new PLabel("Reporte de Personas");
        lblPersona.setBounds(100, 130, 150, 40);
        add(lblPersona);
        usuario = new BotonFondo("reportPersona.png", 100, 150, 150, 150);
        usuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(Principal.getPersonas().isEmpty()){
                        throw new Exception("No hay personas para mostrar.");
                    }
                    miCoordinador.getMiMostrarPersona().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiMostrarPersona());
                } catch (Exception d) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), d.getMessage());
                }
            }
        });
        add(usuario);
        
        
        JLabel lblItems = new PLabel("Reporte de Items");
        lblItems.setBounds(410, 130, 150, 40);
        add(lblItems);
        item = new BotonFondo("reportItem.png", 400, 150, 150, 150);
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiReporteItems().iniciar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiReporteItems());
            }
        });
        add(item);
        
        JLabel lblTipos = new PLabel("Reporte de Tipos");
        lblTipos.setBounds(110, 300, 150, 40);
        add(lblTipos);
        categoria = new BotonFondo("report.png", 100, 320, 150, 150);
        categoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiReporteTipos().iniciar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiReporteTipos());
            }
        });
        add(categoria);
        
        JLabel lblCategorias = new PLabel("Reporte de Categorias");
        lblCategorias.setBounds(390, 300, 200, 40);
        add(lblCategorias);
        tipo = new BotonFondo("report.png", 400, 320, 150, 150);
        tipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiReporteCategorias().iniciar();
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiReporteCategorias());
            }
        });
        add(tipo);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
}
