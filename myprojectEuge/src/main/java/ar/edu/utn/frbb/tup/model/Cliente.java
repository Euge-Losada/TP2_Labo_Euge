package ar.edu.utn.frbb.tup.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona{

    private long id;
    private TipoPersona tipoPersona;
    private String banco;
    private LocalDate fechaAlta;
    private Set<Cuenta> cuentas = new HashSet<>();
    private String email;

    public long getId() {
        return id;
    }
    
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void modificarCliente(Cliente cliente) {
        this.setNombre(cliente.getNombre());
        this.setApellido(cliente.getApellido());
        this.setDni(cliente.getDni());
        this.setFechaNacimiento(cliente.getFechaNacimiento());
        this.setDomicilio(cliente.getDomicilio());
        this.setTelefono(cliente.getTelefono());
        this.setEmail(cliente.getEmail());
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", dni=" + getDni() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                '}';
    }

}