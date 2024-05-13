package ar.edu.utn.frbb.tup.input;

import java.time.LocalDate;

import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.model.TipoCuenta;
import ar.edu.utn.frbb.tup.model.Cliente;

public class CuentaInputProcessor extends BaseInputProcessor{

    private Banco banco;

    public CuentaInputProcessor(Banco banco) { //constructor
        this.banco = banco;
    }

    public Cuenta ingresarCuenta() {

        Cuenta nuevaCuenta = new Cuenta();
        //le pregunto al cliente que ingrese el dni y me fijo en el banco, uno por  uno que exista 
        Cliente clienteEncontrado = null;
        String opcion = "";
        while (clienteEncontrado==null && opcion!="s") {
            System.out.println("Ingrese su numero de dni:");
            long dni = scanner.nextLong();
        
        
            for (Cliente cliente : banco.getClientes()) {
                if (cliente.getDni() == dni) {
                    clienteEncontrado = cliente;
                    break;
                }
            }

        }

        if (clienteEncontrado !=null){
            nuevaCuenta.setCliente(clienteEncontrado);
            clienteEncontrado.getCuentas().add(nuevaCuenta);
        } else {
            System.out.println("DNI no encontrado.");
        }
        


        // Solicita al usuario que seleccione el tipo de cuenta
        System.out.println("Seleccione el tipo de cuenta para el cliente (1. Caja de ahorro, 2. Cuenta corriente):");
        int opcionTipoCuenta = scanner.nextInt();
        TipoCuenta tipoCuentaSeleccionado = null;
        if (opcionTipoCuenta == 1) {
            tipoCuentaSeleccionado = TipoCuenta.CAJA_DE_AHORRO;
        } else if (opcionTipoCuenta == 2) {
            tipoCuentaSeleccionado = TipoCuenta.CUENTA_CORRIENTE;
        } else {
            System.out.println("Opción inválida. Se asignará tipo de cuenta por defecto.");
            tipoCuentaSeleccionado = TipoCuenta.CAJA_DE_AHORRO;
        }

        LocalDate fechaAlta = LocalDate.now(); 
        nuevaCuenta.setFechaCreacion(fechaAlta);
        nuevaCuenta.setTipoCuenta(tipoCuentaSeleccionado);
        nuevaCuenta.setNumero(banco.getSiguienteNroCuenta());
        nuevaCuenta.setSaldo(0);
        
        
        return nuevaCuenta;


        
    }


    
}
