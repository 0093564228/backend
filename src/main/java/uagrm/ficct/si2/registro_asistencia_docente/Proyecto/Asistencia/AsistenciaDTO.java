package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaDTO {
  private Integer id;
  private LocalDateTime horario_inicio;
  private LocalDateTime horario_fin;
  @Enumerated(EnumType.STRING)
  Estado estado;
  /*private String estado;*/
  private ProgramacionDTO programacionDTO;
}
