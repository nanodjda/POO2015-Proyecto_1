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
public class Coordinador {

    /************** Variables **************/
    private Logica logica;
    private VentanaPrincipal miVentanaPrincipal;
    private VentanaItems miVentanaItems;
    private VentanaTipo miVentanaTipo;
    private VentanaAdminItems miVentanaAdminItems;
    /************* Constructor *************/

    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public Logica getMiLogica() {
        return logica;
    }
    
    public void setMiLogica(Logica miLogica) {
        this.logica = miLogica;
    }
    
    public VentanaPrincipal getMiVentanaPrincipal() {
        return miVentanaPrincipal;
    }
    
    public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
        this.miVentanaPrincipal = miVentanaPrincipal;
    }

    public VentanaItems getMiVentanaItems() {
        return miVentanaItems;
    }

    public void setMiVentanaItems(VentanaItems miVentanaItems) {
        this.miVentanaItems = miVentanaItems;
    }

    public VentanaTipo getMiVentanaTipo() {
        return miVentanaTipo;
    }

    public void setMiVentanaTipo(VentanaTipo miVentanaTipo) {
        this.miVentanaTipo = miVentanaTipo;
    }

    public VentanaAdminItems getMiVentanaAdminItems() {
        return miVentanaAdminItems;
    }

    public void setMiVentanaAdminItems(VentanaAdminItems miVentanaAdminItems) {
        this.miVentanaAdminItems = miVentanaAdminItems;
    }
    
}
