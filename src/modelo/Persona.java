/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014
*/

package modelo;

import java.util.ArrayList;

/**
 * @author Esteban 18/09/2015
 * @author Arturo 18/09/2015
 * @author David 17/09/2015
 */
public class Persona {

    /************** Variables **************/
    private String cedula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    protected String telefono;
    protected String correo;
    private ArrayList<Prestamo> prestamos = new ArrayList();
 
    /************* Constructor *************/
    public Persona(String cedula, String nombre, String primerApellido, String segundoApellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    /****************Metodos****************/

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

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void agregarPrestamo(Prestamo pPrestamo) {
        prestamos.add(pPrestamo);
    }
    
    public void borrarPrestamo(int pIndice) {
        prestamos.remove(pIndice);
    }
}