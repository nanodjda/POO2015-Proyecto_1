/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Prestamos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaEmergente;
import vista.PLabel;

/**
 * Se encarga de desplegar la informacion de un prestamo que es pasado como 
 * parametro.
 *
 * @author David 24/09/2015
 */
public class verPrestamo extends VentanaEmergente {

    /************** Variables **************/
    private JList cmbItems;
    private JTextField txtPersona;
    private JScrollPane scrItems;
    private Persona seleccionado;

    /************* Constructor *************/
    
    public verPrestamo(JFrame frame, String title, int ancho, int alto, Prestamo pPrestamo) {
        super(frame, title, ancho, alto);
        
        JLabel titulo = new JLabel("Ver Prestamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        DefaultListModel model = new DefaultListModel();
        for(Item ite : pPrestamo.getItems()) {
            model.addElement(ite.getNombre());
        }
        
        cmbItems = new JList(model);
        scrItems = new JScrollPane();
        scrItems.setViewportView(cmbItems);
        
        txtPersona = new JTextField(pPrestamo.getPersona().getNombre() + " " +
                pPrestamo.getPersona().getPrimerApellido() + " " + 
                pPrestamo.getPersona().getSegundoApellido(), 20);
        txtPersona.enable(false);
        txtPersona.setDisabledTextColor(Color.black);
        
        JLabel lblNombre = new PLabel("Persona:");
        JLabel lblItems = new PLabel("Items:");
        JLabel lblAlerta = new PLabel("Alerta:");
        JLabel lblAlertaTipo = new PLabel(pPrestamo.getAlerta().getTipo());
        JLabel lblAlertaCara;
        if(pPrestamo.getAlerta().getTipo().equals("Recurrente")){
            lblAlertaCara = new PLabel("Próx: " + pPrestamo.getAlerta().diafinal());
        } else {
            lblAlertaCara = new PLabel("Vence: " + pPrestamo.getAlerta().diafinal());
        }
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(10, 100, 100, 30);
        txtPersona.setBounds(10, 140, 300, 30);
        lblItems.setBounds(320, 100, 100, 30);
        scrItems.setBounds(320, 140, 100, 100);
        lblAlerta.setBounds(10, 180, 100, 30);
        lblAlertaTipo.setBounds(70, 180, 150, 30);
        lblAlertaCara.setBounds(70, 210, 150, 30);
        
        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(540, 450, 100, 30);
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(txtPersona);
        add(scrItems);
        add(lblItems);
        add(lblAlerta);
        add(lblAlertaTipo);
        add(lblAlertaCara);
        add(aceptar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        
    }
    
    public void validar() throws Exception{
        if(cmbItems.getSelectedValuesList().isEmpty()){
            throw new Exception("Debe seleccionar minimo un item\n"
                    + "para crear el préstamo.");
        }
    }
}