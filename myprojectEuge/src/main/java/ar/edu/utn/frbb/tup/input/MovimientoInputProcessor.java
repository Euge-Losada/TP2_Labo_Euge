package ar.edu.utn.frbb.tup.input;

import java.time.LocalDate;
import java.util.Scanner;
import ar.edu.utn.frbb.tup.model.MovimientoCuenta;
import ar.edu.utn.frbb.tup.model.Banco;
import ar.edu.utn.frbb.tup.model.Cuenta;

public class MovimientoInputProcessor extends BaseInputProcessor {
    private Cuenta cuenta;
    private Banco banco;
    private Scanner scanner = new Scanner(System.in);

    public MovimientoInputProcessor(Cuenta cuenta, Banco banco) {
        this.cuenta = cuenta;
        this.banco = banco;
    }

    public MovimientoCuenta registrarMovimientoCuenta() {
        MovimientoCuenta nuevoMovimiento = new MovimientoCuenta();
        LocalDate fechaActual = LocalDate.now();
        nuevoMovimiento.setFechaHora(fechaActual);

        System.out.println("Seleccione tipo de operacion a realizar: 1) Depósito, 2) Extracción, 3) Transferencia");
        String opcionTipoOperacion = scanner.nextLine();
        double monto = 0.0;

        if (opcionTipoOperacion.equals("1")) {
            nuevoMovimiento.setTipoOperacion("DEPÓSITO");
            System.out.println("Ingrese la cuenta a depositar:");
            
            getCuenta().setSaldo(getCuenta().getSaldo() + monto);
            System.out.println("Ingrese monto:");
            monto = ingresarMonto();
            nuevoMovimiento.setMonto(monto);
            nuevoMovimiento.setCuentaDestino(getCuenta());
            nuevoMovimiento.setCuentaOrigen(null);
            System.out.println("El depósito se realizó con éxito");
        } else if (opcionTipoOperacion.equals("2")) {
            nuevoMovimiento.setTipoOperacion("EXTRACCIÓN");
            System.out.println("Ingrese monto:");
            monto = ingresarMonto();
            if (montoMenorQueCantidadDisponible(monto)) {
                nuevoMovimiento.setMonto(monto);
                nuevoMovimiento.setCuentaOrigen(getCuenta());
                getCuenta().setSaldo(getCuenta().getSaldo() - monto);
                System.out.println("La extracción se realizó con éxito");
            } else {
                System.out.println("El monto es mayor que el saldo disponible.");
                
            }
        } else if (opcionTipoOperacion.equals("3")) {
            nuevoMovimiento.setTipoOperacion("TRANSFERENCIA");
            System.out.println("Ingrese monto:");
            monto = ingresarMonto();
            if (montoMenorQueCantidadDisponible(monto)) {
                nuevoMovimiento.setMonto(monto);
                nuevoMovimiento.setCuentaOrigen(getCuenta());
                System.out.println("Ingrese la cuenta de destino:");
                nuevoMovimiento.setCuentaDestino(obtenerCuentaDestino());
                getCuenta().setSaldo(getCuenta().getSaldo() - monto);
                nuevoMovimiento.getCuentaDestino().setSaldo(nuevoMovimiento.getCuentaDestino().getSaldo() + monto);
                System.out.println("La transferencia se realizó con éxito");
            } else {
                System.out.println("El monto es mayor que el saldo disponible.");
                
            }
        }

        return nuevoMovimiento;
    }

    public Cuenta getCuenta() {
        System.out.println("Cuenta: " + cuenta.getNumero());
        
        for (Cuenta cuentaEnBanco : banco.getCuentas()) {
            if (cuentaEnBanco.getNumero() == this.cuenta.getNumero()) {
                return cuentaEnBanco;
            }
        }
        return null; // Si no se encuentra la cuenta en el banco
    }

    public double ingresarMonto() {
        return scanner.nextDouble();
    }

    public boolean montoMenorQueCantidadDisponible(double monto) {
        return monto <= cuenta.getSaldo();
    }

    public Cuenta obtenerCuentaDestino() {
        System.out.println("Ingrese el número de cuenta de destino:");
        int numeroCuentaDestino = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        for (Cuenta cuenta : banco.getCuentas()) {
            if (cuenta.getNumero() == numeroCuentaDestino) {
                return cuenta;
            }
        }
        System.out.println("La cuenta de destino no existe.");
        return null;
    }
}
