/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import controlador.Principal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Se encarga de crear la instancia de un Prestamo.
 * 
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
    /**
     * Crea la instancia de un Prestamo con una alerta unica y no recurrente.
     * Se asocia una persona al prestamo y se le agrega el prestamo a la persona.
     * 
     * @param pPersona - Persona a la que se asociara el prestamo y viceversa.
     * @param pFecha_final - Fecha en la que se vence el préstamo.
     */
    public Prestamo(Persona pPersona, Date pFecha_final){
        this.persona = pPersona;
        Principal.idGlobalPrestamo += 1;
        this.idPrestamo = Principal.idGlobalPrestamo;
        persona.agregarPrestamo(this.idPrestamo);
        this.alerta = new Alerta(pFecha_final);
    }
    
    /**
     * Crea la instancia de un Prestamo con una alerta recurrente.
     * Se asocia una persona al prestamo y se le agrega el prestamo a la persona.
     * 
     * @param pPersona - Persona a la que se asociara el prestamo y viceversa.
     * @param cantidad_dias - Intervalo de tiempo en el que se avisara la alerta.
     */
    public Prestamo(Persona pPersona, int cantidad_dias){
        this.persona = pPersona;
        Principal.idGlobalPrestamo += 1;
        this.idPrestamo = Principal.idGlobalPrestamo;
        persona.agregarPrestamo(this.idPrestamo);
        this.alerta = new Alerta(cantidad_dias);
    }

    /****************Metodos****************/

    public void agregarItem(Item pItem) {
        items.add(pItem);
        pItem.setPoseedor(this.persona);
        pItem.prestado();
    }
    
    /*********** Getters/Setters ***********/
    
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public ArrayList<Item> getItems() {
        return items;
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