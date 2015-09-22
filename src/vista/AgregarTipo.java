/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class AgregarTipo extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre;
    
    /************* Constructor *************/
    
    public AgregarTipo() {
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        JLabel titulo = new JLabel("Agregar Tipo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Nombre:");
        txtNombre = new JTextField(20);
        
        lblNombre.setBounds(38, 100, 80, 30);
        txtNombre.setBounds(110, 100, 150, 30);
        
        add(lblNombre);
        add(txtNombre);
        
    }
    /*********** Getters/Setters ***********/

}
