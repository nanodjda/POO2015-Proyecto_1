/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import controlador.Coordinador;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author David 19/09/2015
 */
public class PanelConFondo extends JPanel{

    /************** Variables **************/
    
    /************* Constructor *************/
    public PanelConFondo(String pURLImagen){
        setForeground(SystemColor.controlHighlight);
		try {
			URL imagen = PanelConFondo.class.getResource("imagenes/" + pURLImagen);
                        BufferedImage img = ImageIO.read(imagen);
			BgBorder borde = new BgBorder( img );
			setBorder(borde);
		} catch (IOException e) {
			System.out.println(e);
		}

		setLayout(null);
    }
    
    /****************Metodos****************/
    private void iniciar(){
        
    }
    
    /*********** Getters/Setters ***********/

}
