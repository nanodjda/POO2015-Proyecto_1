/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David 17/09/2015
 */
public class VentanaPrincipal extends JFrame{

    /************** Variables **************/
    private Coordinador miCoordinador;
    private PanelLateral lateral;
    private JPanel principal;
    private int ancho_lateral, ancho_principal, alto;
    
    /************* Constructor *************/
    public VentanaPrincipal(int pAncho, int pAlto){
        this.ancho_lateral = pAncho / 4;
        this.ancho_principal = pAncho - this.ancho_lateral;
        this.alto = pAlto;
        iniciar();
    }
    
    /****************Metodos****************/
    private void iniciar(){
        // Declaracion básica de la venta
        setLayout(null);
        setSize(ancho_lateral + ancho_principal + 15, alto + 60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("La Cueva 2.0");
        
        this.setJMenuBar(new BarraMenu());
        
        lateral = new PanelLateral(ancho_lateral, alto);
        lateral.setBounds(0, 0, ancho_lateral, alto);
        add(lateral);
        
        principal = new VentanaBase();
        principal.setBounds(ancho_lateral, 0, ancho_principal, alto);
        add(principal);
                
        JButton btnItems = new JButton("Items");
	btnItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaAdminItems());
            }
            
        });
        lateral.agregarBoton(btnItems);
        
        JButton btnTipo = new JButton("Tipo");
	btnTipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaTipo());
            }
        });
        lateral.agregarBoton(btnTipo);
        
        JButton btnCategoria = new JButton("Tipo");
	btnCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaTipo());
            }
        });
        lateral.agregarBoton(btnCategoria);
        
    }
    
    /*********** Getters/Setters ***********/
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public JPanel getPrincipal() {
        return principal;
    }

    public void setPrincipal(JPanel pPrincipal) {
        this.remove(principal);
        this.principal = pPrincipal;
        this.principal.setBounds(ancho_lateral, 0, ancho_principal, alto);
        this.add(this.principal);
        this.revalidate();
        this.repaint();
    }
}
