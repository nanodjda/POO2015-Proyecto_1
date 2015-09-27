/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import controlador.Coordinador;
import java.util.ArrayList;

/**
 *
 * @author David 17/09/2015
 */
public class Logica {

    /************** Variables **************/
    private Coordinador coordinador;

    /************* Constructor *************/

    /****************Metodos****************/
    
    public void guardarDatos(ArrayList<Item> items, ArrayList<Tipo> tipos, ArrayList<Categoria> categorias, 
            ArrayList<Persona> personas, ArrayList<Prestamo> prestamos, int idGlobalPrestamo, int idGlobalItem){
        
        
    }
    
    /*********** Getters/Setters ***********/
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
