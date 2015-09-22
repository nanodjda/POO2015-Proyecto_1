/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package controlador;

import modelo.Logica;
import vista.*;

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
    private VentanaAdminTipos miVentanaAdminTipos;
    private VentanaAdminCate miVentanaAdminCate;
    private VentanaAdminPersonas miVentanaAdminPersonas;
    private AgregarItem miAgregarItem;
    
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
    
    public VentanaAdminTipos getMiVentanaAdminTipos() {
        return miVentanaAdminTipos;
    }

    public void setMiVentanaAdminTipos(VentanaAdminTipos miVentanaAdminTipos) {
        this.miVentanaAdminTipos = miVentanaAdminTipos;
    }

    public VentanaAdminCate getMiVentanaAdminCate() {
        return miVentanaAdminCate;
    }

    public void setMiVentanaAdminCate(VentanaAdminCate miVentanaAdminCate) {
        this.miVentanaAdminCate = miVentanaAdminCate;
    }

    public VentanaAdminPersonas getMiVentanaAdminPersonas() {
        return miVentanaAdminPersonas;
    }

    public void setMiVentanaAdminPersonas(VentanaAdminPersonas miVentanaAdminPersonas) {
        this.miVentanaAdminPersonas = miVentanaAdminPersonas;
    }

    public AgregarItem getMiAgregarItem() {
        return miAgregarItem;
    }

    public void setMiAgregarItem(AgregarItem miAgregarItem) {
        this.miAgregarItem = miAgregarItem;
    }

}
