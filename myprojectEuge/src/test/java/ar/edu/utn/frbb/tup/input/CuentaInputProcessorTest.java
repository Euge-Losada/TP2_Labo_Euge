package ar.edu.utn.frbb.tup.input;


import junit.framework.TestCase;

import java.io.ByteArrayInputStream;

import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.input.CuentaInputProcessor;

public class CuentaInputProcessorTest extends TestCase {

    public void testIngresarCuenta() {
        // Simula la entrada del usuario
        String inputUsuario = "123456789"; 
        System.setIn(new ByteArrayInputStream(inputUsuario.getBytes()));
        // Crea una instancia de Banco para pasar como argumento
        Banco banco = new Banco(); 

        // Crea una instancia de CuentaInputProcessor
        CuentaInputProcessor cuentaInputProcessor = new CuentaInputProcessor(banco);

        
        // Ejecuta el método ingresarCuenta()
        Cuenta cuentaCreada = cuentaInputProcessor.ingresarCuenta();

        // Verifica que la cuenta creada no sea nula
        assertNotNull(cuentaCreada);

        // Verifica que el número de cuenta de la cuenta creada coincida con el ingresado
        assertEquals(inputUsuario, cuentaCreada.getNumero());
    }
}
