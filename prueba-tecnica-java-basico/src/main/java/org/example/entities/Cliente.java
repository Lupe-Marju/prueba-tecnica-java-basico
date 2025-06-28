package org.example.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 30)
    private String nombre;

    @Column (nullable = false, length = 30)
    private String apellidos;

    @Enumerated
    private Sexo sexo;

    @Column (nullable = false, length = 30)
    private String ciudad;

    @Temporal(TemporalType.DATE)
    @Column (nullable = false)
    private LocalDate fechaNacimiento;

    @Column (nullable = false, length = 9)
    private String telefono;

    @Column (nullable = false, unique = true ,length = 40)
    private String correoElectronico;

    //constructores
    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, Sexo sexo, String ciudad, LocalDate fechaNacimiento, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }
    //getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    //to String - Frase al llamar a la clase
    @Override
    public String toString() {
        return "ID " + id + ". " + nombre + " " + apellidos + ", " + sexo.getDescripcion() + " con fecha de nacimiento " + fechaNacimiento + " que vive en " + ciudad + " con teléfono " + telefono + " con email " + correoElectronico;
    }
}
