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
import modelo.Item;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Esta clase se encarga de crear el panel para mostrar los items y luego ver
 * individualmente cada uno por medio de verItem.
 * 
 * @author David 22/09/2015
 */
public class MostrarItem extends VentanaBase{
    /************** Variables **************/
    JComboBox cmbItems;
    /************* Constructor *************/
    public MostrarItem(){
        JLabel titulo = new JLabel("Mostrar Item");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setBounds(250, 15, 350, 50);
        add(titulo);
        
        PLabel leyenda1 = new PLabel("Seleccione el item a mostrar:");
        leyenda1.setBounds(50, 50, 250, 30);
        add(leyenda1);
       
        cmbItems = new JComboBox();
        cmbItems.setBounds(50, 90, 150, 30);
        add(cmbItems);
        
        JButton mostrar = new JButton("Mostrar");
        mostrar.setBounds(300, 300, 100, 30);
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cmbItems.getSelectedIndex();
                new VerItem(miCoordinador.getMiVentanaPrincipal(), "Ver item", 
                        700, 550, Principal.getItems().get(pos)).setVisible(true);
            }
        });
        add(mostrar);
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
    
    /*********** Getters/Setters ***********/
}

