/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import controlador.Principal;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase se encarga de crear la instancia de un Item.
 * 
 * @author Arturo 18/09/2015
 * @author David 17/09/2015
 */
public class Item implements Serializable{

    /************** Variables **************/
    private String nombre;
    private String codigo;
    private String descripcion = "Sin descripcion";
    private Tipo tipo;
    private ArrayList<Categoria> categorias = new ArrayList<>();
    private Persona poseedor = null;
    private boolean estado = false;
            
    /************* Constructor *************/
    /**
     * Crea un item con los datos básicos importantes de la instancia.
     * Luego de instanciado el item, se aumenta en 1 el idGlobalItem.
     * 
     * @param pNombre - Nombre del item.
     * @param pCodigo - Codigo unico del item.
     * @param pTipo - Tipo unico del item.
     */
    public Item(String pNombre, String pCodigo, Tipo pTipo){
        this.nombre = pNombre;
        this.tipo = pTipo;
        this.codigo = String.valueOf(Principal.idGlobalItem + 1);
        Principal.idGlobalItem += 1;
    }

    /****************Metodos****************/
    public void prestado() {
        this.estado = true;
    }

    public void noPrestado() {
        this.estado = false;
        this.poseedor = null;
    }
    
    public void agregarCategoria(Categoria pCategoria){
        categorias.add(pCategoria);
    }
    
    public void borrarCategoria(int pIndice){
        categorias.remove(pIndice);
    }
    
    /*********** Getters/Setters ***********/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public void setTipo(Tipo pTipo){
        this.tipo = pTipo;
    }

    public Persona getPoseedor() {
        return poseedor;
    }

    public void setPoseedor(Persona poseedor) {
        this.poseedor = poseedor;
    }
    
}
