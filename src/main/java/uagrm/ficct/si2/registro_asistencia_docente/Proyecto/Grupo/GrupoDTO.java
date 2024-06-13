package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoDTO {
  private Integer id;
  private String nombre;
}
/*private List<ProgramacionDTO> programacionDTOS;*/
