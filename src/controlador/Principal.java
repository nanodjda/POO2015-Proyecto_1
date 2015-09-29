/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package controlador;

import vista.Personas.*;
import vista.Prestamos.*;
import vista.Categorias.*;
import vista.Tipos.*;
import vista.Items.*;
import vista.Reportes.*;
import java.awt.Font;
import java.util.ArrayList;
import modelo.Logica;
import vista.*;
import modelo.*;
import vista.Tipos.AgregarTipo;

/**
 *
 * @author Arturo 17/09/2015
 */
public class Principal {

    /**
     * Variables Globales de la aplicacion
     */
    
    public static Font fuente1 = new Font("Arial", Font.BOLD, 14);
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static ArrayList<Tipo> tipos = new ArrayList<Tipo>();
    private static ArrayList<Categoria> categorias = new ArrayList<>();
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    public static int idGlobalPrestamo = 0;
    public static int idGlobalItem = 0;

    //Declaracion de todas las ventanas
    
    Logica logica;
    Coordinador coordinador;
    VentanaPrincipal ventanaPrincipal;
    BarraMenu barraMenu;
    
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
    
    VentanaAdminReportes ventanaAdminReportes;
    ReporteItems ventanaReporteItems;
    ReporteTipos ventanaReporteTipos;
    ReporteCategorias ventanaReporteCategorias;
    
    /**
     * Main de la aplicacion
    * @param args
    */
    public static void main(String[] args) {
        Principal miPrincipal = new Principal();
        miPrincipal.iniciarVentanas();
    }
    
    /****************Metodos****************/
/**
* Permite instanciar todas las clases con las que trabaja
* el sistema
*/
    private void iniciarVentanas() {
        
        /*Se instancian las clases de las ventanas u otras contenidas dentro del coordinador*/
        
        ventanaPrincipal=new VentanaPrincipal(900, 500);
        barraMenu = new BarraMenu();
        
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

        ventanaAdminReportes = new VentanaAdminReportes();
        ventanaReporteItems = new ReporteItems();
        ventanaReporteTipos = new ReporteTipos();
        ventanaReporteCategorias = new ReporteCategorias();

        logica=new Logica();
        coordinador= new Coordinador();

        
        /**
         * Se les asigna un controlador a cada clase o ventana
         * Cada bloque corresponde a una seccion del programa
         * Ordenados en el siguiente orden:
         * - VentanaPrincipal
         * - Administracion de Items
         * - Administracion de Tipos
         * - Administracion de Categorias
         * - Administracion de Personas
         * - Administracion de Prestamos
         * - Reportes
         */
        
        ventanaPrincipal.setCoordinador(coordinador);
        barraMenu.setCoordinador(coordinador);

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

        ventanaAdminReportes.setCoordinador(coordinador);
        ventanaReporteItems.setCoordinador(coordinador);
        ventanaReporteTipos.setCoordinador(coordinador);
        ventanaReporteCategorias.setCoordinador(coordinador);

        logica.setCoordinador(coordinador);

        /**
         * Se le asigna al coordinador cada una de las ventanas o clases
         */
        
        coordinador.setMiVentanaPrincipal(ventanaPrincipal);
        coordinador.setMiBarraMenu(barraMenu);

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

        coordinador.setMiVentanaAdminReportes(ventanaAdminReportes);
        coordinador.setMiReporteItems(ventanaReporteItems);
        coordinador.setMiReporteTipos(ventanaReporteTipos);
        coordinador.setMiReporteCategorias(ventanaReporteCategorias);

        coordinador.setMiLogica(logica);

        /**
         * Se cargan los datos y se muestran las alertas
         */

        coordinador.getMiLogica().cargarDatos();
        ventanaPrincipal.setBarraMenu(barraMenu);
        ventanaPrincipal.setVisible(true);
        coordinador.getMiLogica().revisarAlertas();
    }
    
    /*********** Getters/Setters ***********/
    public static  ArrayList<Item> getItems() {
        return items;
    }

    public static void setItem(Item pItem) {
        items.add(pItem);
    }

    public static ArrayList<Tipo> getTipos() {
        return tipos;
    }

    public static void setTipo(Tipo pTipos) {
        tipos.add(pTipos);
    }
    
    public static ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public static void setCategoria(Categoria pCategoria) {
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
    
    /**
     * 
     * Setter de datos guardados
     */
    
    public static void setItems(ArrayList<Item> pItem){
        items = pItem;
    }
    
    public static void setTipos(ArrayList<Tipo> pTipo){
        tipos = pTipo;
    }
    
    public static void setCategorias(ArrayList<Categoria> pCate){
        categorias = pCate;
    }
    
    public static void setPersonas(ArrayList<Persona> pPersona){
        personas = pPersona;
    }
    
    public static void setPrestamos(ArrayList<Prestamo> pPrestamo){
        prestamos = pPrestamo;
    }
    
    public static void setIDPrestamos(int pID){
        idGlobalPrestamo = pID;
    }
    
    public static void setIDItems(int pID){
        idGlobalItem = pID;
    }
}
