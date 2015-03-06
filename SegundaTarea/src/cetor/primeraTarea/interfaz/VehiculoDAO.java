/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cetor.primeraTarea.interfaz;

import cetor.primeraTarea.AutoBus;
import cetor.primeraTarea.Pasajero;

/**
 *
 * @author ana
 */
public interface VehiculoDAO {
    public boolean apartarAsiento(AutoBus autoBus, Pasajero pasajero);
    public AutoBus crearVehiculo();
}
