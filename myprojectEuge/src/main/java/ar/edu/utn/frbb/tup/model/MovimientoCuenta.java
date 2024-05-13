package ar.edu.utn.frbb.tup.model;

import java.time.LocalDate;

public class MovimientoCuenta {
    private LocalDate fechaHora;
    private String tipoOperacion;
    private double monto;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;

    public MovimientoCuenta(LocalDate fechaHora, String tipoOperacion, double monto, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
    }
    
    public MovimientoCuenta() {

    }
    
    // Métodos getter y setter
    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }



    

    
}

