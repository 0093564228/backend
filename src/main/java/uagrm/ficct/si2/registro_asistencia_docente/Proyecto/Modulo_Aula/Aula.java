package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    /*@OneToMany(mappedBy = "aula",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProgramacionAcademica> programacionAcademicas;*/
}