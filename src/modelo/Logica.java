/**
* David Diaz Aguilar - 2014004725
* Arturo Luna Izaguirre - 2014110993
* Esteban Chinchilla Fallas - 2014001630
*/

package modelo;

import controlador.Coordinador;
import controlador.Principal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;
import vista.miVentanaAlerta;

/**
 * Esta clase se encarga de la carga y guardado de datos de la aplicacion en un
 * archivo. Tambien se encarga de mostrar una ventana con las alertas.
 * 
 * @author David 17/09/2015
 */
public class Logica {

    /************** Variables **************/
    private Coordinador coordinador;

    /****************Metodos****************/
    
    public void guardarDatos(ArrayList<Item> items, ArrayList<Tipo> tipos, ArrayList<Categoria> categorias, 
            ArrayList<Persona> personas, ArrayList<Prestamo> prestamos, int idGlobalPrestamo, int idGlobalItem){
        
        String fileName = "src/controlador/Datos.bin";
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(items);
            os.writeObject(tipos);
            os.writeObject(categorias);
            os.writeObject(personas);
            os.writeObject(prestamos);
            os.writeObject(idGlobalPrestamo);
            os.writeObject(idGlobalItem);
            os.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void cargarDatos(){
        
        String fileName = "src/controlador/Datos.bin";
        try {
            ObjectInputStream os = new ObjectInputStream(new FileInputStream(fileName));
            Principal.setItems((ArrayList<Item>) os.readObject());
            ArrayList<Tipo> nuevo = (ArrayList<Tipo>) os.readObject();
            if(nuevo.isEmpty()){
                nuevo.add(0, new Tipo("Default"));
            } else if(!nuevo.get(0).getNombre().equals("Default")){
                nuevo.add(0, new Tipo("Default"));
            }
            Principal.setTipos(nuevo);
            Principal.setCategorias((ArrayList<Categoria>) os.readObject());
            Principal.setPersonas((ArrayList<Persona>) os.readObject());
            Principal.setPrestamos((ArrayList<Prestamo>) os.readObject());
            Principal.setIDPrestamos((int) os.readObject());
            Principal.setIDItems((int) os.readObject());
            
        } catch (Exception e) {
            ArrayList<Tipo> nuevo = new ArrayList<>();
            if(nuevo.isEmpty()){
                nuevo.add(0, new Tipo("Default"));
            } else if(!nuevo.get(0).getNombre().equals("Default")){
                nuevo.add(0, new Tipo("Default"));
            }
            Principal.setTipos(nuevo);
        }
    }
    
    public void revisarAlertas(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String[] columnNames = {"Préstamo",
                            "Estado",
                            "Fecha",
                            "Poseedor"};
        Object[][] data = {};
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        for(int i = 0; i < Principal.getPrestamos().size(); i++){
            Date fec = Principal.getPrestamos().get(i).getAlerta().getFec_fin();
            String txt2 = "";
            String txt3 = "";
            String txt4 = "";
            if(new Date().compareTo(fec) > 0){
                int txt1 = Principal.getPrestamos().get(i).getIdPrestamo();
                txt2 = "Vencida";
                if(Principal.getPrestamos().get(i).getAlerta().getTipo().equals("Recurrente")){
                    Principal.getPrestamos().get(i).getAlerta().sumarDias();
                }
                txt3 = formatoFecha.format(fec);
                txt4 = Principal.getPrestamos().get(i).getPersona().getNombre() + " " +
                        Principal.getPrestamos().get(i).getPersona().getPrimerApellido() + " " +
                        Principal.getPrestamos().get(i).getPersona().getSegundoApellido();

                Object[] newRow={txt1, txt2, txt3, txt4};
                dtm.addRow(newRow);
            }
        }
        miVentanaAlerta alertas = new miVentanaAlerta(coordinador.getMiVentanaPrincipal(), "Alertas", 700, 500, dtm);
        alertas.setLocationRelativeTo(null);
        alertas.setVisible(true);
    }
    
    public void revisarTiempo(){
        Timer timer;
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                revisarAlertas();
            }
            };
        
        /**
         * El primer valor es un segundo en ms y el ultimo es el lapso de horas 
         * en la que se mostrara la alerta
        */
        int tiempo = 1000 * 60 * 60 * 6;
        timer.schedule(task, 10, tiempo);
    }
    
    /*********** Getters/Setters ***********/
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}
