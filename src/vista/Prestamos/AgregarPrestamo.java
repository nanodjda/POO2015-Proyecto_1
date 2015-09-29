/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista.Prestamos;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import modelo.Item;
import modelo.Persona;
import modelo.Prestamo;
import vista.VentanaBase;
import vista.PLabel;
import vista.PRadioButton;

/**
 * Crea la ventana para agregar prestamos.
 *
 * @author David 22/09/2015
 */
public class AgregarPrestamo extends VentanaBase {

    /************** Variables **************/
    private JList cmbItems;
    private JScrollPane scrItems;
    private JComboBox cmbPersonas;
    private JFormattedTextField fecha_final;
    private JTextField cant_dias;
    private JLabel lblAlertaFech;
    private JRadioButton opc1, opc2;
    private Dictionary items = new Hashtable();
    int pos = 0;
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    
    /************* Constructor *************/
    /**
     * LLama a la funcion iniciar que se encarga de crear los componentes de la ventana
     */
    public AgregarPrestamo(){
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        JLabel titulo = new JLabel("Crear Prestamo");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        DefaultListModel model = new DefaultListModel();
        cmbItems = new JList(model);
        scrItems = new JScrollPane();
        scrItems.setViewportView(cmbItems);
        
        cmbPersonas = new JComboBox();
        
        JLabel lblNombre = new PLabel("Persona:");
        JLabel lblItems = new PLabel("Items:");
        JLabel lblAlerta = new PLabel("Alerta:");
        lblAlertaFech = new PLabel("");
        
        ButtonGroup rb = new ButtonGroup();
        opc1 = new PRadioButton("Única");
        opc2 = new PRadioButton("Recurrente");
        
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##/##/####");
            formatter.setPlaceholderCharacter('_');
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        
        fecha_final = new JFormattedTextField(formatter);
        cant_dias = new JTextField();
        fecha_final.setVisible(false);
        cant_dias.setVisible(false);
        
        rb.add(opc1);
        opc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecha_final.setVisible(true);
                fecha_final.setText("");
                cant_dias.setVisible(false);
                lblAlertaFech.setText("Ejemplo: 01/01/2015");
                repaint();
                revalidate();
            }
        });
        
        rb.add(opc2);
        opc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecha_final.setVisible(false);
                cant_dias.setVisible(true);
                cant_dias.setText("");
                lblAlertaFech.setText("(Cantidad de días)");
                repaint();
                revalidate();
            }
        });
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(10, 100, 100, 30);
        cmbPersonas.setBounds(10, 140, 300, 30);
        lblItems.setBounds(320, 100, 100, 30);
        scrItems.setBounds(320, 140, 100, 100);
        lblAlerta.setBounds(10, 180, 100, 30);
        opc1.setBounds(10, 220, 100, 30);
        opc2.setBounds(120, 220, 150, 30);
        fecha_final.setBounds(10, 260, 100, 30);
        lblAlertaFech.setBounds(120, 260, 150, 30);
        cant_dias.setBounds(10, 260, 100, 30);
        
        JButton agregar = new JButton("Crear");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Prestamo nuevo;
                    if(opc1.isSelected()){
                        Date fec = formatoFecha.parse(fecha_final.getText());
                        nuevo = new Prestamo(Principal.getPersonas().get(cmbPersonas.getSelectedIndex()), fec);
                    } else {
                        int can = Integer.parseInt(cant_dias.getText());
                        nuevo = new Prestamo(Principal.getPersonas().get(cmbPersonas.getSelectedIndex()), can);
                    }
                    
                    for(Integer x : cmbItems.getSelectedIndices()){
                        nuevo.agregarItem((Item) items.get(x));
                    }
                    Principal.setPrestamo(nuevo);
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El préstamo ha sido creado.");
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminPrestamos());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        add(titulo);
        add(lblNombre);
        add(cmbPersonas);
        add(scrItems);
        add(lblItems);
        add(lblAlerta);
        add(opc1);
        add(opc2);
        add(fecha_final);
        add(lblAlertaFech);
        add(cant_dias);
        add(agregar);
        
    }
    /*********** Getters/Setters ***********/
    public void limpiar(){
        cmbPersonas.removeAllItems();
        for(Persona per : Principal.getPersonas()) {
            cmbPersonas.addItem(per.getNombre() + " " + per.getPrimerApellido() + " " + per.getSegundoApellido());
        }
        
        DefaultListModel model = new DefaultListModel();
        pos = 0;
        for(Item ite : Principal.getItems()) {
            if(ite.getEstado()==false){
                model.addElement(ite.getNombre());
                items.put(pos, ite);
                pos += 1;
            }
        }
        cmbItems = new JList(model);
        scrItems.setViewportView(cmbItems);
        
        fecha_final.setText("");
        cant_dias.setText("");
        
    }
    
    public void validar() throws Exception{
        if(cmbItems.getSelectedValuesList().isEmpty()){
            throw new Exception("Debe seleccionar minimo un item\n"
                    + "para crear el préstamo.");
        }
        
        if(opc1.isSelected() == false && opc2.isSelected() == false){
            throw new Exception("Debe seleccionar un tipo de alerta.");
        }
        
        if(opc1.isSelected()){
            if(fecha_final.getText().equals("__/__/____")){
                throw new Exception("Debe llenar el campo vacío.");
            }
            validarFecha(fecha_final.getText());
            
            Date fec = formatoFecha.parse(fecha_final.getText());
            if(new Date().compareTo(fec) > 0){
                throw new Exception("Debe ingresar una fecha mayor al dia actual.");
            }
        }
        
        if(opc2.isSelected()){
            if(cant_dias.getText().equals("")){
                throw new Exception("Debe llenar el campo vacío.");
            }
            if(Integer.parseInt(cant_dias.getText()) < 1){
                throw new Exception("La cantidad de días debe ser mayor a 0");
            }
        }
    }
    
    public boolean validarFecha(String fecha) throws Exception {
        try {
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            throw new Exception("La fecha ingresada no es válida");
        }
        return true;
    }
}
