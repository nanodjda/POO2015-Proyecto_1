/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import controlador.Principal;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Arturo 19/09/2015
 * @author David 17/09/2015
 */
public class Prestamo implements Serializable {

    /************** Variables **************/
    private final int idPrestamo;
    private Persona persona;
    private ArrayList<String> items = new ArrayList();
    private Alerta alerta;

    /************* Constructor *************/
    public Prestamo(Persona pPersona){
        this.persona = pPersona;
        Principal.idGlobalPrestamo += 1;
        this.idPrestamo = Principal.idGlobalPrestamo;
        persona.agregarPrestamo(this.idPrestamo);
    }

    /****************Metodos****************/

    /*********** Getters/Setters ***********/
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void agregarItem(String pItem) {
        items.add(pItem);
        for(Item it : Principal.getItems()){
            if(it.getCodigo().equals(pItem)){
                it.prestado();
            }
        }
    }
    
    public void borrarItem(String pItem) {
        items.remove(pItem);
        for(Item it : Principal.getItems()){
            if(it.getCodigo().equals(pItem)){
                it.noPrestado();
            }
        }
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}