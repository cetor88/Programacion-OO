
package cetor.primeraTarea;

/**
 *
 * @author ana
 */
public class Asiento {
    private int idAsiento;
    private boolean estado;
    private int idPasajero;
    
    public Asiento(){}
   
    public int getIdAsiento() {
        return idAsiento;
    }
    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }
    public String toString() {
        return "idAsiento-> " + idAsiento +" estado-> " + estado + " idPasajero-> "+idPasajero;
    }
    
}
