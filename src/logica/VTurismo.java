
package logica;

import java.util.ArrayList;

/**
 *
 * @author David Padilla
 */
public class VTurismo extends Vehiculo {
    private long kilometraje;
    
    public VTurismo (){ //contructor por defecto
        super();
    }
//contrsuctor alternativo
    public VTurismo(long kilometraje, String nombre, boolean alquilado, String matricula) {
        super(nombre, alquilado, matricula); //llama a la instancia en el contructor padre
        this.kilometraje = kilometraje;
    }
//gets y sets
    public long getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(long kilometraje) {
        this.kilometraje = kilometraje;
    }

 //sobreescribe el método de la interfaz   
    @Override
    public long devolverElVehiculo (ArrayList<Vehiculo> al, int x, long nk){
        VTurismo aux = (VTurismo)al.get(x);
        return (nk - aux.getKilometraje()) * AgenciaAlquilaVehiculos.getVehiculo().getP_p_kilometro();
    }

    @Override
    public String toString() {
        return "Vehículo tipo: Turismo" + "   Precio por Kilometro: " + AgenciaAlquilaVehiculos.getVehiculo().getP_p_kilometro();
    }
}
