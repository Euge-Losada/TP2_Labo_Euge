package ar.edu.utn.frbb.tup.input;

import junit.framework.TestCase;
import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cliente;

public class ClienteInputProcessorTest extends TestCase {

    public void testIngresarCliente() {
        Banco banco = new Banco();
        ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor(banco);

        Cliente cliente = clienteInputProcessor.ingresarCliente();

        assertNotNull(cliente);
        assertNotNull(cliente.getNombre());
        assertNotNull(cliente.getApellido());
        assertNotNull(cliente.getTipoPersona());
        assertNotNull(cliente.getBanco());
        assertNotNull(cliente.getFechaAlta());
        assertNotNull(cliente.getEmail());
    }


}
