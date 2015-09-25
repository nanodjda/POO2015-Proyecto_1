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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaEmergente;
import vista.controles.PLabel;

/**
 *
 * @author David 23/09/2015
 */
public class EditarPrestamo extends VentanaEmergente {

    /************** Variables **************/
    private JList cmbItems;
    private JTextField txtPersona;
    private JScrollPane scrItems;
    private Persona seleccionado;
    private Dictionary items = new Hashtable();
    int pos = 0;

    /************* Constructor *************/
    
    public EditarPrestamo(JFrame frame, String title, int ancho, int alto, Prestamo pPrestamo) {
        super(frame, title, ancho, alto);
        
        JLabel titulo = new JLabel("Editar Prestamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        DefaultListModel model = new DefaultListModel();
        for(Item ite : Principal.getItems()) {
            if(ite.getEstado() == false || pPrestamo.getItems().contains(ite.getCodigo())){
                model.addElement(ite.getNombre());
                items.put(pos, ite.getCodigo());
                pos += 1;
            }
        }
        
        cmbItems = new JList(model);
        scrItems = new JScrollPane();
        scrItems.setViewportView(cmbItems);
        
        txtPersona = new JTextField(pPrestamo.getPersona().getNombre() + " " +
                pPrestamo.getPersona().getPrimerApellido() + " " + 
                pPrestamo.getPersona().getSegundoApellido(), 20);
        txtPersona.enable(false);
        txtPersona.setDisabledTextColor(Color.black);
        
        JLabel lblNombre = new PLabel("Persona:");
        JLabel lblItems = new PLabel("Items:");
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(10, 100, 100, 30);
        txtPersona.setBounds(10, 140, 300, 30);
        lblItems.setBounds(320, 100, 100, 30);
        scrItems.setBounds(320, 140, 100, 100);
        
        JButton agregar = new JButton("Editar");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    for(String str : pPrestamo.getItems()){
                        for(Item it : Principal.getItems()){
                            if(it.getCodigo().equals(str)){
                                it.noPrestado();
                            }
                        }
                    }
                    pPrestamo.getItems().clear();
                    for(Integer x : cmbItems.getSelectedIndices()){
                        pPrestamo.agregarItem(items.get(x).toString());
                    }
                    JOptionPane.showMessageDialog(getRootPane(), "El préstamo ha sido editado.");
                    dispose();
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(getRootPane(),c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(txtPersona);
        add(scrItems);
        add(lblItems);
        add(agregar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        
    }
    
    public void validar() throws Exception{
        if(cmbItems.getSelectedValuesList().isEmpty()){
            throw new Exception("Debe seleccionar minimo un item\n"
                    + "para crear el préstamo.");
        }
    }
}
