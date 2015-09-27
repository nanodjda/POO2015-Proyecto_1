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
import java.util.Dictionary;
import java.util.Hashtable;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaBase;
import vista.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class AgregarPrestamo extends VentanaBase {

    /************** Variables **************/
    private JList cmbItems;
    private JComboBox cmbPersonas;
    private JScrollPane scrItems;
    private Persona seleccionado;
    private Dictionary items = new Hashtable();
    int pos = 0;
    
    /************* Constructor *************/
    
    public AgregarPrestamo() {
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        JLabel titulo = new JLabel("Crear Prestamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        DefaultListModel model = new DefaultListModel();
        cmbItems = new JList(model);
        scrItems = new JScrollPane();
        scrItems.setViewportView(cmbItems);
        
        cmbPersonas = new JComboBox();
        
        JLabel lblNombre = new PLabel("Persona:");
        JLabel lblItems = new PLabel("Items:");
        
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(10, 100, 100, 30);
        cmbPersonas.setBounds(10, 140, 300, 30);
        lblItems.setBounds(320, 100, 100, 30);
        scrItems.setBounds(320, 140, 100, 100);
        
        JButton agregar = new JButton("Crear");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Prestamo nuevo = new Prestamo(Principal.getPersonas().get(cmbPersonas.getSelectedIndex()));
                    for(Integer x : cmbItems.getSelectedIndices()){
                        nuevo.agregarItem(items.get(x).toString());
                    }
                    Principal.setPrestamo(nuevo);
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El préstamo ha sido creado.");
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminPrestamos());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(cmbPersonas);
        add(scrItems);
        add(lblItems);
        add(agregar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        cmbPersonas.removeAllItems();
        for(Persona per : Principal.getPersonas()) {
            cmbPersonas.addItem(per.getNombre() + " " + per.getPrimerApellido() + " " + per.getSegundoApellido());
        }
        
        DefaultListModel model = new DefaultListModel();
        pos = 0;
        for(Item ite : Principal.getItems()) {
            if(ite.getEstado()==false){
                model.addElement(ite.getNombre());
                items.put(pos, ite.getCodigo());
                pos += 1;
            }
        }
        cmbItems = new JList(model);
        scrItems.setViewportView(cmbItems);
    }
    
    public void validar() throws Exception{
        if(cmbItems.getSelectedValuesList().isEmpty()){
            throw new Exception("Debe seleccionar minimo un item\n"
                    + "para crear el préstamo.");
        }
    }
}
