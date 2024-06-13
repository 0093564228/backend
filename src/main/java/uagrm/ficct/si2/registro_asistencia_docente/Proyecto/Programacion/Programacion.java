package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.Asistencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Facultad.Facultad;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia.Licencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
public class Programacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private LocalDateTime horario_inicio;

  @Column
  private LocalDateTime horario_fin;

  @ManyToOne
  @JoinColumn(name = "materia_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private Materia materia;

  @ManyToOne
  @JoinColumn(name = "grupo_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private Grupo grupo;

  @ManyToOne
  @JoinColumn(name = "aula_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private Aula aula;

  @ManyToOne
  @JoinColumn(name = "user_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private User user;

  @OneToMany(mappedBy = "programacion", cascade = CascadeType.ALL)
  private List<Asistencia> asistencias;
}