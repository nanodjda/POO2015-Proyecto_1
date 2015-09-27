/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Personas;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Persona;
import vista.VentanaBase;
import vista.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class AgregarPersona extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre, txtPrimer, txtSegundo, txtCedula, txtTelefono, txtCorreo;
    
    /************* Constructor *************/
    
    public AgregarPersona() {
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        JLabel titulo = new JLabel("Agregar Persona");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        txtNombre = new JTextField(20);
        txtPrimer = new JTextField(20);
        txtSegundo = new JTextField(20);
        txtCedula = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCorreo = new JTextField(20);
        
        JLabel lblNombre = new PLabel("Nombre:");
        JLabel lblPrimer = new PLabel("1er Apellido:");
        JLabel lblSegundo = new PLabel("2do Apellido:");
        JLabel lblCedula = new PLabel("Cédula:");
        JLabel lblTelefono = new PLabel("Telefono:");
        JLabel lblCorreo = new PLabel("Correo:");
        
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(10, 100, 100, 30);
        txtNombre.setBounds(10, 130, 150, 30);
        lblPrimer.setBounds(170, 100, 100, 30);
        txtPrimer.setBounds(170, 130, 150, 30);
        lblSegundo.setBounds(330, 100, 100, 30);
        txtSegundo.setBounds(330, 130, 150, 30);
        lblCedula.setBounds(10, 170, 100, 30);
        txtCedula.setBounds(10, 200, 150, 30);
        lblTelefono.setBounds(170, 170, 100, 30);
        txtTelefono.setBounds(170, 200, 150, 30);
        lblCorreo.setBounds(330, 170, 100, 30);
        txtCorreo.setBounds(330, 200, 220, 30);
        
        
        JButton agregar = new JButton("Agregar");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Persona nueva = new Persona(txtCedula.getText(), 
                            txtNombre.getText(), 
                            txtPrimer.getText(), 
                            txtSegundo.getText()
                    );
                    nueva.setTelefono(txtTelefono.getText());
                    nueva.setCorreo(txtCorreo.getText());
                    Principal.setPersona(nueva);
                    
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "La persona ha sido ingresada");
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminPersonas());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(txtNombre);
        add(lblPrimer);
        add(txtPrimer);
        add(lblSegundo);
        add(txtSegundo);
        add(lblCedula);
        add(txtCedula);
        add(lblTelefono);
        add(txtTelefono);
        add(lblCorreo);
        add(txtCorreo);
        add(agregar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        txtNombre.setText("");
        txtPrimer.setText("");
        txtSegundo.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    public void validar() throws Exception{
        if(txtNombre.getText().isEmpty() ||
                txtCedula.getText().isEmpty()||
                txtPrimer.getText().isEmpty()||
                txtSegundo.getText().isEmpty()
                ){
            throw new Exception("Debes llenar los campos obligatorios.");
        }
    }
}
