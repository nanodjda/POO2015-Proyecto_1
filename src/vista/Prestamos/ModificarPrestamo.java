/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Prestamos;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import modelo.Prestamo;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Se encarga de crear una ventana en la que se puede elegir un prestamo a editar
 *
 * @author David 22/09/2015
 */
public class ModificarPrestamo extends VentanaBase {

    /************** Variables **************/
    JComboBox cmbPrestamos;
    
    /************* Constructor *************/
    public ModificarPrestamo(){
        JLabel titulo = new JLabel("Editar Prestamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        PLabel leyenda1 = new PLabel("Seleccione el préstamo a editar:");
        cmbPrestamos = new JComboBox();
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cmbPrestamos.getSelectedIndex();
                new EditarPrestamo(miCoordinador.getMiVentanaPrincipal(), 
                        "Editar Préstamo: " + Principal.getPrestamos().get(pos).getIdPrestamo(), 
                        700, 550, Principal.getPrestamos().get(pos)).setVisible(true);
            }
        });
        
        leyenda1.setBounds(50, 50, 300, 30);
        cmbPrestamos.setBounds(50, 90, 150, 30);
        titulo.setBounds(250, 15, 350, 50);
        modificar.setBounds(300, 300, 100, 30);
        
        add(titulo);
        add(leyenda1);
        add(cmbPrestamos);
        add(modificar);
    }
    
    /****************Metodos****************/
    public void iniciar(){
        cmbPrestamos.removeAllItems();
        ArrayList<String> var1 = new ArrayList<>();
        for(Prestamo pre : Principal.getPrestamos()){
            var1.add(String.valueOf(pre.getIdPrestamo()));
        }
        for(String str : var1) {
            cmbPrestamos.addItem(str);
        }
    }
}
