/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Reportes;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Item;
import modelo.Tipo;
import vista.PLabel;
import vista.VentanaBase;

/**
 * Se encarga de mostrar una ventana que contiene una tabla y se llena
 * de acuerdo al tipo seleccionado.
 *
 * @author David 28/09/2015
 */
public class ReporteTipos extends VentanaBase {

    /************** Variables **************/
    private String[] columnNames = {"Item",
                            "Descripcion",
                            "Estado",
                            "Poseedor"};
    private Object[][] data = {};
    private DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
    
    private JComboBox cmbTipos;

    /************* Constructor *************/
    
    public ReporteTipos(){
        JLabel titulo = new JLabel("Reporte de Tipos");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        JLabel tipos = new PLabel("Tipo: ");
        cmbTipos = new JComboBox();
        cmbTipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Tipo pTipo : Principal.getTipos()){
                    if(pTipo.getNombre().equals(cmbTipos.getSelectedItem())){
                        llenar(pTipo);
                    }
                }
            }
        });
        
        titulo.setBounds(225, 15, 350, 50);
        tipos.setBounds(35, 100, 100, 30);
        cmbTipos.setBounds(100, 100, 100, 30);
        scrollPane.setBounds(35, 150, 565, 300);
        
        add(titulo);
        add(tipos);
        add(cmbTipos);
        add(scrollPane);
    }

    /****************Metodos****************/
    
    public void iniciar(){
        dtm.setRowCount(0);
        cmbTipos.removeAllItems();
        
        for(Tipo t : Principal.getTipos()){
            cmbTipos.addItem(t.getNombre());
        }
    }
    
    public void llenar(Tipo pTipo){
        dtm.setRowCount(0);
        ArrayList<Item> alfabetico = (ArrayList<Item>) Principal.getItems().clone();
        ordenarItems(alfabetico);
        for(Item pItem : alfabetico){
            if(pItem.getTipo().equals(pTipo)){
                String txt1 = pItem.getNombre();
                String txt2 = pItem.getDescripcion();
                String txt3 = (pItem.getEstado()) ? "Prestado" : "Disponible";
                String txt4;
                if(pItem.getEstado()){
                    txt4 = pItem.getPoseedor().getNombre() + " " +
                            pItem.getPoseedor().getPrimerApellido() + " " +
                            pItem.getPoseedor().getSegundoApellido();
                } else {
                    txt4 = "Nadie";
                }

                Object[] newRow={txt1, txt2, txt3, txt4};
                dtm.addRow(newRow);
            }
        }
    }
    
    public static void ordenarItems(ArrayList<Item> pArray){
        Collections.sort(pArray, new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2) {
                    return o1.getNombre().compareTo(o2.getNombre());
            }
        });
    }
    /*********** Getters/Setters ***********/

}
