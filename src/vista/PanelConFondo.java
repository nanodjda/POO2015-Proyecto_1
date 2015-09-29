/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package vista;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Crea un JPanel con una imagen de fondo
 * 
 * @author David 19/09/2015
 */
public class PanelConFondo extends JPanel{

    /************* Constructor *************/
    /**
     * Se pide el nombre de una image
     * @param pURLImagen - Nombre de la imagen, debe incluirse el formato de la 
     * imagen.
     */
    public PanelConFondo(String pURLImagen){
        setForeground(SystemColor.controlHighlight);
        try {
            URL imagen = PanelConFondo.class.getResource("imagenes/" + pURLImagen);
            BufferedImage img = ImageIO.read(imagen);
            BgBorder borde = new BgBorder(img);
            setBorder(borde);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen");
        }

        setLayout(null);
    }
}
