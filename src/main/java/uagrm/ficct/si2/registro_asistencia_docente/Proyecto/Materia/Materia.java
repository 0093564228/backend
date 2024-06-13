package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;


import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String sigla;

    @ManyToOne()
    @JoinColumn(name = "carrera_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private Carrera carrera;

    /*2*/
    @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    /*@JsonManagedReference*/
    private List<Programacion> programaciones;

    public Materia(Integer id, String nombre, String sigla, Object o) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
    }

    /*@ManyToMany(mappedBy = "materias")
    @JsonManagedReference
    private List<Grupo> grupos;*/

    /*1*/
   /* @ManyToMany
    @JoinTable(
            name = "programacion",
            joinColumns = @JoinColumn(name = "materias_id"),
            inverseJoinColumns = @JoinColumn(name = "grupos_id")
    )
    *//*@JsonManagedReference*//*
    private List<Grupo> grupos;*/
}
