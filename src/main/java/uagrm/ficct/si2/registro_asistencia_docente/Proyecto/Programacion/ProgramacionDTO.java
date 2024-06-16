package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;


import lombok.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.AulaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacionDTO {
  private Integer id;
  /*private LocalDateTime horario_inicio;
  private LocalDateTime horario_fin;*/
  private LocalTime horario_inicio;
  private LocalTime horario_fin;
  Dia dia;
  private MateriaDTO materiaDTO;
  private GrupoDTO grupoDTO;
  private AulaDTO aulaDTO;
  private UserDTO userDTO;

}
/*private List<Asistencia> asistencias;*/
