package com.example.actividad;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "cuenta")
public class Cuenta{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_cuenta;
    private String numero_cuenta;
    private String nombre;
    private String email;

    public Cuenta(String numero_cuenta, String nombre, String email, Long id_cuenta) {
        super ();
        this.email = email;
        this.id_cuenta = id_cuenta;
        this.nombre = nombre;
        this.numero_cuenta = numero_cuenta;
    }

    public Cuenta() {}

    public Long getId(){
        return id_cuenta;
    };

    public String getnumero_cuenta() {
        return numero_cuenta;
    };

    public String getNombre() {
        return nombre;
    };

    public String getEmail() {
        return email;
    };

    public void setId(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setnumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    };

    public void setNombre(String nombre) {
        this.nombre = nombre;
    };

    public void setEmail(String email) {
        this.email = email;
    };

    @Override
    public String toString() {
        return "Cuenta [id_cuenta=" + id_cuenta + ", numero_cuenta=" + numero_cuenta + ", nombre=" + nombre + ", email=" + email;
    };
}
