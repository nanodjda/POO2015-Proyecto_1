/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Personas;

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
import modelo.Persona;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Se encarga de crear la ventana para eliminar una persona.
 *
 * @author David 22/09/2015
 */
public class EliminarPersona extends VentanaBase {
/************** Variables **************/
    JComboBox cmbPerson;
    /************* Constructor *************/
    public EliminarPersona(){
        JLabel titulo = new JLabel("Eliminar Persona");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        PLabel leyenda1 = new PLabel("Seleccione la persona a eliminar:");
        cmbPerson = new JComboBox();
        
        cmbPerson.setBounds(50, 90, 150, 30);
        leyenda1.setBounds(50, 50, 250, 30);
        titulo.setBounds(250, 15, 350, 50);
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(300, 300, 100, 30);
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    int pos = cmbPerson.getSelectedIndex();
                    Principal.getPersonas().remove(pos);
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "La persona fue eliminada exitosamente.");
                    if(Principal.getPersonas().size() > 0){
                        miCoordinador.getMiEliminarPersona().iniciar();
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarPersona());
                    } else {
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminPersonas());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(eliminar);
        add(titulo);
        add(cmbPerson);
        add(leyenda1);
    }
    
    /****************Metodos****************/
    public void iniciar(){
        cmbPerson.removeAllItems();
        ArrayList<String> var1 = new ArrayList<>();
        for(Persona per : Principal.getPersonas()){
            var1.add(per.getNombre() + " " + per.getPrimerApellido() + " " + per.getSegundoApellido());
        }
        for(String str : var1) {
            cmbPerson.addItem(str);
        }
    }
    
    public void validar() throws Exception{
        int pos = cmbPerson.getSelectedIndex();
        if(!Principal.getPersonas().get(pos).getPrestamos().isEmpty()){
            throw new Exception("No se puede eliminar esta persona\n"
                    + "debido a que tiene prestamos pendientes.");
        }
    }
}