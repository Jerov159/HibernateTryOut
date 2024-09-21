package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "facultades")
public class Facultad {

    @Column(name = "idfacultad")
    //para definir llave primaria
    @Id
    //para campos autoIncrementables
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String abreviatura;

    //Constructor Vacío
    public Facultad() {
    }

    //Constructor
    public Facultad(Long id, String nombre, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    //ToString
    @Override
    public String toString() {
        return "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura;
    }
}
