/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import java.util.ArrayList;

/**
 * @author Arturo 19/09/2015
 * @author David 17/09/2015
 */
public class Prestamo {

    /************** Variables **************/
    private final int idPrestamo;
    private static int idGlobal = 0;
    private Persona persona;
    private ArrayList<Item> items = new ArrayList();
    private Alerta alerta;

    /************* Constructor *************/
    public Prestamo(Persona pPersona){
        persona = pPersona;
        idGlobal += 1;
        idPrestamo = idGlobal;
       // persona.agregarPrestamo();
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
        pItem.prestado();
    }
    
    public void borrarItem(int pIndice) {
        Item temp =items.get(pIndice);
        temp.noPrestado();
        items.remove(pIndice);
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }    
}