/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Items;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Item;
import modelo.Prestamo;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Esta clase se encarga de eliminar un item que es seleccionado por medio de un
 * combobox.
 *
 * @author David 22/09/2015
 */
public class EliminarItem extends VentanaBase{

    /************** Variables **************/
    JComboBox cmbItems;
    /************* Constructor *************/
    public EliminarItem(){
        JLabel titulo = new JLabel("Eliminar Item");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setBounds(250, 15, 350, 50);
        add(titulo);
        
        PLabel leyenda1 = new PLabel("Seleccione el item a eliminar:");
        leyenda1.setBounds(50, 50, 250, 30);
        add(leyenda1);
       
        cmbItems = new JComboBox();
        cmbItems.setBounds(50, 90, 150, 30);
        add(cmbItems);
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(300, 300, 100, 30);
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Principal.getItems().remove(cmbItems.getSelectedIndex());
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El item fue eliminado exitosamente.");
                    if(Principal.getItems().size() > 0){
                        miCoordinador.getMiEliminarItem().iniciar();
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarItem());
                    } else {
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminItems());
                    }
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), exc.getMessage());
                }
            }
        });
        add(eliminar);
    }
    
    /****************Metodos****************/
    public void iniciar(){
        cmbItems.removeAllItems();
        ArrayList<String> var1 = new ArrayList<>();
        for(Item it : Principal.getItems()){
            var1.add(it.getNombre());
        }
        for(String str : var1) {
            cmbItems.addItem(str);
        }
    }
    
    public void validar() throws Exception{
        for(Prestamo p : Principal.getPrestamos()){
            if(p.getItems().contains(Principal.getItems().get(cmbItems.getSelectedIndex()).getCodigo())){
                throw new Exception("El item está siendo usado en el \n "
                        + "préstamo " + p.getIdPrestamo());
            }
        }
    }
}
