
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author David Padilla
 */
public abstract class Vehiculo implements AccionVehiculo, Serializable {
    protected String nombre;
    protected boolean alquilado;
    protected String matricula;
    protected ArrayList<ImageIcon> fotos;
    
    public Vehiculo (){ //constructor por defecto
        this.fotos = new ArrayList<ImageIcon> ();
    }
//constructor alternativo
    public Vehiculo(String nombre, boolean alquilado, String matricula) {
        this.nombre = nombre;
        this.alquilado = alquilado;
        this.matricula = matricula;
        this.fotos = new ArrayList<ImageIcon> ();
    }
//gets y sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public ArrayList<ImageIcon> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<ImageIcon> fotos) {
        this.fotos = fotos;
    }
    
    public void agregaFotoVehiculo (ImageIcon img, int i){
        ArrayList<ImageIcon> ali = AgenciaAlquilaVehiculos.getVehiculo().getListaVehiculos().get(i).fotos;
        ali.add(img);
        AgenciaAlquilaVehiculos.nuevo.getListaVehiculos().get(i).setFotos(ali);
    }
    
}
