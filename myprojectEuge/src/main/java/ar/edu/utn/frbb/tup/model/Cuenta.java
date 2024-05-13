package ar.edu.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Cuenta {
    private int numero; //numero de cuenta
    private Cliente cliente; // Aca almacenamos el cliente asociado a esta cuenta
    private LocalDate fechaCreacion;
    private double saldo;
    private TipoCuenta tipoCuenta;
    private List<MovimientoCuenta> movimientos;

    public Cuenta(int numero, String nombre, Cliente cliente, LocalDate fechaCreacion, TipoCuenta tipoCuenta) {
        this.numero = numero;
        this.cliente = cliente; // Asignamos el cliente asociado al crear la cuenta
        this.fechaCreacion = fechaCreacion;
        this.tipoCuenta = tipoCuenta;
        this.saldo = 0; // Inicializamos el saldo en 0
        this.movimientos = new ArrayList<>(); // Inicializamos la lista de movimientos
    }

    public int getNumero() {
        return numero;
    }

    public Cuenta setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public Cuenta() {
       
    }



    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Cuenta setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
        return this;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cuenta setSaldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Cuenta setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<MovimientoCuenta> getMovimientos() {
        return movimientos;
    }
    
    public void registrarMovimiento() {
        // Crea una instancia de MovimientoCuenta y agrega a la lista de movimientos
        MovimientoCuenta movimiento = new MovimientoCuenta();
        movimientos.add(movimiento);
    }

    @Override
    public String toString() {
        return "Número de cuenta: " + numero +
                ", Tipo de cuenta: " + tipoCuenta +
                ", Saldo: " + saldo +
                ", Fecha de apertura: " + fechaCreacion;
    }


    

}
