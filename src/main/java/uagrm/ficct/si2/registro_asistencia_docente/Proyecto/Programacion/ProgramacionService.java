package uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Programacion;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.Grupo;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Grupo.GrupoDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.Materia;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Materia.MateriaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.Aula;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Aula.AulaDTO;
import uagrm.ficct.si2.registro_asistencia_docente.Proyecto.Usuario.UserDTO;
import uagrm.ficct.si2.registro_asistencia_docente.User.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramacionService {

  private ProgramacionRepository programacionRepository;

  public List<ProgramacionDTO> findAll() {
    List<Programacion> programaciones = programacionRepository.findAll();
    return programaciones.stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
  }

  public Optional<ProgramacionDTO> findById(Integer id) {
    Optional<Programacion> optionalProgramacion = programacionRepository.findById(id);
    return optionalProgramacion.map(this::convertToDto);
  }

  public ProgramacionDTO save(ProgramacionDTO programacionDTO) {
    Programacion programacion = convertToEntity(programacionDTO);
    programacion = programacionRepository.save(programacion);
    return convertToDto(programacion);
  }

  public void deleteById(Integer id) {
    programacionRepository.deleteById(id);
  }

  public ProgramacionDTO update(Integer id, ProgramacionDTO programacionDTO) {
    Programacion existingProgramacion = programacionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Programacion not found with id " + id));

    existingProgramacion.setHorario_inicio(programacionDTO.getHorario_inicio());
    existingProgramacion.setHorario_fin(programacionDTO.getHorario_fin());

    // Aquí debes manejar las actualizaciones de las entidades relacionadas (Materia, Grupo, Aula, User)
    // Dependiendo de tu lógica de negocio y cómo quieras manejar las actualizaciones.

    Programacion updatedProgramacion = programacionRepository.save(existingProgramacion);
    return convertToDto(updatedProgramacion);
  }

  private ProgramacionDTO convertToDto(Programacion programacion) {
    MateriaDTO materiaDTO = programacion.getMateria() != null ?
            new MateriaDTO(programacion.getMateria().getId(), programacion.getMateria().getNombre(), programacion.getMateria().getSigla(), null) :
            null;

    GrupoDTO grupoDTO = programacion.getGrupo() != null ?
            new GrupoDTO(programacion.getGrupo().getId(), programacion.getGrupo().getNombre()) :
            null;

    AulaDTO aulaDTO = programacion.getAula() != null ?
            new AulaDTO(programacion.getAula().getId(), programacion.getAula().getNombre()) :
            null;

    UserDTO userDTO = programacion.getUser() != null ?
            new UserDTO(programacion.getUser().getId(), programacion.getUser().getUsername(), programacion.getUser().getLastname(), programacion.getUser().getFirstname(), programacion.getUser().getCountry(), null) :
            null;

    return new ProgramacionDTO(programacion.getId(), programacion.getHorario_inicio(), programacion.getHorario_fin(),programacion.getDia(), materiaDTO, grupoDTO, aulaDTO, userDTO);
  }

  private Programacion convertToEntity(ProgramacionDTO programacionDTO) {
    Materia materia = new Materia(programacionDTO.getMateriaDTO().getId(), programacionDTO.getMateriaDTO().getNombre(), programacionDTO.getMateriaDTO().getSigla(), null /* No se asigna carrera en este contexto */);
    Grupo grupo = new Grupo(programacionDTO.getGrupoDTO().getId(), programacionDTO.getGrupoDTO().getNombre());
    Aula aula = new Aula(programacionDTO.getAulaDTO().getId(), programacionDTO.getAulaDTO().getNombre());
    User user = new User(programacionDTO.getUserDTO().getId(), programacionDTO.getUserDTO().getUsername(), programacionDTO.getUserDTO().getLastname(), programacionDTO.getUserDTO().getFirstname(), programacionDTO.getUserDTO().getCountry(), null /* Password no debería ser asignado directamente */);
    return new Programacion(programacionDTO.getId(), programacionDTO.getHorario_inicio(), programacionDTO.getHorario_fin(),programacionDTO.getDia(), materia, grupo, aula, user, null /* Asistencias no se manejan aquí */);
  }
}








