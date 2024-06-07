package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;


import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;


    /*@OneToMany(mappedBy = "grupo",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Programacion> programaciones;*/

    /*@ManyToMany(mappedBy = "grupos")
    @JsonManagedReference
    private Set<Programacion> programaciones;*/

    /*@ManyToMany
    @JoinTable(
            name = "programacion",
            *//*joinColumns = @JoinColumn(name = "grupo_id"),*//*
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias;*/

    @ManyToMany(mappedBy = "grupos")
    /*@JsonManagedReference*/
    /*@JsonBackReference*/
    private List<Materia> materias;
}
