package ar.edu.utn.frbb.tup.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes = new ArrayList<>();

    private List<Cuenta> cuentas = new ArrayList<>();
    private int siguientenumeroCuenta=1;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cuenta getCuenta(int numeroCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNumero() == numeroCuenta) {
                return cuenta;
            }
        }
        return null; // Retorna null si no se encuentra la cuenta
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public int getSiguienteNroCuenta() {
        siguientenumeroCuenta+=1;
        return siguientenumeroCuenta;
    }

    public void imprimirDatosCuentas() {
        System.out.println("Datos de las cuentas del banco:");
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta.toString());
        }
    }


}

