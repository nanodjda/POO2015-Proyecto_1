/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Reportes;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Item;
import vista.VentanaBase;

/**
 * Se encarga de mostrar una tabla que se llena segun el tipo seleccionado
 *
 * @author David 27/09/2015
 */
public class ReporteItems extends VentanaBase {

    /************** Variables **************/

    private String[] columnNames = {"Item",
                            "Descripcion",
                            "Estado",
                            "Poseedor"};
    private Object[][] data = {};
    private DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
    
    /************* Constructor *************/
    
    public ReporteItems(){
        JLabel titulo = new JLabel("Reporte de Items");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        titulo.setBounds(225, 15, 350, 50);
        scrollPane.setBounds(35, 100, 600, 300);
        
        add(titulo);
        add(scrollPane);
    }

    /****************Metodos****************/
    
    public void iniciar(){
        
        dtm.setRowCount(0);
        ArrayList<Item> alfa = (ArrayList<Item>) Principal.getItems().clone();
        ordenarItems(alfa);
        for(int i = 0; i < alfa.size(); i++){
            String txt1 = alfa.get(i).getNombre();
            String txt2 = alfa.get(i).getDescripcion();
            String txt3 = (alfa.get(i).getEstado()) ? "Prestado" : "Disponible";
            String txt4;
            if(alfa.get(i).getEstado()){
                txt4 = alfa.get(i).getPoseedor().getNombre() + " " +
                        alfa.get(i).getPoseedor().getPrimerApellido() + " " +
                        alfa.get(i).getPoseedor().getSegundoApellido();
            } else {
                txt4 = "Nadie";
            }
            
            Object[] newRow={txt1, txt2, txt3, txt4};
            dtm.addRow(newRow);
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
