/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package vista;

import controlador.Coordinador;
import controlador.Principal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Esta clase se encarga de crear el JFrame principal del sistema.
 *
 * @author David 17/09/2015
 */
public class VentanaPrincipal extends JFrame{

    /************** Variables **************/
    private Coordinador miCoordinador;
    private PanelLateral lateral;
    private JScrollPane principal;
    private int ancho_lateral, ancho_principal, alto;
    
    /************* Constructor *************/
    /**
     * Crea la ventana con los datos dados, tambien define el ancho de la barra
     * lateral y el ancho del espacio principal.
     * 
     * @param pAncho - Ancho de la ventana
     * @param pAlto - Alto de la ventana
     */
    public VentanaPrincipal(int pAncho, int pAlto){
        this.ancho_lateral = pAncho / 4;
        this.ancho_principal = pAncho - this.ancho_lateral;
        this.alto = pAlto;
        iniciar();
    }
    
    /****************Metodos****************/
    private void iniciar(){
        setLayout(null);
        setSize(ancho_lateral + ancho_principal + 15, alto + 60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("La Cueva 2.0");
        setLocationRelativeTo(null);
        setResizable(false);
        
        lateral = new PanelLateral(ancho_lateral, alto);
        lateral.setBounds(0, 0, ancho_lateral, alto);
        add(lateral);
        
        JPanel base = new VentanaBase();
        principal = new JScrollPane(base);
        principal.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
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
                setPrincipal(miCoordinador.getMiVentanaAdminTipos());
            }
        });
        lateral.agregarBoton(btnTipo);
        
        JButton btnCategoria = new JButton("Categoría");
	btnCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaAdminCate());
            }
        });
        lateral.agregarBoton(btnCategoria);
        
        JButton btnPersona = new JButton("Persona");
	btnPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaAdminPersonas());
            }
        });
        lateral.agregarBoton(btnPersona);
        
        JButton btnPrestamo = new JButton("Préstamo");
	btnPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaAdminPrestamos());
            }
        });
        lateral.agregarBoton(btnPrestamo);
        
        JButton btnReporte = new JButton("Reportes");
	btnReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPrincipal(miCoordinador.getMiVentanaAdminReportes());
            }
        });
        lateral.agregarBoton(btnReporte);
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                miCoordinador.getMiLogica().guardarDatos(Principal.getItems(), 
                        Principal.getTipos(), 
                        Principal.getCategorias(), 
                        Principal.getPersonas(), 
                        Principal.getPrestamos(), 
                        Principal.idGlobalPrestamo,
                        Principal.idGlobalItem);
                }
            }
        );
        
    }
    
    /*********** Getters/Setters ***********/
    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador=miCoordinador;
    }

    public JScrollPane getPrincipal() {
        return principal;
    }

    public void setPrincipal(JPanel pPrincipal) {
        this.remove(principal);
        JScrollPane scrollPane = new JScrollPane(pPrincipal, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.principal = scrollPane;
        this.principal.setBounds(ancho_lateral, 0, ancho_principal, alto);
        principal.setBorder(BorderFactory.createLineBorder(Color.yellow, 0));
        this.add(this.principal);
        this.revalidate();
        this.repaint();
    }
    
    public void setLateral(PanelLateral pPanelNuevo){
        this.remove(lateral);
        this.lateral = pPanelNuevo;
        lateral.setBounds(0, 0, ancho_lateral, alto);
        this.add(this.lateral);
        this.revalidate();
        this.repaint();
    }
    
    public void setBarraMenu(BarraMenu pBarraMenu){
        this.setJMenuBar(pBarraMenu);
    }
}
