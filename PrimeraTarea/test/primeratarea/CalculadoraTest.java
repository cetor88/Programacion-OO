/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeratarea;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.containsString;

import tem.operacion.Calculadora;
/**
 *
 * @author Celeritech Peru
 */
public class CalculadoraTest {
    @Test //1
    public void agregarRetornaCeroCuandoLaEntradaEsVacia() {

        int resultado = Integer.parseInt(Calculadora.agregar(""));
        assertEquals(0, resultado);
    }

    @Test //2
    public void agregarRetornaCeroCuandoLaEntradaEsNula() {

        int resultado = Integer.parseInt(Calculadora.agregar(null) );
        assertEquals(0, resultado);
    }

    @Test //3
    public void agregarRetornaNumeroCuandoLaEntradaEsSimpleNumeroEnString() {

        int resultado = Integer.parseInt(Calculadora.agregar("0") );
        assertEquals(0, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("1") );
        assertEquals(1, resultado);
        resultado = Integer.parseInt( Calculadora.agregar("2") );
        assertEquals(2, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("3") );
        assertEquals(3, resultado);
    }

    @Test //4
    public void agregarRetornaNumeroCuandoLaEntradaSonVariosNumerosEnString() {

        int resultado = Integer.parseInt(Calculadora.agregar("0,1,2,3,4,555") );
        assertEquals(565, resultado);
    }

    @Test //5
    public void agregarRetornaSumaCuandoLaEntradaEsMultiplesNumerosEnStringConNuevaLineaComoDelimitador() {
        int resultado = Integer.parseInt(Calculadora.agregar("1,2,3") );
        assertEquals(6, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("3\n2") );
        assertEquals(5, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("1\n2,3") );
        assertEquals(6, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("1\n2\n3,4,5") );
        assertEquals(15, resultado);
    }

    @Test //6
    public void agregarRetornaSumaCuandoLaEntradaEsMultipleNumerosEnString() {
        int resultado = Integer.parseInt(Calculadora.agregar("0,3,3") );
        assertEquals(6, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("0,2,2") );
        assertEquals(4, resultado);
    }

    @Test //7
    public void agregarRetornaSumaIgnorandoCantidadesMayoresAMil() {
        int resultado = Integer.parseInt(Calculadora.agregar("0,3,1001") );
        assertEquals(3, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("0,3,1000") );
        assertEquals(1003, resultado);
    }

     
    @Test //8
    public void agregarCuandoLaEntradaDefineDelimitadorYSeUsaDelimitador(){
        int resultado = Integer.parseInt(Calculadora.agregar("//*\n1*2") );
        assertEquals(3, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("//;\n1;2") );
        assertEquals(3, resultado);
        resultado = Integer.parseInt(Calculadora.agregar("//;\n1;2;3;4;5;6;7;8;9;10") );
        assertEquals(55, resultado);
    }
    
    //Recuerde que este ya es opcional
    @Test  //9
    public void agregarArrojaArgumentExceptionCuandoLaEntradaStringNoSigueLasReglas(){
        
        try {
            int resultado = Integer.parseInt(Calculadora.agregar("1,-1") );
            fail("expected IllegalArgumentException for agregar");
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), 
                    containsString(
                            String.format("string contiene [{0}], el cual no "
                                    + "corresponde con las reglas. Los numeros ingresados"
                                    + " no pueden ser negativos.", "-1")));
        }        
        
    }
}
