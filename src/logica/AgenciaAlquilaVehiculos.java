package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author David Padilla
 */
public class AgenciaAlquilaVehiculos implements Serializable {
    private String nombre;
    private ArrayList<Vehiculo> listaVehiculos;
    private long p_p_dia;
    private long p_p_kilometro;
    public static AgenciaAlquilaVehiculos nuevo = null;
    
    public AgenciaAlquilaVehiculos (){
       this.listaVehiculos = new ArrayList<Vehiculo> (); 
    }

    public AgenciaAlquilaVehiculos(String nombre) {
        this.nombre = nombre;
        this.listaVehiculos = new ArrayList<Vehiculo> ();
    }

    public long getP_p_dia() {
        return p_p_dia;
    }

    public void setP_p_dia(long p_p_dia) {
        this.p_p_dia = p_p_dia;
    }

    public long getP_p_kilometro() {
        return p_p_kilometro;
    }

    public void setP_p_kilometro(long p_p_kilometro) {
        this.p_p_kilometro = p_p_kilometro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
    
    public int buscarVehiculo (String mat, ArrayList<Vehiculo> alv){
        for (int i=0; i<alv.size(); i++){
            if (alv.get(i).getMatricula().equals(mat.toUpperCase())){
                return i;
            }
        }
        return -1;
    }
    
    public boolean alquilarVehiculo (int x){
        if (listaVehiculos.get(x).alquilado == true){
            return false;
        }else{
            listaVehiculos.get(x).alquilado = true;
            if (listaVehiculos.get(x) instanceof VCamion){
                VCamion aux = new VCamion (new Date(), null, listaVehiculos.get(x).getNombre(), true, listaVehiculos.get(x).getMatricula());
                listaVehiculos.set(x, aux);
            }
            return true;
        }
    }
    
    public int totalVehiculosTurismo (){
        int cont=0;
        for (int i=0; i<listaVehiculos.size(); i++){
            if (listaVehiculos.get(i) instanceof VTurismo) cont++;
        }
        return cont;
    }
    
    public int totalVehiculosCamion (){
        int cont=0;
        for (int i=0; i<listaVehiculos.size(); i++){
            if (listaVehiculos.get(i) instanceof VCamion) cont++;
        }
        return cont;
    }
    
    public int totalVehiculos (){
        return listaVehiculos.size();
    }
    
        
    public static AgenciaAlquilaVehiculos getVehiculo (){
        if (nuevo == null){
            nuevo = new AgenciaAlquilaVehiculos();
        }
        return nuevo;
    }
    
    public void guardaVehiculos (Vehiculo vh){
        ArrayList<Vehiculo> alv = nuevo.getListaVehiculos();
        alv.add(vh);
        nuevo.setListaVehiculos(alv);
    }
}
