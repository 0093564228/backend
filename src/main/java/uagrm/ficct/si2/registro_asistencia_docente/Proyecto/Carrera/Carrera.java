package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import lombok.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "facultad_id"/*, nullable = false*/)
    /*@JsonBackReference*/
    private Facultad facultad;

    @OneToMany(mappedBy = "carrera",cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    /*@JsonManagedReference*/
    private List<Materia> materias;

}