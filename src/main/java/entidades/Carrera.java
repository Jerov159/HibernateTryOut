package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Column(name = "idcarrera")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer tipo;

    // Relación con la tabla facultades
    @ManyToOne
    @JoinColumn(name = "idfacultad", referencedColumnName = "idfacultad")
    private Facultad facultad;

    public Carrera() {
    }

    public Carrera(Long id, String nombre, Integer tipo, Facultad facultad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.facultad = facultad;
    }

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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", facultad=" + facultad +
                '}';
    }
}
