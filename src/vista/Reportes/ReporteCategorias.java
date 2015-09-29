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
import modelo.Categoria;
import modelo.Item;
import vista.PLabel;
import vista.VentanaBase;

/**
 * Se encarga de mostrar un panel que contiene un tabla, dependiendo de la categoria
 * seleccionada se llena la tabla con dicha categoria.
 *
 * @author David 28/09/2015
 */
public class ReporteCategorias extends VentanaBase {

    /************** Variables **************/
    private String[] columnNames = {"Item",
                            "Descripcion",
                            "Estado",
                            "Poseedor"};
    private Object[][] data = {};
    private DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
    
    private JComboBox cmbCategorias;

    /************* Constructor *************/
    
    public ReporteCategorias(){
        JLabel titulo = new JLabel("Reporte de Categorías");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JTable table = new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        JLabel categorias = new PLabel("Categoría: ");
        cmbCategorias = new JComboBox();
        cmbCategorias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cmbCategorias.getSelectedIndex() == 0){
                    llenar();
                } else {
                    for(Categoria pCate : Principal.getCategorias()){
                        if(pCate.getNombre().equals(cmbCategorias.getSelectedItem())){
                            llenar(pCate);
                        }
                    }
                }                
            }
        });
        
        titulo.setBounds(225, 15, 350, 50);
        categorias.setBounds(35, 100, 100, 30);
        cmbCategorias.setBounds(140, 100, 150, 30);
        scrollPane.setBounds(35, 150, 565, 300);
        
        add(titulo);
        add(categorias);
        add(cmbCategorias);
        add(scrollPane);
    }

    /****************Metodos****************/
    
    public void iniciar(){
        dtm.setRowCount(0);
        cmbCategorias.removeAllItems();
        
        cmbCategorias.addItem("Sin Categoría");
        for(Categoria c : Principal.getCategorias()){
            cmbCategorias.addItem(c.getNombre());
        }
        
    }
    
    public void llenar(Categoria pCategoría){
        dtm.setRowCount(0);
        ArrayList<Item> alfabetico = (ArrayList<Item>) Principal.getItems().clone();
        ordenarItems(alfabetico);
        for(Item pItem : alfabetico){
            if(pItem.getCategorias().contains(pCategoría)){
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
    
    public void llenar(){
        dtm.setRowCount(0);
        ArrayList<Item> alfabetico = (ArrayList<Item>) Principal.getItems().clone();
        ordenarItems(alfabetico);
        for(Item pItem : alfabetico){
            if(pItem.getCategorias().isEmpty()){
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
