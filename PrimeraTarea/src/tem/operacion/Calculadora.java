/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tem.operacion;  

/**
 *
 * @author ana
 */
public class Calculadora {
    
    public static String agregar(String entry) throws IllegalArgumentException{
        int suma = 0;
        String valReturn = ( (entry == "" || entry == null) ? "" + suma: entry );
        if ( !valReturn.equals("0") ){
            if(entry.contains("-")){
                throw new IllegalArgumentException("string contiene [{0}], el cual no "
                                    + "corresponde con las reglas. Los numeros ingresados"
                                    + " no pueden ser negativos.");
            }
        String[] arrNumbers = entry.split("\\D+");
        for (int i=0; i< arrNumbers.length; i++){
            if("".equals(arrNumbers[0])){
                arrNumbers[0] = "0";
            }
            if( Integer.parseInt(arrNumbers[i]) < 1001 ){
                suma += Integer.parseInt(arrNumbers[i]);
            }
            System.out.println("arrNumbers [" +arrNumbers[i]+ "]");
        }
    }
        valReturn = "" + suma;
    return valReturn;
    }/*
    public static int agregar(String resulta) {
        int mensaje = 0;
        if(resulta == "" || resulta == null)
        {
        mensaje = 0;
        }
        else if(resulta != null )
        {
        String[] cadena = resulta.split("\\D+");
        for(int a = 0; a < cadena.length; a++)
        {
        if("".equals(cadena[0]))
        cadena[0] = "0";
        }
        for(int i = 0; i < cadena.length; i++)
        {

        if(Integer.parseInt(cadena[i]) < 1001)
        {
        mensaje = mensaje + Integer.parseInt(cadena[i]);
        }
        }
        }
        return mensaje;
    }
*/
}
