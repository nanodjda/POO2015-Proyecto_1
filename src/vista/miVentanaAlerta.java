/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Crea una ventana que posee una Tabla y recibe un conjunto de datos como parametro.
 *
 * @author David 28/09/2015
 */
public class miVentanaAlerta extends VentanaEmergente {

    /************* Constructor *************/
    /**
     * Crea una ventana emergente con los siguientes parametros:
     * 
     * @param frame - Frame padre del JDialog.
     * @param pString - Titulo de la ventana.
     * @param x - Ancho de la ventana.
     * @param y - Alto de la ventana.
     * @param dtm - DefaultTableModel para cargar los datos en la tabla.
     */
    public miVentanaAlerta(JFrame frame, String pString, int x, int y, DefaultTableModel dtm){
        super(null, pString, x, y);
        JLabel titulo = new JLabel("Alertas");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        JButton cerrar = new JButton("Cerrar");
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        titulo.setBounds(300, 15, 350, 50);
        scrollPane.setBounds(50, 100, 600, 300);
        cerrar.setBounds(550, 425, 100, 30);
        
        add(titulo);
        add(scrollPane);
        add(cerrar);
    }
}
