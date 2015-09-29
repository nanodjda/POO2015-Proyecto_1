/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Crea una instancia de una Alerta que posee una fecha inicial
 * y una fecha final, en caso de poseer una cantidad de dias esta sera
 * una alerta recurrente
 * 
 * @author Arturo 17/09/2015
 */
public class Alerta implements Serializable {

    /************** Variables **************/
    private String tipo;
    private int cantidad_dias;
    private Date fec_ini;
    private Date fec_fin;
    
    /************* Constructor *************/
    /**
     * Constructor en el caso de una alerta unica
     * @param pFecha_fin - La fecha de vencimiento del prestamo u alerta
     */
    public Alerta(Date pFecha_fin){
        this.tipo = "Unico";
        this.fec_ini = new Date();
        this.fec_fin = pFecha_fin;
    }
    
    /**
     * Constructor en el caso de un alerta recurrente
     * @param pCantidad - Frecuencia de dias en la que se mostrara la alerta
     */
    public Alerta(int pCantidad){
        this.tipo = "Recurrente";
        this.cantidad_dias = pCantidad;
        this.fec_ini = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fec_ini.getTime());
        cal.add(Calendar.DATE, pCantidad);
        this.fec_fin = new Date(cal.getTimeInMillis());
    }

    /****************Metodos****************/

    public String diafinal(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return formatoFecha.format(fec_fin);
    }
    
    public void sumarDias(){
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fec_fin.getTime());
        cal.add(Calendar.DATE, cantidad_dias);
        this.fec_fin = new Date(cal.getTimeInMillis());
    }
    
    /*********** Getters/Setters ***********/
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFec_ini() {
        return fec_ini;
    }

    public Date getFec_fin() {
        return fec_fin;
    }
}
