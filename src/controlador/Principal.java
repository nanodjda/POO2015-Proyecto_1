/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package controlador;

import modelo.Logica;
import vista.VentanaAdminItems;
import vista.VentanaItems;
import vista.VentanaPrincipal;
import vista.VentanaTipo;

/**
 *
 * @author David 17/09/2015
 */
public class Principal {

    /************** Variables **************/
    Logica logica;
    Coordinador coordinador;
    VentanaPrincipal ventanaPrincipal;
    VentanaItems ventanaItems;
    VentanaTipo ventanaTipo;
    VentanaAdminItems ventanaAdminItems;
    int alto, ancho;
    
    /************* Constructor *************/
    /**
    * @param args
    */
public static void main(String[] args) {
    Principal miPrincipal=new Principal();
    miPrincipal.iniciarVentanas();
}
    
    /****************Metodos****************/
/**
* Permite instanciar todas las clases con las que trabaja
* el sistema
*/
private void iniciarVentanas() {
    /*Se instancian las clases*/
    ventanaPrincipal=new VentanaPrincipal(900, 500);
    ventanaItems = new VentanaItems();
    ventanaTipo = new VentanaTipo();
    ventanaAdminItems = new VentanaAdminItems();
    logica=new Logica();
    coordinador= new Coordinador();

    /*Se establecen las relaciones entre clases*/
    ventanaPrincipal.setCoordinador(coordinador);
    ventanaItems.setCoordinador(coordinador);
    ventanaTipo.setCoordinador(coordinador);
    ventanaAdminItems.setCoordinador(coordinador);
    logica.setCoordinador(coordinador);

    /*Se establecen relaciones con la clase coordinador*/
    coordinador.setMiVentanaPrincipal(ventanaPrincipal);
    coordinador.setMiVentanaItems(ventanaItems);
    coordinador.setMiVentanaTipo(ventanaTipo);
    coordinador.setMiLogica(logica);
    coordinador.setMiVentanaAdminItems(ventanaAdminItems);

    ventanaPrincipal.setVisible(true);
}
    
    /*********** Getters/Setters ***********/

}
