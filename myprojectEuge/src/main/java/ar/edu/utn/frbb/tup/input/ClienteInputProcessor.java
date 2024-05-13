package ar.edu.utn.frbb.tup.input;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cliente;
import ar.edu.utn.frbb.tup.model.Cuenta;
import ar.edu.utn.frbb.tup.model.TipoCuenta;
import ar.edu.utn.frbb.tup.model.TipoPersona;

public class ClienteInputProcessor extends BaseInputProcessor{

    private Banco banco;

    public ClienteInputProcessor(Banco banco) { //constructor 
        this.banco = banco;
    }

    public Cliente ingresarCliente() {

        // Ingreso de datos del Cliente
        Cliente cliente = new Cliente();
        clearScreen();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        // Solicita el DNI al cliente
        System.out.println("Ingrese el DNI del cliente:");
        long dni = scanner.nextLong();
        cliente.setDni(dni);

        // Solicita la fecha de nacimiento al cliente
        LocalDate fechaNacimiento = null;
        boolean fechaValida = false;
        while (!fechaValida) {
            try {
                System.out.println("Ingrese la fecha de nacimiento del cliente (formato: AAAA-MM-DD):");
                fechaNacimiento = LocalDate.parse(scanner.nextLine());
                fechaValida = true; // Si no hay excepción, la fecha es válida
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en el formato especificado.");
            }
        }
        cliente.setFechaNacimiento(fechaNacimiento);

        System.out.println("Ingrese el tipo de persona Física(F) o Jurídica(J):");
        String tipoPersonaStr = scanner.nextLine().toUpperCase();
        while (!tipoPersonaStr.equals("F") && !tipoPersonaStr.equals("J")) {
            System.out.println("Tipo de persona inválido. Ingrese NATURAL o JURIDICA:");
            tipoPersonaStr = scanner.nextLine().toUpperCase();
        }
        TipoPersona tipoPersona = TipoPersona.fromString(tipoPersonaStr);
        cliente.setTipoPersona(tipoPersona);

        System.out.println("Ingrese el banco del cliente:");
        String nombrebanco = scanner.nextLine();
        cliente.setBanco(nombrebanco);

        LocalDate fechaActual = LocalDate.now();
        cliente.setFechaAlta(fechaActual);
               
        boolean emailValido = false;
        String email;
        do {
            System.out.println("Ingrese el email del cliente:");
            email = scanner.nextLine();
            if (validarEmail(email)) {
                cliente.setEmail(email);
                System.out.println("Email válido. Se asignó correctamente.");
                emailValido = true;
            } else {
                System.out.println("Email inválido. Intente nuevamente.");
            }
        } while (!emailValido);

        // Agrega el cliente al conjunto de clientes del banco
        banco.getClientes().add(cliente);

        // Genera un nuevo número de cuenta
        int numeroCuenta = banco.getSiguienteNroCuenta();

        // Crea la cuenta asociada al cliente
        Cuenta CuentaAsociada = new Cuenta();
        CuentaAsociada.setNumero(numeroCuenta);
        CuentaAsociada.setCliente(cliente);
        CuentaAsociada.setFechaCreacion(fechaActual);
        CuentaAsociada.setSaldo(0.0);

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

        CuentaAsociada.setTipoCuenta(tipoCuentaSeleccionado);
        
 
       
        clearScreen();

        System.out.println("Cliente creado:");
        System.out.println(cliente);
        System.out.println(CuentaAsociada);
      
        return cliente;
    }

    public boolean validarEmail(String email) {
        // Expresión regular para validar el formato de email
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Verifica si el email coincide con la expresión regular
        return email.matches(regex);
    }
}
