/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author David 20/09/2015
 */
public class BotonFondo extends JButton{

    /************** Variables **************/
    private int x, y, ancho, alto;
    
    /************* Constructor *************/
    public BotonFondo(String pNombre, String pURLImagen, int pAncho, int pAlto){
        super(pNombre);
        ImageIcon icon = new ImageIcon(getClass().getResource("/vista/imagenes/" + pURLImagen));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(pAncho, pAlto, Image.SCALE_SMOOTH) ;  
        icon = new ImageIcon( newimg );
        
        this.setIcon(icon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setForeground(Color.red);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    public BotonFondo(String pURLImagen, int x, int y, int pAncho, int pAlto){
        ImageIcon icon = new ImageIcon(getClass().getResource("/vista/imagenes/" + pURLImagen));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(pAncho, pAlto, Image.SCALE_SMOOTH) ;  
        icon = new ImageIcon( newimg );
        
        this.setBounds(x, y, pAncho, pAlto);
        this.setIcon(icon);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    /****************Metodos****************/

    /*********** Getters/Setters ***********/

}
