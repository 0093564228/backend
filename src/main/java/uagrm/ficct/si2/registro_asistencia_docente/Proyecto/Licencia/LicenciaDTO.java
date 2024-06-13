package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Licencia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LicenciaDTO {
  private Integer id;
  private LocalDateTime horario_inicio;
  private LocalDateTime horario_fin;
  private String motivo;
  private UserDTO userDTO;
}
