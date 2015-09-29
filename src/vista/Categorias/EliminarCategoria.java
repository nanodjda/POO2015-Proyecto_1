/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Categorias;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import modelo.Categoria;
import modelo.Item;
import vista.VentanaBase;
import vista.PLabel;

/**
 * Crea la instancia de la ventana de EliminarCategoria
 *
 * @author David 22/09/2015
 */
public class EliminarCategoria extends VentanaBase {

    /************** Variables **************/
    private JComboBox cmbCate;
    private JScrollPane scrCate;
    
    /************* Constructor *************/
    public EliminarCategoria(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Eliminar Categoría");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Categorías:");
        JLabel lblDescr = new PLabel("Seleccione la categoría a eliminar");
        
        cmbCate = new JComboBox(Principal.getCategorias().toArray());
        scrCate = new JScrollPane();
        scrCate.setViewportView(cmbCate);
        
        JButton eliminar = new JButton("Eliminar");
        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    int act = cmbCate.getSelectedIndex();
                    Principal.getCategorias().remove(act);
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "La categoría fue eliminada correctamente");
                    if(Principal.getCategorias().isEmpty()){
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminCate());
                    } else {
                        miCoordinador.getMiEliminarCategoria().limpiar();
                        miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiEliminarCategoria());
                    }
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        lblDescr.setBounds(290, 100, 300, 30);
        scrCate.setBounds(130, 100, 150, 30);
        eliminar.setBounds(168, 250, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(lblDescr);
        add(scrCate);
        add(eliminar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        cmbCate.removeAllItems();
        for(Categoria cate : Principal.getCategorias()) {
            cmbCate.addItem(cate.getNombre());
        }
    }
    
    public void validar() throws Exception{
        for(Item item: Principal.getItems()){
            for(Categoria str : item.getCategorias()){
                if(str.getNombre().equals(cmbCate.getSelectedItem())){
                    throw new Exception("No se puede eliminar esta categoría \n"
                            + "ya que es usada por el item('"+ item.getNombre() +"').");
                }
            }
        }
        if(Principal.getCategorias().isEmpty()){
            throw new Exception("No hay mas categorias para borrar.");
        }
    }
}
