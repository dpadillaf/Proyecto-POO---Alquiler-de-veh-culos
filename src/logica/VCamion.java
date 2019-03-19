
package logica;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author David Padilla
 */
public class VCamion extends Vehiculo {
    private Date fechaAlquiler;
    private Date fechaEntrega;
    
    public VCamion (){ //constructor por defecto
        super();
    }
//contructor alternativo    
    public VCamion(Date fechaAlquiler, Date fechaEntrega, String nombre, boolean alquilado, String matricula) {
        super(nombre, alquilado, matricula); //llama la instancia del  constructor padre
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
    }
//gets y sets
    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
//sobreescribe el método de la interfaz    
    @Override
    public long devolverElVehiculo (ArrayList<Vehiculo> al, int x, long nk){
        VCamion aux = (VCamion)al.get(x);
        aux.fechaEntrega = new Date ();
        aux.alquilado = false;
        AgenciaAlquilaVehiculos.getVehiculo().getListaVehiculos().add(x, aux);
        return (aux.fechaAlquiler.getTime() - aux.fechaEntrega.getTime() + 1) * AgenciaAlquilaVehiculos.getVehiculo().getP_p_dia();
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Camion" + "   Precio por día: " + AgenciaAlquilaVehiculos.getVehiculo().getP_p_dia();
    }
    
}
