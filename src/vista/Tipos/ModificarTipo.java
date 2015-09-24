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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Item;
import vista.VentanaBase;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class ModificarTipo extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre;
    private JComboBox cmbTipo;
    private JScrollPane scrTipo;
    
    /************* Constructor *************/
    public ModificarTipo(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Modificar Tipo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Tipos:");
        JLabel lblnewNombre = new PLabel("Nuevo nombre:");
        JLabel lblDescr = new PLabel("Seleccione el tipo a modificar");
        
        txtNombre = new JTextField(20);
        cmbTipo = new JComboBox(Principal.getTipos().toArray());
        scrTipo = new JScrollPane();
        scrTipo.setViewportView(cmbTipo);
        
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    int act = cmbTipo.getSelectedIndex();
                    Principal.getTipos().set(act, txtNombre.getText());
                    for(Item item: Principal.getItems()){
                        if(item.getTipo().equals(cmbTipo.getSelectedItem())){
                            item.setTipo(txtNombre.getText());
                        }
                    }
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El tipo fue actualizado correctamente");
                    miCoordinador.getMiModificarTipo().limpiar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarTipo());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        lblDescr.setBounds(270, 100, 300, 30);
        scrTipo.setBounds(110, 100, 150, 30);
        lblnewNombre.setBounds(38, 210, 200, 30);
        txtNombre.setBounds(38, 250, 120, 30);
        modificar.setBounds(168, 250, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(lblDescr);
        add(scrTipo);
        add(lblnewNombre);
        add(txtNombre);
        add(modificar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        txtNombre.setText("");
        cmbTipo.removeAllItems();
        for(String str : Principal.getTipos()) {
            cmbTipo.addItem(str);
        }
    }
    
    public void validar() throws Exception{
        if(cmbTipo.getSelectedIndex() == 0){
            throw new Exception("No puedes actualizar este valor.");
        }
        
        if(txtNombre.getText().equals("")){
            throw new Exception("Debes llenar el campo con el nuevo valor.");
        }
        
        for(String str : Principal.getTipos()){
            if(txtNombre.getText().equals(str)){
                throw new Exception("Ya existe este tipo.");
            }
        }
    }
}
