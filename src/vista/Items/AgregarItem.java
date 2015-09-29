/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Items;

import vista.PLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controlador.Principal;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import modelo.Categoria;
import modelo.Item;
import modelo.Tipo;
import vista.VentanaBase;

/**
 *
 * @author David 19/09/2015
 */
public class AgregarItem extends VentanaBase{

    /************** Variables **************/
    private JTextField txtNombre, txtCodigo;
    private JTextArea txtDescr;
    private JComboBox cmbTipo;
    private JScrollPane scrCate;
    private JList cmbCate;
    private JButton agregar;
    
    /************* Constructor *************/
    public AgregarItem(){
        JLabel titulo = new JLabel("Agregar Item");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Nombre:");
        JLabel lblCodigo = new PLabel("Código:");
        JLabel lblDescri = new PLabel("Descripción:");
        JLabel lblTipo = new PLabel("Tipo:");
        JLabel lblCate = new PLabel("Categorías:");
        JLabel lblCate2 = new PLabel("Seleccione las categorías");
        JLabel lblCate3 = new PLabel("(Con Ctrl puede seleccionar mas de una)");
        txtNombre = new JTextField(20);
        txtCodigo = new JTextField(20);
        txtDescr = new JTextArea();
        JScrollPane scrDescr = new JScrollPane(txtDescr);
        cmbTipo = new JComboBox();
        cmbCate = new JList();
        cmbCate.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        scrCate = new JScrollPane();
        
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
        lblCate2.setBounds(110, 400, 400, 30);
        lblCate3.setBounds(110, 430, 400, 30);
        
        agregar = new JButton("Agregar");
        agregar.setBounds(540, 450, 100, 30);
        
        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    Item nuevo = new Item(txtNombre.getText(), txtCodigo.getText(), Principal.getTipos().get(cmbTipo.getSelectedIndex()));
                    if(!txtDescr.getText().equals("")){
                        nuevo.setDescripcion(txtDescr.getText());
                    }
                    for(Integer i : cmbCate.getSelectedIndices()){
                        nuevo.agregarCategoria(Principal.getCategorias().get(i));
                    }
                    Principal.setItem(nuevo);
                    JOptionPane.showMessageDialog(miCoordinador.getMiVentanaPrincipal(), "El item fue agregado correctamente");
                    miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminItems());
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(null,c.getMessage(),
                    "Advertencia",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
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
        add(lblCate2);
        add(lblCate3);
        add(scrCate);
        add(agregar);
        
    }
    /****************Metodos****************/
    public void limpiarComponentes(){
        txtNombre.setText("");
        txtCodigo.setText(String.valueOf(Principal.idGlobalItem + 1));
        txtCodigo.enable(false);
        txtCodigo.setDisabledTextColor(Color.black);
        txtDescr.setText("");
        cmbTipo.removeAllItems();
        for(Tipo pTipo : Principal.getTipos()) {
            cmbTipo.addItem(pTipo.getNombre());
        }
        
        DefaultListModel model = new DefaultListModel();
        for(Categoria str : Principal.getCategorias()) {
            model.addElement(str.getNombre());
        }
        cmbCate = new JList(model);
        scrCate.setViewportView(cmbCate);
    }

    public void validar() throws Exception{
        if(txtNombre.getText().equals("")
                || cmbTipo.getSelectedObjects().length == 0){
            throw new Exception("Debe llenar los campos obligatorios");
        }
        
        if(cmbTipo.getSelectedItem().equals("Default")){
            throw new Exception("Debe seleccionar un tipo.");
        }
    }
    /*********** Getters/Setters ***********/
}
