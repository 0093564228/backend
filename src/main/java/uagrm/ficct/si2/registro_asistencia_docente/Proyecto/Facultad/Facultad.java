package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Facultad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column/*(nullable = false)*/
    private String nombre;
    @Column/*(nullable = false)*/
    private String modulo;

    @OneToMany(mappedBy = "facultad",cascade = CascadeType.ALL/*, orphanRemoval = true*/)
    /*@JsonManagedReference*/
    private List<Carrera> carreras;

}