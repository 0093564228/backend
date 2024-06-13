package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.Carrera;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Carrera.CarreraDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.Programacion;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion.ProgramacionDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MateriaDTO {
  private Integer id;
  private String nombre;
  private String sigla;
  private CarreraDTO carreraDTO;
}
/*private List<ProgramacionDTO> programacionDTOS;*/
