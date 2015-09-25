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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import modelo.Categoria;
import vista.VentanaBase;
import vista.controles.PLabel;

/**
 *
 * @author David 22/09/2015
 */
public class MostrarCategoria extends VentanaBase{

    /************** Variables **************/
    private JList cmbCate;
    private JScrollPane scrCate;
    
    /************* Constructor *************/
    public MostrarCategoria(){
        iniciar();
    }
    /****************Metodos****************/
    
    public void iniciar(){
        JLabel titulo = new JLabel("Mostrar Categorías");
        titulo.setForeground(new Color(159, 227, 255));
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        
        JLabel lblNombre = new PLabel("Categorías:");
        
        
        DefaultListModel model = new DefaultListModel();
        for(Categoria str : Principal.getCategorias()) {
            model.addElement(str.getNombre());
        }
        cmbCate = new JList(model);
        scrCate = new JScrollPane();
        scrCate.setViewportView(cmbCate);
        
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miCoordinador.getMiVentanaPrincipal().setPrincipal(miCoordinador.getMiVentanaAdminCate());
            }
        });
        
        titulo.setBounds(250, 15, 350, 50);
        lblNombre.setBounds(38, 100, 80, 30);
        scrCate.setBounds(130, 100, 150, 200);
        aceptar.setBounds(180, 350, 100, 30);
        
        add(titulo);
        add(lblNombre);
        add(scrCate);
        add(aceptar);
        
    }
    
    /*********** Getters/Setters ***********/
    public void limpiar(){
        DefaultListModel model = new DefaultListModel();
        for(Categoria str : Principal.getCategorias()) {
            model.addElement(str.getNombre());
        }
        cmbCate = new JList(model);
        scrCate.setViewportView(cmbCate);
    }
}