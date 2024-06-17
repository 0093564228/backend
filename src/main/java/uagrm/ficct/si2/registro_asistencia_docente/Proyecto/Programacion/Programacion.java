package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.Asistencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

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
  private LocalTime horario_inicio;

  @Column
  private LocalTime horario_fin;

  /*@Column
  private LocalDateTime horario_inicio;
  */

  @Enumerated(EnumType.STRING)
  Dia dia;

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