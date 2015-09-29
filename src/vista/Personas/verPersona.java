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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaEmergente;
import vista.PLabel;
import static vista.Reportes.ReporteItems.ordenarItems;

/**
 *
 * @author David 22/09/2015
 */
public class verPersona extends VentanaEmergente{

    /************** Variables **************/
    private JTextField txtNombre, txtPrimer, txtSegundo, txtCedula, txtTelefono, txtCorreo;
    private JComboBox cmbItems;
    private JScrollPane scrPrestamos;
    private JTable table;
    String[] columnNames = {"Item",
                        "Descripcion",
                        "ID Prestamo",
                        "Fecha Final"};
    Object[][] data = {};
    private DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    /************* Constructor *************/

    public verPersona(JFrame frame, String title, int ancho, int alto, Persona pPersona) {
        super(frame, title, ancho, alto);
        JLabel titulo = new JLabel("Ver Persona");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        txtNombre = new JTextField(pPersona.getNombre(), 20);
        txtPrimer = new JTextField(pPersona.getPrimerApellido(), 20);
        txtSegundo = new JTextField(pPersona.getSegundoApellido(), 20);
        txtCedula = new JTextField(pPersona.getCedula(), 20);
        txtTelefono = new JTextField(pPersona.getTelefono(), 20);
        txtCorreo = new JTextField(pPersona.getCorreo(), 20);
        cmbItems = new JComboBox();
        
        txtNombre.enable(false);
        txtNombre.setDisabledTextColor(Color.black);
        txtPrimer.enable(false);
        txtPrimer.setDisabledTextColor(Color.black);
        txtSegundo.enable(false);
        txtSegundo.setDisabledTextColor(Color.black);
        txtCedula.enable(false);
        txtCedula.setDisabledTextColor(Color.black);
        txtTelefono.enable(false);
        txtTelefono.setDisabledTextColor(Color.black);
        txtCorreo.enable(false);
        txtCorreo.setDisabledTextColor(Color.black);
        
        JLabel lblNombre = new PLabel("Nombre:");
        JLabel lblPrimer = new PLabel("1er Apellido:");
        JLabel lblSegundo = new PLabel("2do Apellido:");
        JLabel lblCedula = new PLabel("Cédula:");
        JLabel lblTelefono = new PLabel("Telefono:");
        JLabel lblCorreo = new PLabel("Correo:");
        JLabel lblPrestamo = new PLabel("Préstamos:");
        
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
        lblPrestamo.setBounds(10, 240, 100, 30);
        
        cargarDatos(pPersona);
        
        table = new JTable(dtm);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 280, 600, 100);
        
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
        add(lblPrestamo);
        add(scrollPane);
        add(aceptar);
    }
    
    /****************Metodos****************/

    public void limpiar(){
        txtNombre.setText("");
        txtPrimer.setText("");
        txtSegundo.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    public void cargarDatos(Persona pPersona){
        dtm.setRowCount(0);
        for(Item pItem : Principal.getItems()){
            if(pItem.getPoseedor().equals(pPersona) && pItem.getEstado() == true){
                String txt1 = pItem.getNombre();
                String txt2 = pItem.getDescripcion();
                String txt3 = "";
                String txt4 = "";
                for(Prestamo p : Principal.getPrestamos()){
                    if(p.getItems().contains(pItem)){
                        txt3 = String.valueOf(p.getIdPrestamo());
                        txt4 = formatoFecha.format(p.getAlerta().getFec_fin());
                    }
                }
                Object[] newRow={txt1, txt2, txt3, txt4};
                dtm.addRow(newRow);
            }
        }
    }    
    
    /*********** Getters/Setters ***********/

}
