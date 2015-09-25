/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Tipos;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Tipo;
import vista.VentanaBase;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class MostrarTipo extends VentanaBase{

    /************** Variables **************/
    private JList cmbTipo;
    private JScrollPane scrTipo;
    
    /************* Constructor *************/
    public MostrarTipo(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Mostrar Tipos");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Tipos:");
        
        DefaultListModel model = new DefaultListModel();
        for(Tipo pTipo : Principal.getTipos()) {
            model.addElement(pTipo.getNombre());
        }
        
        cmbTipo = new JList(model);
        scrTipo = new JScrollPane();
        scrTipo.setViewportView(cmbTipo);
        
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminTipos());
            }
        });
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        scrTipo.setBounds(110, 100, 150, 200);
        aceptar.setBounds(160, 350, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(scrTipo);
        add(aceptar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        DefaultListModel model = new DefaultListModel();
        for(Tipo pTipo : Principal.getTipos()) {
            model.addElement(pTipo.getNombre());
        }
        cmbTipo = new JList(model);
        scrTipo.setViewportView(cmbTipo);
    }
}