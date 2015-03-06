package cetor.primeraTarea.dao;

import cetor.primeraTarea.Asiento;
import cetor.primeraTarea.AutoBus;
import cetor.primeraTarea.Pasajero;
import cetor.primeraTarea.interfaz.VehiculoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ana
 */
public class AutoBusImplementsVehiculoDAO implements VehiculoDAO {

    private List<AutoBus> lisVehiculo = new ArrayList<AutoBus>();
    private final int maxAsientos = 40;
    private static int countVehiculo = 0;

    public AutoBusImplementsVehiculoDAO() {

    }

    public List<AutoBus> getLisVehiculo() {
        return lisVehiculo;
    }

    public void setLisVehiculo(List<AutoBus> lisVehiculo) {
        this.lisVehiculo = lisVehiculo;
    }

    public boolean apartarAsiento(AutoBus autoBus, Pasajero pasajero) {
        List<Asiento> asientos = autoBus.getListAsiento();
        boolean bandera = false;
        for (int i = 0; i < asientos.size(); i++) {
            if (asientos.get(i).isEstado() == false) {
                asientos.get(i).setEstado(true);
                asientos.get(i).setIdPasajero(pasajero.getDni());
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    public int personaXBus(int idAutoBus) {
        List<Asiento> listAsiento = null;
        int contador = 0;
        for (AutoBus itemBus : lisVehiculo) {
            if (itemBus.getIdVehiculo() == idAutoBus) {
                listAsiento = itemBus.getListAsiento();
                for (Asiento itemAsient : listAsiento) {
                    if (itemAsient.isEstado() == true) {
                        contador++;
                    }
                }
            }
        }
        return contador;
    }

    public AutoBus buscarPersonaEnBus(int dni) {
        AutoBus bus = null;
        List<Asiento> listAsiento = null;
        for (AutoBus itemBus : lisVehiculo) {
            listAsiento = itemBus.getListAsiento();
            for (Asiento itemAsient : listAsiento) {
                if (itemAsient.getIdPasajero() == dni) {
                    bus = itemBus;
                }
            }
        }
        return bus;
    }

    public AutoBus crearVehiculo() {
        countVehiculo += 1;
        AutoBus bus = null;
        if (lisVehiculo.size() < 7) {// ya que solo cuentan con 6 Buses
            bus = AutoBus.getInstancia(); //singleton
            bus.setIdVehiculo(countVehiculo);
            bus.setListAsiento(crearAsientos());
            lisVehiculo.add(bus);
        }
        return bus;
    }

    private List<Asiento> crearAsientos() {
        List<Asiento> listAsientos = new ArrayList<Asiento>();
        for (int i = 1; i <= maxAsientos; i++) {
            Asiento asiento = new Asiento();
            asiento.setEstado(false);
            asiento.setIdAsiento(i);
            listAsientos.add(asiento);
        }
        return listAsientos;
    }
}