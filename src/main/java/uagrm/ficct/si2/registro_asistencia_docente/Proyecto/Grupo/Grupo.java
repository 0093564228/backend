package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    /*2*/
    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    /*@JsonManagedReference*/
    private List<Programacion> programaciones;

    public Grupo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

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

    /*1*/
  /*  @ManyToMany(mappedBy = "grupos")
    *//*@JsonManagedReference*//*
    @JsonBackReference
    private List<Materia> materias;*/
}
