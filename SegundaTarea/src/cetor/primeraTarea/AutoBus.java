/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cetor.primeraTarea;

import java.util.List;

/**
 *  
 * @author ana
 */
public class AutoBus {
    private int idAutoBus;
    private List <Asiento> listAsiento;
    private static AutoBus autoBus;
    private  AutoBus(){}
    public static AutoBus getInstancia(){//List <Asiento> listAsient){
       autoBus = (autoBus == null) ? new AutoBus(): autoBus;
            /*boolean bandera = false;
            for(Asiento asiento: listAsient){
                bandera = asiento.isEstado()==false?false:true;
           }*/
            
        
        return autoBus;
    }
    
    public int getIdVehiculo() {
        return idAutoBus;
        
    }
    public void setIdVehiculo(int idVehiculo) {
        this.idAutoBus = idVehiculo;
    }

    public List<Asiento> getListAsiento() {
        return listAsiento;
    }

    public void setListAsiento(List<Asiento> listAsiento) {
        this.listAsiento = listAsiento;
    }
    
    public String  toString(){
    return "idVehiculo-> " + idAutoBus + " listAsiento-> " +listAsiento;
    }

}
