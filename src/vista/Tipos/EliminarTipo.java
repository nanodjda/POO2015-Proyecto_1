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
import modelo.Item;
import modelo.Tipo;
import vista.VentanaBase;
import vista.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class EliminarTipo extends VentanaBase{

    /************** Variables **************/
    private JComboBox cmbTipo;
    private JScrollPane scrTipo;
    
    /************* Constructor *************/
    public EliminarTipo(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Eliminar Tipo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Tipos:");
        JLabel lblDescr = new PLabel("Seleccione el tipo a eliminar");
        
        cmbTipo = new JComboBox();
        scrTipo = new JScrollPane();
        scrTipo.setViewportView(cmbTipo);
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    int act = cmbTipo.getSelectedIndex();
                    Principal.getTipos().remove(act);
                    
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El tipo fue eliminado correctamente");
                    miCoordinador.getMiEliminarTipo().limpiar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarTipo());
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
        eliminar.setBounds(168, 250, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(lblDescr);
        add(scrTipo);
        add(eliminar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        cmbTipo.removeAllItems();
        for(Tipo pTipo : Principal.getTipos()) {
            cmbTipo.addItem(pTipo.getNombre());
        }
    }
    
    public void validar() throws Exception{
        if(cmbTipo.getSelectedIndex() == 0){
            throw new Exception("No puedes actualizar este valor.");
        }
        for(Item item: Principal.getItems()){
            if(item.getTipo().getNombre().equals(cmbTipo.getSelectedItem())){
                throw new Exception("No se puede eliminar este tipo \n"
                        + "ya que es usado por un item.");
            }
        }
    }
}
