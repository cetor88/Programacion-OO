
package cetor.primeraTarea;

/**
 *
 * @author ana
 */
public class Pasajero {
    
    private int dni;
    private String nombre;
    private String apPat;
    private String apMat;

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }
    
    public String toString(){
        return "DNI-> "+ this.dni + "\n" +
                "NOMBRE-> " + this.nombre   +"\n"+ 
                "APPATERNO-> " + this.apPat + "\n"+
                "APMATERNO-> " + this.apMat + "\n";
    }
}
