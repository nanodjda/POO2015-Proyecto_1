/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David 28/09/2015
 */
public class miVentanaAlerta extends VentanaEmergente {

    /************** Variables **************/
    
    /************* Constructor *************/
    public miVentanaAlerta(JFrame frame, String pString, int x, int y, DefaultTableModel dtm){
        super(null, pString, x, y);
        JLabel titulo = new JLabel("Alertas");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        titulo.setBounds(300, 15, 350, 50);
        scrollPane.setBounds(35, 100, 600, 300);
        
        add(titulo);
        add(scrollPane);
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/

}
