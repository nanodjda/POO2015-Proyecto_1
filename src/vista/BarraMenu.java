/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author David 17/09/2015
 */
public class BarraMenu extends JMenuBar{

    /************** Variables **************/
    
    private Coordinador miCoordinador;
    
    private JMenu archivo = new JMenu("Archivo");
    private JMenuItem alertas = new JMenuItem("Alertas");
    private JMenuItem mSalir = new JMenuItem("Salir");
    
    /************* Constructor *************/
    public BarraMenu(){
        this.add(archivo);
        mSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        
        alertas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                miCoordinador.getMiLogica().revisarAlertas();
            }
        });
        
        archivo.add(alertas);
        archivo.add(mSalir);
        
        
    }
    
    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    
    public void setCoordinador(Coordinador pCoordinador){
        this.miCoordinador = pCoordinador;
    }

}
