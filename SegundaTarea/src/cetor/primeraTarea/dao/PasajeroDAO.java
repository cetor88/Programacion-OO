/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cetor.primeraTarea.dao;

import cetor.primeraTarea.Pasajero;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
public class PasajeroDAO {
    private List <Pasajero> arrPasajero = new ArrayList<Pasajero>();
    
    public void addPasajero(Pasajero pasajero){
        this.arrPasajero.add(pasajero);
    }
    public Pasajero findPasajero(int dni){
        Pasajero pasajero = new Pasajero();
        for(Pasajero item: arrPasajero ){
            if (item.getDni() == dni ){
              pasajero = item;
            }
        }  
        return pasajero;
    }
    public List <Pasajero> getPasajeros(){
        return this.arrPasajero;
    }
    
    public List<Pasajero> obtenerPasajerosTXT(String nombre){
        try {
            FileReader file = new FileReader("d:\\Test\\historial.txt");//nombre.txt
            BufferedReader buff = new BufferedReader(file);
            String empleado       = "";
            StringTokenizer token = null;
            Pasajero pasajero     = null;
            while( (empleado = buff.readLine())!=null ){
                token = new StringTokenizer(empleado);
                pasajero = new Pasajero();
                pasajero.setDni(Integer.parseInt(token.nextToken() ) );
                pasajero.setNombre(token.nextToken() );
                pasajero.setApPat(token.nextToken()  );
                pasajero.setApMat(token.nextToken()  );
                addPasajero(pasajero);
            }   
            buff.close();
            return arrPasajero;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PasajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return arrPasajero;
        }catch (IOException ex) {
                Logger.getLogger(PasajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return arrPasajero;
        }   
    }
    public boolean rePoblarTXT(Pasajero pasajero){
        try {
            boolean bandera=true;
            FileWriter file     = new FileWriter("d:\\Test\\historial.txt",true);
            BufferedWriter buff = new BufferedWriter(file);
            PrintWriter print = new PrintWriter(buff);
                print.println();
                print.print( pasajero.getDni() + " " + pasajero.getNombre() + " " + pasajero.getApPat() + " " + pasajero.getApMat() );
                
            buff.close();
            return bandera;
        } catch (IOException ex) {
            Logger.getLogger(PasajeroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
