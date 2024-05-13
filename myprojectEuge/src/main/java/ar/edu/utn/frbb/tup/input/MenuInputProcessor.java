package ar.edu.utn.frbb.tup.input;

import java.util.InputMismatchException;

import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.model.MovimientoCuenta;



public class MenuInputProcessor extends BaseInputProcessor {
    
    boolean exit = false;
    private Cuenta cuenta;

    public void renderMenu(Banco banco) {
        ClienteInputProcessor clienteInputProcessor = new ClienteInputProcessor(banco);
        CuentaInputProcessor cuentaInputProcessor = new CuentaInputProcessor(banco);
        MovimientoInputProcessor movimientoInputProcessor = new MovimientoInputProcessor(cuenta,banco);

        while (!exit) {
            System.out.println("Bienvenido a la aplicación del Banco!");
            System.out.println("1. Crear un nuevo Cliente");
            System.out.println("2. Realizar un movimiento (deposito, extraccion, transferencia)");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Crear un nueva Cuenta");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción (1-5): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        Cliente cliente = clienteInputProcessor.ingresarCliente();
                        banco.getClientes().add(cliente);
                        
                        break;
                    case 2:
                        MovimientoCuenta movimientoCuenta= movimientoInputProcessor.registrarMovimientoCuenta(); 
                        cuenta.getMovimientos().add(movimientoCuenta);  
                        
                        break;
                    case 3:
                        consultarSaldo(banco);//no crea nuevo movimiento, solo consulta
                        banco.imprimirDatosCuentas();
                        break;
                    case 4:
                        cuenta = cuentaInputProcessor.ingresarCuenta(); // Asigna cuenta a la variable de clase
                        banco.getCuentas().add(cuenta);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor seleccione 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido (1-6).");
            } finally {
                scanner.nextLine(); // Consume la entrada no válida
                
            }

            clearScreen();
        }
    }

    private void consultarSaldo(Banco banco) {
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine(); 
        
        Cuenta cuenta = banco.getCuenta(numeroCuenta);
        
        if (cuenta != null) {
            System.out.println("El saldo de la cuenta es: " + cuenta.getSaldo());
        } else {
            System.out.println("La cuenta no existe");
        }
        
        clearScreen();
    }
    
    
    

}
