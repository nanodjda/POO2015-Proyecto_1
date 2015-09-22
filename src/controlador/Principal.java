/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package controlador;

import vista.Items.AgregarItem;
import java.awt.Font;
import java.util.ArrayList;
import modelo.Logica;
import vista.*;
import modelo.*;

/**
 *
 * @author David 17/09/2015
 */
public class Principal {

    /************** Variables **************/
    
    public static Font fuente1 = new Font("Arial", Font.BOLD, 14);
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<String> tipos = new ArrayList<String>();
    private static ArrayList<String> categorias = new ArrayList<String>();

    Logica logica;
    Coordinador coordinador;
    VentanaPrincipal ventanaPrincipal;
    VentanaTipo ventanaTipo;
    VentanaAdminItems ventanaAdminItems;
    AgregarItem ventanaAgregarItem;
    EditarItems ventanaEditarItems;
    EliminarItem ventanaEliminarItem;
    MostrarItem ventanaMostrarItem;
    
    VentanaAdminTipos ventanaAdminTipos;
    VentanaAdminCate ventanaAdminCate;
    VentanaAdminPersonas ventanaAdminPersonas;
    int alto, ancho;
    
    /************* Constructor *************/
    /**
    * @param args
    */
public static void main(String[] args) {
    Principal miPrincipal=new Principal();
    miPrincipal.setTipo("Default");
    miPrincipal.setTipo("Primero");
    miPrincipal.setTipo("Segundo");
    miPrincipal.setTipo("Uno mas");
    miPrincipal.setCategoria("Categoria 1");
    miPrincipal.setCategoria("Categoria 2");
    miPrincipal.setCategoria("Categoria 3");
    
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
    ventanaTipo = new VentanaTipo();
    ventanaAdminItems = new VentanaAdminItems();
    ventanaEditarItems = new EditarItems();
    ventanaAgregarItem = new AgregarItem();
    ventanaEliminarItem = new EliminarItem();
    ventanaMostrarItem = new MostrarItem();
    
    ventanaAdminTipos = new VentanaAdminTipos();
    ventanaAdminCate = new VentanaAdminCate();
    ventanaAdminPersonas = new VentanaAdminPersonas();
    logica=new Logica();
    
    coordinador= new Coordinador();

    /*Se establecen las relaciones entre clases*/
    ventanaPrincipal.setCoordinador(coordinador);
    ventanaTipo.setCoordinador(coordinador);
    ventanaAdminItems.setCoordinador(coordinador);
    ventanaAgregarItem.setCoordinador(coordinador);
    ventanaEditarItems.setCoordinador(coordinador);
    ventanaEliminarItem.setCoordinador(coordinador);
    ventanaMostrarItem.setCoordinador(coordinador);
    
    ventanaAdminTipos.setCoordinador(coordinador);
    ventanaAdminCate.setCoordinador(coordinador);
    ventanaAdminPersonas.setCoordinador(coordinador);
    logica.setCoordinador(coordinador);

    /*Se establecen relaciones con la clase coordinador*/
    coordinador.setMiVentanaPrincipal(ventanaPrincipal);
    coordinador.setMiVentanaAdminItems(ventanaAdminItems);
    coordinador.setMiEditarItems(ventanaEditarItems);
    coordinador.setMiAgregarItem(ventanaAgregarItem);
    coordinador.setMiEliminarItem(ventanaEliminarItem);
    coordinador.setMiMostrarItem(ventanaMostrarItem);
    
    coordinador.setMiVentanaTipo(ventanaTipo);
    coordinador.setMiVentanaAdminTipos(ventanaAdminTipos);
    coordinador.setMiVentanaAdminCate(ventanaAdminCate);
    coordinador.setMiVentanaAdminPersonas(ventanaAdminPersonas);
    coordinador.setMiLogica(logica);

    ventanaPrincipal.setVisible(true);
}
    
    /*********** Getters/Setters ***********/
    public static  ArrayList<Item> getItems() {
        return items;
    }

    public static void setItem(Item pItem) {
        items.add(pItem);
    }

    public static ArrayList<String> getTipos() {
        return tipos;
    }

    public static void setTipo(String pTipos) {
        tipos.add(pTipos);
    }
    
    public static ArrayList<String> getCategorias() {
        return categorias;
    }

    public static void setCategoria(String pCategoria) {
        categorias.add(pCategoria);
    }
}
