/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.Item;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class VerItem extends VentanaEmergente{

    /************** Variables **************/
    private JTextField txtNombre, txtCodigo;
    private JTextArea txtDescr;
    private JComboBox cmbTipo;
    private JScrollPane scrCate;
    private JList cmbCate;
    private JButton aceptar;
    
    /************* Constructor *************/
    public VerItem(JFrame frame, String title, int ancho, int alto, Item pItem){
        super(frame, title, ancho, alto);
        JLabel titulo = new JLabel("Ver Item");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Nombre:");
        JLabel lblCodigo = new PLabel("Código:");
        JLabel lblDescri = new PLabel("Descripción:");
        JLabel lblTipo = new PLabel("Tipo:");
        JLabel lblCate = new PLabel("Categorías:");
        
        txtNombre = new JTextField(pItem.getNombre(), 20);
        txtCodigo = new JTextField(pItem.getCodigo(), 20);
        txtDescr = new JTextArea(pItem.getDescripcion());
        JScrollPane scrDescr = new JScrollPane(txtDescr);
        cmbTipo = new JComboBox(Principal.getTipos().toArray());
        cmbTipo.setSelectedItem(pItem.getTipo());
        DefaultListModel model = new DefaultListModel();
        for(String str : pItem.getCategorias()) {
            model.addElement(str);
        }
        cmbCate = new JList(model);
        scrCate = new JScrollPane();
        scrCate.setViewportView(cmbCate);
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        txtNombre.setBounds(110, 100, 150, 30);
        lblCodigo.setBounds(280, 100, 80, 30);
        txtCodigo.setBounds(345, 100, 150, 30);
        lblDescri.setBounds(10, 150, 100, 30);
        scrDescr.setBounds(110, 150, 385, 90);
        lblTipo.setBounds(65, 250, 80, 30);
        cmbTipo.setBounds(110, 250, 150, 30);
        lblCate.setBounds(10, 290, 80, 30);
        scrCate.setBounds(110, 290, 150, 100);
        
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(540, 450, 100, 30);
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        txtNombre.enable(false);
        txtCodigo.enable(false);
        txtDescr.enable(false);
        cmbTipo.enable(false);
        cmbCate.enable(false);
        add(titulo);
        add(lblNombre);
        add(txtNombre);
        add(lblCodigo);
        add(txtCodigo);
        add(lblDescri);
        add(scrDescr);
        add(lblTipo);
        add(cmbTipo);
        add(lblCate);
        add(scrCate);
        add(aceptar);
        
        
    }
    /****************Metodos****************/
        
    public void validar() throws Exception{
        if(txtNombre.getText().equals("")
                || txtCodigo.getText().equals("")
                || cmbTipo.getSelectedObjects().length == 0){
            throw new Exception("Debe llenar los campos obligatorios");
        }
    }
    /*********** Getters/Setters ***********/

}
