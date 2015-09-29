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
import javax.swing.JOptionPane;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Se encarga de crear una ventana que muestra pos prestamos existentes y
 * permite finalizarlos.
 *
 * @author David 22/09/2015
 */
public class EliminarPrestamo extends VentanaBase {

    /************** Variables **************/
    JComboBox cmbPrestamos;
    
    /************* Constructor *************/
    public EliminarPrestamo(){
        JLabel titulo = new JLabel("Finalizar Préstamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        PLabel leyenda1 = new PLabel("Seleccione el préstamo a finalizar:");
        cmbPrestamos = new JComboBox();
        JButton eliminar = new JButton("Finalizar");
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int pos = cmbPrestamos.getSelectedIndex();
                for(Item pItem : Principal.getPrestamos().get(pos).getItems()){
                    pItem.noPrestado();
                }
                
                for(Persona p : Principal.getPersonas()){
                    for(int i = 0; i < p.getPrestamos().size(); i++){
                        if(p.getPrestamos().get(i) == Principal.getPrestamos().get(pos).getIdPrestamo()){
                            p.getPrestamos().remove(i);
                        }
                    }
                }
                
                Principal.getPrestamos().remove(pos);
                JOptionPane.showMessageDialog(getRootPane(), "El préstamo ha sido finalizado.");
                if(Principal.getPrestamos().size() > 0){
                    miCoordinador.getMiEliminarPrestamo().iniciar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarPrestamo());
                } else {
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminPrestamos());
                }
            }
        });
        
        leyenda1.setBounds(50, 50, 300, 30);
        cmbPrestamos.setBounds(50, 90, 150, 30);
        titulo.setBounds(250, 15, 350, 50);
        eliminar.setBounds(300, 300, 100, 30);
        
        add(titulo);
        add(leyenda1);
        add(cmbPrestamos);
        add(eliminar);
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
