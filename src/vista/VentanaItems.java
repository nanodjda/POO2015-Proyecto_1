/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

/**
 *
 * @author David 17/09/2015
 */
public class VentanaItems extends VentanaBase{

    /************** Variables **************/
    private int ancho = 600;
    private int alto = 600;

    /************* Constructor *************/
    public VentanaItems(){
        iniciar();
    }
    
    /****************Metodos****************/
    public void iniciar(){
        
        // Crea el layout del panel
        GridBagLayout gbl_principal = new GridBagLayout();
        float anch = ancho / 5;
        float alt = alto / 5;
        gbl_principal.columnWidths = new int[] { (int) anch, (int) anch,
                        (int) anch, (int) anch, (int) anch};
        gbl_principal.rowHeights = new int[] { (int) alt, (int) alt, (int) alt,
                        (int) alt, (int) alt};
        gbl_principal.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0};
        gbl_principal.rowWeights = new double[]    { 1.0, 1.0, 1.0, 1.0, 1.0};
        setLayout(gbl_principal);
        for(int x = 0; x < 5; x++ ){
            for(int y = 0; y < 5; y++){
                PanelConFondo nuevo = new PanelConFondo("item.jpg");
                GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		add(nuevo, gbc);
            }
        }
    }
    
    /*********** Getters/Setters ***********/
}
