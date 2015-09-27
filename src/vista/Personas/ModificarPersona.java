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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import modelo.Item;
import modelo.Persona;
import vista.Items.ModificarItems;
import vista.VentanaBase;
import vista.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class ModificarPersona extends VentanaBase {

    /************** Variables **************/
    JComboBox cmbPerson;
    
    /************* Constructor *************/
    public ModificarPersona(){
        JLabel titulo = new JLabel("Editar Persona");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        PLabel leyenda1 = new PLabel("Seleccione la persona a editar:");
        cmbPerson = new JComboBox();
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cmbPerson.getSelectedIndex();
                EditarPersona nuevo = new EditarPersona(miCoordinador.getMiVentanaPrincipal(), 
                        "Modificar Persona: " + Principal.getPersonas().get(pos), 
                        700, 550, Principal.getPersonas().get(pos));
                nuevo.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent ex) {
                        miCoordinador.getMiModificarPersona().iniciar();
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarPersona());
                    }
                });
                
                nuevo.setVisible(true);
            }
        });
        
        leyenda1.setBounds(50, 50, 300, 30);
        cmbPerson.setBounds(50, 90, 150, 30);
        titulo.setBounds(250, 15, 350, 50);
        modificar.setBounds(300, 300, 100, 30);
        
        add(titulo);
        add(leyenda1);
        add(cmbPerson);
        add(modificar);
    }
    
    /****************Metodos****************/
    public void iniciar(){
        cmbPerson.removeAllItems();
        ArrayList<String> var1 = new ArrayList<>();
        for(Persona per : Principal.getPersonas()){
            var1.add(per.getNombre() + " " + 
                    per.getPrimerApellido() + " " + 
                    per.getSegundoApellido());
        }
        for(String str : var1) {
            cmbPerson.addItem(str);
        }
    }
    
    /*********** Getters/Setters ***********/
}
