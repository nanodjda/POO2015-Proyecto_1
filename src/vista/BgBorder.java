/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package vista;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;

/**
 * Crea un borde con la imagen dada
 * 
 * @author David 19/09/2015
 */
public class BgBorder implements Border {
    
    /************** Variables **************/
    private BufferedImage mImagen = null;

    /************* Constructor *************/
    public BgBorder(BufferedImage pImagen) {
            mImagen = pImagen;
    }

    /****************Metodos abstractos****************/
    
    public void paintBorder(Component c, Graphics g, int x, int y, int width,int height) 
    {
            if (mImagen != null) {
                    g.drawImage(mImagen, 0, 0, width, height, null);
            }
    }

    public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, 0, 0);
    }

    public boolean isBorderOpaque() {
            return true;
    }
}
