package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    @OneToMany(mappedBy = "aula",cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    /*@JsonManagedReference*/
    private List<Programacion> programaciones;
}
