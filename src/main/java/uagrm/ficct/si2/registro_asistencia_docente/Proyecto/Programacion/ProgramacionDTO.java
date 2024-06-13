package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;


import lombok.*;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Asistencia.Asistencia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Modulo_Aula.AulaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramacionDTO {
  private Integer id;
  private LocalDateTime horario_inicio;
  private LocalDateTime horario_fin;
  private MateriaDTO materiaDTO;
  private GrupoDTO grupoDTO;
  private AulaDTO aulaDTO;
  private UserDTO userDTO;
}
/*private List<Asistencia> asistencias;*/
