package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Licencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private LocalDateTime horario_inicio;

  @Column
  private LocalDateTime horario_fin;

  @Column
  private String motivo;

  @ManyToOne
  @JoinColumn(name = "docente_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private User user;
}
