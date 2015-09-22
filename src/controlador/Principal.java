/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package controlador;

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
    VentanaItems ventanaItems;
    VentanaTipo ventanaTipo;
    VentanaAdminItems ventanaAdminItems;
    VentanaAdminTipos ventanaAdminTipos;
    VentanaAdminCate ventanaAdminCate;
    VentanaAdminPersonas ventanaAdminPersonas;
    AgregarItem ventanaAgregarItem;
    int alto, ancho;
    
    /************* Constructor *************/
    /**
    * @param args
    */
public static void main(String[] args) {
    Principal miPrincipal=new Principal();
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
    ventanaItems = new VentanaItems();
    ventanaTipo = new VentanaTipo();
    ventanaAdminItems = new VentanaAdminItems();
    ventanaAdminTipos = new VentanaAdminTipos();
    ventanaAdminCate = new VentanaAdminCate();
    ventanaAdminPersonas = new VentanaAdminPersonas();
    ventanaAgregarItem = new AgregarItem();
    logica=new Logica();
    
    coordinador= new Coordinador();

    /*Se establecen las relaciones entre clases*/
    ventanaPrincipal.setCoordinador(coordinador);
    ventanaItems.setCoordinador(coordinador);
    ventanaTipo.setCoordinador(coordinador);
    ventanaAdminItems.setCoordinador(coordinador);
    ventanaAdminTipos.setCoordinador(coordinador);
    ventanaAdminCate.setCoordinador(coordinador);
    ventanaAdminPersonas.setCoordinador(coordinador);
    ventanaAgregarItem.setCoordinador(coordinador);
    logica.setCoordinador(coordinador);

    /*Se establecen relaciones con la clase coordinador*/
    coordinador.setMiVentanaPrincipal(ventanaPrincipal);
    coordinador.setMiVentanaItems(ventanaItems);
    coordinador.setMiVentanaTipo(ventanaTipo);
    coordinador.setMiVentanaAdminItems(ventanaAdminItems);
    coordinador.setMiVentanaAdminTipos(ventanaAdminTipos);
    coordinador.setMiVentanaAdminCate(ventanaAdminCate);
    coordinador.setMiVentanaAdminPersonas(ventanaAdminPersonas);
    coordinador.setMiAgregarItem(ventanaAgregarItem);
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
