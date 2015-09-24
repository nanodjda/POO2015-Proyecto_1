/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
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
import javax.swing.JTextField;
import modelo.Item;
import vista.VentanaBase;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class ModificarCategoria extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre;
    private JComboBox cmbCate;
    private JScrollPane scrCate;
    
    /************* Constructor *************/
    public ModificarCategoria(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Modificar Categoría");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Categorías:");
        JLabel lblnewNombre = new PLabel("Nuevo nombre:");
        JLabel lblDescr = new PLabel("Seleccione la categoría a modificar");
        
        txtNombre = new JTextField(20);
        cmbCate = new JComboBox(Principal.getCategorias().toArray());
        scrCate = new JScrollPane();
        scrCate.setViewportView(cmbCate);
        
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    int act = cmbCate.getSelectedIndex();
                    Principal.getCategorias().set(act, txtNombre.getText());
                    for(Item item: Principal.getItems()){
                        for(int i = 0; i < item.getCategorias().size(); i++){
                            if(item.getCategorias().get(i).equals(cmbCate.getSelectedItem())){
                                item.getCategorias().set(i, txtNombre.getText());
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "La categoría fue actualizada correctamente");
                    miCoordinador.getMiModificarCategoria().limpiar();
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiModificarCategoria());
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
        lblnewNombre.setBounds(38, 210, 200, 30);
        txtNombre.setBounds(38, 250, 120, 30);
        modificar.setBounds(168, 250, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(lblDescr);
        add(scrCate);
        add(lblnewNombre);
        add(txtNombre);
        add(modificar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        txtNombre.setText("");
        cmbCate.removeAllItems();
        for(String str : Principal.getCategorias()) {
            cmbCate.addItem(str);
        }
    }
    
    public void validar() throws Exception{        
        if(txtNombre.getText().equals("")){
            throw new Exception("Debes llenar el campo con el nuevo valor.");
        }
        
        for(String str : Principal.getCategorias()){
            if(txtNombre.getText().equals(str)){
                throw new Exception("Ya existe esta categoría.");
            }
        }
    }
}
