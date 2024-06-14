package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

public class ProgramacionMapper {
  /*public static ProgramacionDTO toDTO(Programacion programacion) {
    ProgramacionDTO dto = new ProgramacionDTO();
    dto.setId(programacion.getId());
    dto.setHorario_inicio(programacion.getHorario_inicio());
    dto.setHorario_fin(programacion.getHorario_fin());
    dto.setMateriaId(programacion.getMateria().getId());
    dto.setGrupoId(programacion.getGrupo().getId());
    dto.setAulaId(programacion.getAula().getId());
    dto.setUserId(programacion.getUser().getId());
    return dto;
  }*/

  public static Programacion toEntity(ProgramacionDTO dto, Materia materia, Grupo grupo, Aula aula, User user) {
    Programacion programacion = new Programacion();
    programacion.setId(dto.getId());
    programacion.setHorario_inicio(dto.getHorario_inicio());
    programacion.setHorario_fin(dto.getHorario_fin());
    programacion.setMateria(materia);
    programacion.setGrupo(grupo);
    programacion.setAula(aula);
    programacion.setUser(user);
    return programacion;
  }

}
