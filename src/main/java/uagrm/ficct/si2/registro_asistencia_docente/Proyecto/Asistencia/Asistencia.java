package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asistencia {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column
  private LocalDateTime horario_inicio;

  @Column
  private LocalDateTime horario_fin;

  @Column
  private String estado;

  @ManyToOne
  @JoinColumn(name = "programacion_id"/*, nullable = false*/)
  /*@JsonBackReference*/
  private Programacion programacion;
}
