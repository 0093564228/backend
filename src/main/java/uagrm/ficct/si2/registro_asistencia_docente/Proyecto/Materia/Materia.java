package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Carrera carrera;

   /* @OneToMany(mappedBy = "materia",cascade = CascadeType.ALL*//*, orphanRemoval = true*//*)
    @JsonManagedReference
    private List<Programacion> programaciones;*/

    /*@ManyToMany(mappedBy = "materias")
    @JsonManagedReference
    private List<Grupo> grupos;*/


    @ManyToMany
    @JoinTable(
            name = "programacion",
            /*joinColumns = @JoinColumn(name = "materias_id"),*/
            inverseJoinColumns = @JoinColumn(name = "grupos_id")
    )
    /*@JsonManagedReference*/
    private List<Grupo> grupos;
}
