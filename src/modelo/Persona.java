/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Se encarga de instanciar una nueva Persona en el sistema.
 * 
 * @author Esteban 18/09/2015
 * @author Arturo 18/09/2015
 * @author David 17/09/2015
 */
public class Persona implements Serializable {

    /************** Variables **************/
    private String cedula = "";
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    protected String telefono = "";
    protected String correo = "";
    private ArrayList<Integer> prestamos = new ArrayList();
 
    /************* Constructor *************/
    
    /**
     * Crea una persona con los datos ingresados.
     * 
     * @param cedula - Identificador unico de la persona
     * @param nombre - Primer nombre de la persona
     * @param primerApellido - Primer apellido de la persona
     * @param segundoApellido - Segundo apellido de la persona
     */
    public Persona(String cedula, String nombre, String primerApellido, String segundoApellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    /****************Metodos****************/

    public void agregarPrestamo(int pPrestamo) {
        prestamos.add(pPrestamo);
    }
    
    public void borrarPrestamo(int pIDPrestamo) {
        for(int i = 0; i < prestamos.size(); i++){
            if(prestamos.get(i).equals(pIDPrestamo)){
                prestamos.remove(i);
            }
        }
    }
    
    /*********** Getters/Setters ***********/
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Integer> getPrestamos() {
        return prestamos;
    }
}