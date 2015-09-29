/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;
import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author David 22/09/2015
 */
public class VentanaEmergente extends JDialog{

    /************** Variables **************/
    protected Coordinador miCoordinador;
    private JPanel panel;

    /************* Constructor *************/
    public VentanaEmergente(JFrame frame, String title, int ancho, int alto) {
		super(frame, title, true);
		setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocation(50, 50);
                setResizable(false);
		setSize(ancho, alto);

		panel = new PanelConFondo("darkblue.png");
		setContentPane(panel);
	}
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public void setCoordinador(Coordinador coordinador) {
        this.miCoordinador = coordinador;
    }
    
    public JPanel getPanel(){
        return panel;
    }

}
