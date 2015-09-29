/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001360
*/

package vista;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 * Crea la instancia de un PanelLateral con un fondo, y un Layout para acomodar
 * los botones que se le agreguen.
 *
 * @author David 17/09/2015
 */
public class PanelLateral extends PanelConFondo{

    /************** Variables **************/
    private int ancho, alto;
    private int cant_botones = 0;
    private ArrayList<JButton> botonesPosicion = new ArrayList<JButton>();
    
    /************* Constructor *************/
    public PanelLateral(int ancho, int alto) {
        super("lightblue.png");
        //Define el layout del panel
        GridBagLayout gbl_lateral = new GridBagLayout();
        float alt = alto/10;
        gbl_lateral.columnWidths = new int[]{15, ancho-80, 15};
        gbl_lateral.rowHeights = new int[]{(int)alt, (int)alt, (int)alt, (int)alt, (int)alt, (int)alt};
        gbl_lateral.columnWeights = new double[]{0.0, 1.0, 0.0};
        gbl_lateral.rowWeights = new double[]{0.75, 0.75, 0.75, 0.75, 0.75, 0.75};
        setLayout(gbl_lateral);
}
    
    /****************Metodos****************/
    
    /**
     * Recibe como parametro un boton que será agregado al PanelLateral.
     * @param boton - Boton a agregar.
     */
    public void agregarBoton(JButton boton){
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.anchor = GridBagConstraints.WEST;;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.gridy = cant_botones;
        gbc.insets = new Insets(15, 15, 15, 15);
        add(boton, gbc);

        cant_botones++;
    }

}
