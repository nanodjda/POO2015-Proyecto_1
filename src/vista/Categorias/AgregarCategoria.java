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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Categoria;
import vista.VentanaBase;
import vista.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class AgregarCategoria extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre;
    
    /************* Constructor *************/
    
    public AgregarCategoria() {
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        JLabel titulo = new JLabel("Agregar Categoría");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Nombre:");
        txtNombre = new JTextField(20);
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        txtNombre.setBounds(110, 100, 150, 30);
        
        JButton agregar = new JButton("Agregar");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Principal.setCategoria(new Categoria(txtNombre.getText()));
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "La categoría fue agregada correctamente");
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminCate());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(txtNombre);
        add(agregar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        txtNombre.setText("");
    }
    
    public void validar() throws Exception{
        if(txtNombre.getText().isEmpty()){
            throw new Exception("Debes llenar el campo para agregar.");
        }
        for(Categoria cate : Principal.getCategorias()){
            if(txtNombre.getText().equals(cate.getNombre())){
                throw new Exception("Ya existe esta categoría.");
            }
        }
    }
}
