/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import controlador.Principal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Arturo 19/09/2015
 * @author David 17/09/2015
 */
public class Prestamo implements Serializable {

    /************** Variables **************/
    private final int idPrestamo;
    private Persona persona;
    private ArrayList<Item> items = new ArrayList();
    private Alerta alerta;

    /************* Constructor *************/
    public Prestamo(Persona pPersona, Date pFecha_final){
        this.persona = pPersona;
        Principal.idGlobalPrestamo += 1;
        this.idPrestamo = Principal.idGlobalPrestamo;
        persona.agregarPrestamo(this.idPrestamo);
        this.alerta = new Alerta(pFecha_final);
    }
    
    public Prestamo(Persona pPersona, int cantidad_dias){
        this.persona = pPersona;
        Principal.idGlobalPrestamo += 1;
        this.idPrestamo = Principal.idGlobalPrestamo;
        persona.agregarPrestamo(this.idPrestamo);
        this.alerta = new Alerta(cantidad_dias);
    }

    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void agregarItem(Item pItem) {
        items.add(pItem);
        pItem.setPoseedor(this.persona);
        pItem.prestado();
    }
    
    public void borrarItem(Item pItem) {
        items.remove(pItem);
        pItem.setPoseedor(null);
        pItem.noPrestado();
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}