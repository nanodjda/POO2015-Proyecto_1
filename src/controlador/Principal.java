/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package controlador;

import vista.Personas.*;
import vista.Prestamos.*;
import vista.Categorias.*;
import vista.Tipos.*;
import vista.Items.*;
import java.awt.Font;
import java.util.ArrayList;
import modelo.Logica;
import vista.*;
import modelo.*;
import vista.Tipos.AgregarTipo;

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
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    public static int idGlobalPrestamo = 0;
    public static int idGlobalItem = 0;

    Logica logica;
    Coordinador coordinador;
    VentanaPrincipal ventanaPrincipal;
    
    VentanaAdminItems ventanaAdminItems;
    AgregarItem ventanaAgregarItem;
    EditarItems ventanaEditarItems;
    EliminarItem ventanaEliminarItem;
    MostrarItem ventanaMostrarItem;
    
    VentanaTipo ventanaTipo;
    VentanaAdminTipos ventanaAdminTipos;
    AgregarTipo ventanaAgregarTipo;
    ModificarTipo ventanaModificarTipo;
    EliminarTipo ventanaEliminarTipo;
    MostrarTipo ventanaMostrarTipo;
    
    VentanaAdminCate ventanaAdminCate;
    AgregarCategoria ventanaAgregarCategoria;
    ModificarCategoria ventanaModificarCategoria;
    EliminarCategoria ventanaEliminarCategoria;
    MostrarCategoria ventanaMostrarCategoria;
    
    VentanaAdminPersonas ventanaAdminPersonas;
    AgregarPersona ventanaAgregarPersona;
    ModificarPersona ventanaModificarPersona;
    EliminarPersona ventanaEliminarPersona;
    MostrarPersona ventanaMostrarPersona;
    
    VentanaAdminPrestamos ventanaAdminPrestamos;
    AgregarPrestamo ventanaAgregarPrestamo;
    ModificarPrestamo ventanaModificarPrestamo;
    EliminarPrestamo ventanaEliminarPrestamo;
    MostrarPrestamo ventanaMostrarPrestamo;
    
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
    miPrincipal.setPersona(new Persona("1", "David", "Diaz", "Aguilar"));
    miPrincipal.setItem(new Item("Item1", "1", "Primero"));
    miPrincipal.setItem(new Item("Item2", "2", "Primero"));
    miPrincipal.setItem(new Item("Item3", "3", "Primero"));
    
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
    ventanaAdminItems = new VentanaAdminItems();
    ventanaAgregarItem = new AgregarItem();
    ventanaEditarItems = new EditarItems();
    ventanaEliminarItem = new EliminarItem();
    ventanaMostrarItem = new MostrarItem();
    
    ventanaTipo = new VentanaTipo();
    ventanaAdminTipos = new VentanaAdminTipos();
    ventanaAgregarTipo = new AgregarTipo();
    ventanaModificarTipo = new ModificarTipo();
    ventanaEliminarTipo = new EliminarTipo();
    ventanaMostrarTipo = new MostrarTipo();
            
    ventanaAdminCate = new VentanaAdminCate();
    ventanaAgregarCategoria = new AgregarCategoria();
    ventanaModificarCategoria = new ModificarCategoria();
    ventanaEliminarCategoria = new EliminarCategoria();
    ventanaMostrarCategoria = new MostrarCategoria();
    
    ventanaAdminPersonas = new VentanaAdminPersonas();
    ventanaAgregarPersona = new AgregarPersona();
    ventanaModificarPersona = new ModificarPersona();
    ventanaEliminarPersona = new EliminarPersona();
    ventanaMostrarPersona = new MostrarPersona();
    
    ventanaAdminPrestamos = new VentanaAdminPrestamos();
    ventanaAgregarPrestamo = new AgregarPrestamo();
    ventanaModificarPrestamo = new ModificarPrestamo();
    ventanaEliminarPrestamo = new EliminarPrestamo();
    ventanaMostrarPrestamo = new MostrarPrestamo();
    
    
    logica=new Logica();
    
    coordinador= new Coordinador();

    /*Se establecen las relaciones entre clases*/
    ventanaPrincipal.setCoordinador(coordinador);
    
    ventanaAdminItems.setCoordinador(coordinador);
    ventanaAgregarItem.setCoordinador(coordinador);
    ventanaEditarItems.setCoordinador(coordinador);
    ventanaEliminarItem.setCoordinador(coordinador);
    ventanaMostrarItem.setCoordinador(coordinador);
    
    ventanaTipo.setCoordinador(coordinador);
    ventanaAdminTipos.setCoordinador(coordinador);
    ventanaAgregarTipo.setCoordinador(coordinador);
    ventanaModificarTipo.setCoordinador(coordinador);
    ventanaEliminarTipo.setCoordinador(coordinador);
    ventanaMostrarTipo.setCoordinador(coordinador);
    
    ventanaAdminCate.setCoordinador(coordinador);
    ventanaAgregarCategoria.setCoordinador(coordinador);
    ventanaModificarCategoria.setCoordinador(coordinador);
    ventanaEliminarCategoria.setCoordinador(coordinador);
    ventanaMostrarCategoria.setCoordinador(coordinador);
    
    ventanaAdminPersonas.setCoordinador(coordinador);
    ventanaAgregarPersona.setCoordinador(coordinador);
    ventanaModificarPersona.setCoordinador(coordinador);
    ventanaEliminarPersona.setCoordinador(coordinador);
    ventanaMostrarPersona.setCoordinador(coordinador);
    
    ventanaAdminPrestamos.setCoordinador(coordinador);
    ventanaAgregarPrestamo.setCoordinador(coordinador);
    ventanaModificarPrestamo.setCoordinador(coordinador);
    ventanaEliminarPrestamo.setCoordinador(coordinador);
    ventanaMostrarPrestamo.setCoordinador(coordinador);
    
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
    coordinador.setMiAgregarTipo(ventanaAgregarTipo);
    coordinador.setMiModificarTipo(ventanaModificarTipo);
    coordinador.setMiEliminarTipo(ventanaEliminarTipo);
    coordinador.setMiMostrarTipo(ventanaMostrarTipo);
    
    coordinador.setMiVentanaAdminCate(ventanaAdminCate);
    coordinador.setMiAgregarCategoria(ventanaAgregarCategoria);
    coordinador.setMiModificarCategoria(ventanaModificarCategoria);
    coordinador.setMiEliminarCategoria(ventanaEliminarCategoria);
    coordinador.setMiMostrarCategoria(ventanaMostrarCategoria);
    
    coordinador.setMiVentanaAdminPersonas(ventanaAdminPersonas);
    coordinador.setMiAgregarPersona(ventanaAgregarPersona);
    coordinador.setMiModificarPersona(ventanaModificarPersona);
    coordinador.setMiEliminarPersona(ventanaEliminarPersona);
    coordinador.setMiMostrarPersona(ventanaMostrarPersona);
    
    coordinador.setMiVentanaAdminPrestamos(ventanaAdminPrestamos);
    coordinador.setMiAgregarPrestamo(ventanaAgregarPrestamo);
    coordinador.setMiModificarPrestamo(ventanaModificarPrestamo);
    coordinador.setMiEliminarPrestamo(ventanaEliminarPrestamo);
    coordinador.setMiMostrarPrestamo(ventanaMostrarPrestamo);
    
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

    public static ArrayList<Persona> getPersonas() {
        return personas;
    }

    public static void setPersona(Persona pPersonas) {
        personas.add(pPersonas);
    }
    
    public static ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public static void setPrestamo(Prestamo pPrestamo) {
        prestamos.add(pPrestamo);
    }
    
}
