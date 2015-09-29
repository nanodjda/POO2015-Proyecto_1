/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package controlador;

import vista.Personas.*;
import vista.Tipos.*;
import vista.Items.*;
import vista.Categorias.*;
import vista.Prestamos.*;
import vista.Reportes.*;

import modelo.Logica;
import vista.*;

/**
 *
 * @author David 17/09/2015
 */
public class Coordinador {

    /************** Variables del coordinador**************/
    private Logica logica;
    private VentanaPrincipal miVentanaPrincipal;
    private BarraMenu miBarraMenu;
    
    private VentanaAdminItems miVentanaAdminItems;
    private AgregarItem miAgregarItem;
    private EditarItems miEditarItems;
    private EliminarItem miEliminarItem;
    private MostrarItem miMostrarItem;
    
    private VentanaAdminTipos miVentanaAdminTipos;
    private AgregarTipo miAgregarTipo;
    private ModificarTipo miModificarTipo;
    private EliminarTipo miEliminarTipo;
    private MostrarTipo miMostrarTipo;
    private VentanaTipo miVentanaTipo;
    
    private VentanaAdminCate miVentanaAdminCate;
    private AgregarCategoria miAgregarCategoria;
    private ModificarCategoria miModificarCategoria;
    private EliminarCategoria miEliminarCategoria;
    private MostrarCategoria miMostrarCategoria;
    
    private VentanaAdminPersonas miVentanaAdminPersonas;
    private AgregarPersona miAgregarPersona;
    private ModificarPersona miModificarPersona;
    private EliminarPersona miEliminarPersona;
    private MostrarPersona miMostrarPersona;
    
    private VentanaAdminPrestamos miVentanaAdminPrestamos;
    private AgregarPrestamo miAgregarPrestamo;
    private ModificarPrestamo miModificarPrestamo;
    private EliminarPrestamo miEliminarPrestamo;
    private MostrarPrestamo miMostrarPrestamo;
    
    private VentanaAdminReportes miVentanaAdminReportes;
    private ReporteItems miReporteItems;
    private ReporteTipos miReporteTipos;
    private ReporteCategorias miReporteCategorias;
    
    /*********** Getters/Setters ***********/
    
    /**
     * 
     * Setters y getters de las ventanas que se instancian en el coordinador
     */
    
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

    public EditarItems getMiEditarItems() {
        return miEditarItems;
    }

    public void setMiEditarItems(EditarItems miEditarItems) {
        this.miEditarItems = miEditarItems;
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

    public EliminarItem getMiEliminarItem() {
        return miEliminarItem;
    }

    public void setMiEliminarItem(EliminarItem miEliminarItem) {
        this.miEliminarItem = miEliminarItem;
    }

    public MostrarItem getMiMostrarItem() {
        return miMostrarItem;
    }

    public void setMiMostrarItem(MostrarItem miMostrarItem) {
        this.miMostrarItem = miMostrarItem;
    }

    public AgregarTipo getMiAgregarTipo() {
        return miAgregarTipo;
    }

    public void setMiAgregarTipo(AgregarTipo miAgregarTipo) {
        this.miAgregarTipo = miAgregarTipo;
    }

    public ModificarTipo getMiModificarTipo() {
        return miModificarTipo;
    }

    public void setMiModificarTipo(ModificarTipo miModificarTipo) {
        this.miModificarTipo = miModificarTipo;
    }

    public EliminarTipo getMiEliminarTipo() {
        return miEliminarTipo;
    }

    public void setMiEliminarTipo(EliminarTipo miEliminarTipo) {
        this.miEliminarTipo = miEliminarTipo;
    }

    public MostrarTipo getMiMostrarTipo() {
        return miMostrarTipo;
    }

    public void setMiMostrarTipo(MostrarTipo miMostrarTipo) {
        this.miMostrarTipo = miMostrarTipo;
    }

    public AgregarCategoria getMiAgregarCategoria() {
        return miAgregarCategoria;
    }

    public void setMiAgregarCategoria(AgregarCategoria miAgregarCategoria) {
        this.miAgregarCategoria = miAgregarCategoria;
    }

    public ModificarCategoria getMiModificarCategoria() {
        return miModificarCategoria;
    }

    public void setMiModificarCategoria(ModificarCategoria miModificarCategoria) {
        this.miModificarCategoria = miModificarCategoria;
    }

    public EliminarCategoria getMiEliminarCategoria() {
        return miEliminarCategoria;
    }

    public void setMiEliminarCategoria(EliminarCategoria miEliminarCategoria) {
        this.miEliminarCategoria = miEliminarCategoria;
    }

    public MostrarCategoria getMiMostrarCategoria() {
        return miMostrarCategoria;
    }

    public void setMiMostrarCategoria(MostrarCategoria miMostrarCategoria) {
        this.miMostrarCategoria = miMostrarCategoria;
    }

    public AgregarPersona getMiAgregarPersona() {
        return miAgregarPersona;
    }

    public void setMiAgregarPersona(AgregarPersona miAgregarPersona) {
        this.miAgregarPersona = miAgregarPersona;
    }

    public ModificarPersona getMiModificarPersona() {
        return miModificarPersona;
    }

    public void setMiModificarPersona(ModificarPersona miModificarPersona) {
        this.miModificarPersona = miModificarPersona;
    }

    public EliminarPersona getMiEliminarPersona() {
        return miEliminarPersona;
    }

    public void setMiEliminarPersona(EliminarPersona miEliminarPersona) {
        this.miEliminarPersona = miEliminarPersona;
    }

    public MostrarPersona getMiMostrarPersona() {
        return miMostrarPersona;
    }

    public void setMiMostrarPersona(MostrarPersona miMostrarPersona) {
        this.miMostrarPersona = miMostrarPersona;
    }

    public VentanaAdminPrestamos getMiVentanaAdminPrestamos() {
        return miVentanaAdminPrestamos;
    }

    public void setMiVentanaAdminPrestamos(VentanaAdminPrestamos miVentanaAdminPrestamos) {
        this.miVentanaAdminPrestamos = miVentanaAdminPrestamos;
    }

    public AgregarPrestamo getMiAgregarPrestamo() {
        return miAgregarPrestamo;
    }

    public void setMiAgregarPrestamo(AgregarPrestamo miAgregarPrestamo) {
        this.miAgregarPrestamo = miAgregarPrestamo;
    }

    public ModificarPrestamo getMiModificarPrestamo() {
        return miModificarPrestamo;
    }

    public void setMiModificarPrestamo(ModificarPrestamo miModificarPrestamo) {
        this.miModificarPrestamo = miModificarPrestamo;
    }

    public EliminarPrestamo getMiEliminarPrestamo() {
        return miEliminarPrestamo;
    }

    public void setMiEliminarPrestamo(EliminarPrestamo miEliminarPrestamo) {
        this.miEliminarPrestamo = miEliminarPrestamo;
    }

    public MostrarPrestamo getMiMostrarPrestamo() {
        return miMostrarPrestamo;
    }

    public void setMiMostrarPrestamo(MostrarPrestamo miMostrarPrestamo) {
        this.miMostrarPrestamo = miMostrarPrestamo;
    }

    public VentanaAdminReportes getMiVentanaAdminReportes() {
        return miVentanaAdminReportes;
    }

    public void setMiVentanaAdminReportes(VentanaAdminReportes miVentanaAdminReportes) {
        this.miVentanaAdminReportes = miVentanaAdminReportes;
    }

    public ReporteItems getMiReporteItems() {
        return miReporteItems;
    }

    public void setMiReporteItems(ReporteItems miReporteItems) {
        this.miReporteItems = miReporteItems;
    }

    public ReporteTipos getMiReporteTipos() {
        return miReporteTipos;
    }

    public void setMiReporteTipos(ReporteTipos miReporteTipos) {
        this.miReporteTipos = miReporteTipos;
    }

    public ReporteCategorias getMiReporteCategorias() {
        return miReporteCategorias;
    }

    public void setMiReporteCategorias(ReporteCategorias miReporteCategorias) {
        this.miReporteCategorias = miReporteCategorias;
    }

    public BarraMenu getMiBarraMenu() {
        return miBarraMenu;
    }

    public void setMiBarraMenu(BarraMenu miBarraMenu) {
        this.miBarraMenu = miBarraMenu;
    }
}
