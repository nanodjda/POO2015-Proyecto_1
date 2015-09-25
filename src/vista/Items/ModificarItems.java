/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista.Items;

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
import modelo.Categoria;
import modelo.Item;
import modelo.Tipo;
import vista.VentanaEmergente;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class ModificarItems extends VentanaEmergente{

    /************** Variables **************/
    private JTextField txtNombre, txtCodigo;
    private JTextArea txtDescr;
    private JComboBox cmbTipo;
    private JScrollPane scrCate;
    private JList cmbCate;
    private JButton aceptar;
    
    /************* Constructor *************/
    public ModificarItems(JFrame frame, String title, int ancho, int alto, Item pItem){
        super(frame, title, ancho, alto);
        JLabel titulo = new JLabel("Editar Item");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Nombre:");
        JLabel lblCodigo = new PLabel("Código:");
        JLabel lblDescri = new PLabel("Descripción:");
        JLabel lblTipo = new PLabel("Tipo:");
        JLabel lblCate = new PLabel("Categorías:");
        JLabel lblCate2 = new PLabel("Seleccione las categorías");
        JLabel lblCate3 = new PLabel("(Con Ctrl puede seleccionar mas de una)");
        
        txtNombre = new JTextField(pItem.getNombre(), 20);
        txtCodigo = new JTextField(pItem.getCodigo(), 20);
        txtDescr = new JTextArea(pItem.getDescripcion());
        JScrollPane scrDescr = new JScrollPane(txtDescr);
        cmbTipo = new JComboBox();
        
        for(Tipo pTipo : Principal.getTipos()) {
            cmbTipo.addItem(pTipo.getNombre());
        }
        
        cmbTipo.setSelectedItem(pItem.getTipo().getNombre());
        DefaultListModel model = new DefaultListModel();
        for(Categoria str : Principal.getCategorias()) {
            model.addElement(str.getNombre());
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
        lblCate2.setBounds(110, 400, 400, 30);
        lblCate3.setBounds(110, 430, 400, 30);
        
        aceptar = new JButton("Aceptar");
        aceptar.setBounds(540, 450, 100, 30);
        
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validar();
                    pItem.setNombre(txtNombre.getText());
                    pItem.setCodigo(txtCodigo.getText());
                    pItem.setTipo(Principal.getTipos().get(cmbTipo.getSelectedIndex()));
                    pItem.setDescripcion(txtDescr.getText());
                    List<Integer> selectedValuesList = cmbCate.getSelectedValuesList();
                    pItem.getCategorias().clear();
                    for(Integer i : cmbCate.getSelectedIndices()){
                        pItem.agregarCategoria(Principal.getCategorias().get(i));
                    }
                    JOptionPane.showMessageDialog(getRootPane(), "El item ha sido actualizado");
                    dispose();
                } catch (Exception c) {                    
                    JOptionPane.showMessageDialog(getRootPane(),c.getMessage(),
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
